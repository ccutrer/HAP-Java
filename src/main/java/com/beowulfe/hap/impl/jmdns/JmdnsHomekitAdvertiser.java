package com.beowulfe.hap.impl.jmdns;

import com.beowulfe.hap.AccessoryCategory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmdnsHomekitAdvertiser {

  private static final String SERVICE_TYPE = "_hap._tcp.local.";

  private final JmDNS jmdns;
  private boolean discoverable = true;
  private static final Logger logger = LoggerFactory.getLogger(JmdnsHomekitAdvertiser.class);
  private boolean isAdvertising = false;

  private String label;
  private String mac;
  private int port;
  private int configurationIndex;
  private AccessoryCategory accessoryCategory;

  public JmdnsHomekitAdvertiser(JmDNS jmdns, AccessoryCategory accessoryCategory) {
    this.jmdns = jmdns;
    this.accessoryCategory = accessoryCategory;
  }

  public JmdnsHomekitAdvertiser(InetAddress localAddress, AccessoryCategory accessoryCategory)
      throws UnknownHostException, IOException {
    jmdns = JmDNS.create(localAddress);
    this.accessoryCategory = accessoryCategory;
  }

  public synchronized void advertise(String label, String mac, int port, int configurationIndex)
      throws Exception {
    if (isAdvertising) {
      throw new IllegalStateException("Homekit advertiser is already running");
    }
    this.label = label;
    this.mac = mac;
    this.port = port;
    this.configurationIndex = configurationIndex;

    logger.info("Advertising accessory " + label);

    registerService();

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  logger.info("Stopping advertising in response to shutdown.");
                  jmdns.unregisterAllServices();
                }));
    isAdvertising = true;
  }

  public synchronized void stop() {
    unregisterService();
  }

  public synchronized void setDiscoverable(boolean discoverable) throws IOException {
    if (this.discoverable != discoverable) {
      if (isAdvertising) {
        unregisterService();
      }
      this.discoverable = discoverable;
      if (isAdvertising) {
        logger.info("Re-creating service due to change in discoverability to " + discoverable);
        registerService();
      }
    }
  }

  public synchronized void setConfigurationIndex(int revision) throws IOException {
    if (this.configurationIndex != revision) {
      if (isAdvertising) {
        unregisterService();
      }
      this.configurationIndex = revision;
      if (isAdvertising) {
        logger.info("Re-creating service due to change in configuration index to " + revision);
        registerService();
      }
    }
  }

  private void registerService() throws IOException {
    logger.info("Registering " + SERVICE_TYPE + " on port " + port);
    jmdns.registerService(buildServiceInfo());
  }

  private void unregisterService() {
    jmdns.unregisterService(buildServiceInfo());
  }

  private ServiceInfo buildServiceInfo() {
    Map<String, String> props = new HashMap<>();
    props.put("sf", discoverable ? "1" : "0");
    props.put("id", mac);
    props.put("md", label);
    props.put("c#", Integer.toString(configurationIndex));
    props.put("s#", "1");
    props.put("ff", "0");
    props.put("ci", Integer.toString(accessoryCategory.getCode()));

    return ServiceInfo.create(SERVICE_TYPE, label, port, 1, 1, props);
  }
}
