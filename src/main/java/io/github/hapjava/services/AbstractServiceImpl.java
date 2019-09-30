package io.github.hapjava.services;

import io.github.hapjava.Service;
import io.github.hapjava.characteristics.Characteristic;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractServiceImpl implements Service {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final String type;
  private final List<Characteristic> characteristics = new LinkedList<>();

  /**
   * @param type unique UUID of the service. This information can be obtained from HomeKit Accessory
   *     Simulator.
   */
  public AbstractServiceImpl(String type) {
	  this.type = type;
  }

  @Override
  public List<Characteristic> getCharacteristics() {
    return Collections.unmodifiableList(characteristics);
  }

  @Override
  public String getType() {
    return type;
  }

  protected void addCharacteristic(Characteristic characteristic) {
    this.characteristics.add(characteristic);
  }
}
