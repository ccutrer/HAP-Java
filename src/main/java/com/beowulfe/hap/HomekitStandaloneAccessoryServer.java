package com.beowulfe.hap;

import com.beowulfe.hap.impl.HomekitWebHandler;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;

/**
 * A server for exposing standalone Homekit accessory (as opposed to a Bridge accessory which
 * contains multiple accessories). Each standalone accessory will have its own pairing information,
 * port, and pin. Instantiate this class via {@link
 * HomekitServer#createStandaloneAccessory(HomekitAuthInfo, HomekitAccessory)}.
 *
 * @author Andy Lintner
 */
public class HomekitStandaloneAccessoryServer {

  private final HomekitRoot root;

  HomekitStandaloneAccessoryServer(
      HomekitAccessory accessory,
      HomekitWebHandler webHandler,
      InetAddress localhost,
      HomekitAuthInfo authInfo)
      throws UnknownHostException, IOException {
    root =
        new HomekitRoot(
            accessory.getLabel(),
            webHandler,
            localhost,
            authInfo,
            accessory.getAccessoryCategory());
    root.addAccessory(accessory);
  }

  HomekitStandaloneAccessoryServer(
      HomekitAccessory accessory,
      HomekitWebHandler webHandler,
      JmDNS jmdns,
      HomekitAuthInfo authInfo)
      throws UnknownHostException, IOException {
    root =
        new HomekitRoot(
            accessory.getLabel(), webHandler, jmdns, authInfo, accessory.getAccessoryCategory());
    root.addAccessory(accessory);
  }

  /** Begins advertising and handling requests for this accessory. */
  public void start() {
    root.start();
  }
}
