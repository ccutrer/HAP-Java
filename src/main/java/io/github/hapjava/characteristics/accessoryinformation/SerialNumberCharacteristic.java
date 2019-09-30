package io.github.hapjava.characteristics.accessoryinformation;

import io.github.hapjava.characteristics.StaticStringCharacteristic;

public class SerialNumberCharacteristic extends StaticStringCharacteristic {

  public SerialNumberCharacteristic(String value) throws Exception {
    super(
        "00000030-0000-1000-8000-0026BB765291",
        "The serial number of the accessory",
        value);
  }
}
