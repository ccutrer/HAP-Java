package io.github.hapjava.characteristics.accessoryinformation;

import io.github.hapjava.HomekitAccessory;
import io.github.hapjava.characteristics.StaticStringCharacteristic;

public class HardwareRevisionCharacteristic extends StaticStringCharacteristic {

  public HardwareRevisionCharacteristic(HomekitAccessory accessory) throws Exception {
    super(
        "00000053-0000-1000-8000-0026BB765291",
        "Hardware revision",
        accessory.getHardwareRevision());
  }
}
