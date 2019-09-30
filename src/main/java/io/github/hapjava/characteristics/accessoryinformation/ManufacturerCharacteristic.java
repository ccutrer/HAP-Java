package io.github.hapjava.characteristics.accessoryinformation;

import io.github.hapjava.HomekitAccessory;
import io.github.hapjava.characteristics.StaticStringCharacteristic;

public class ManufacturerCharacteristic extends StaticStringCharacteristic {

  public ManufacturerCharacteristic(String value) throws Exception {
    super(
        "00000020-0000-1000-8000-0026BB765291",
        "The name of the manufacturer",
        value);
  }
}
