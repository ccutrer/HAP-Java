package io.github.hapjava.services;

import io.github.hapjava.accessories.OccupancySensor;
import io.github.hapjava.impl.characteristics.occupancysensor.OccupancyDetectedStateCharacteristic;

public class OccupancySensorService extends AbstractServiceImpl {

  public OccupancySensorService(OccupancySensor occupancySensor) {
    this(occupancySensor, occupancySensor.getLabel());
  }

  public OccupancySensorService(OccupancySensor occupancySensor, String serviceName) {
    super("00000086-0000-1000-8000-0026BB765291", occupancySensor, serviceName);
    addCharacteristic(new OccupancyDetectedStateCharacteristic(occupancySensor));
  }
}
