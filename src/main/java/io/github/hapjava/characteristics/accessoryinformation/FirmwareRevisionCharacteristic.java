package io.github.hapjava.characteristics.accessoryinformation;

import io.github.hapjava.characteristics.StaticStringCharacteristic;

public class FirmwareRevisionCharacteristic extends StaticStringCharacteristic {

  public FirmwareRevisionCharacteristic(String value) throws Exception {
    super("00000052-0000-1000-8000-0026BB765291", "Firmware revision", value);
  }
}
