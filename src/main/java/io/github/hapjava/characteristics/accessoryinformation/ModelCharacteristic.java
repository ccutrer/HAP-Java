package io.github.hapjava.characteristics.accessoryinformation;

import io.github.hapjava.characteristics.StaticStringCharacteristic;

public class ModelCharacteristic extends StaticStringCharacteristic {

  public ModelCharacteristic(String value) throws Exception {
    super("00000021-0000-1000-8000-0026BB765291", "The name of the model", value);
  }
}
