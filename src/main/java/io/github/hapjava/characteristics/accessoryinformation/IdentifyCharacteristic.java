package io.github.hapjava.characteristics.accessoryinformation;

import java.util.Optional;

import io.github.hapjava.characteristics.BooleanCharacteristic;
import io.github.hapjava.impl.ExceptionalConsumer;

public class IdentifyCharacteristic extends BooleanCharacteristic {

  public IdentifyCharacteristic(ExceptionalConsumer<Boolean> setter) throws Exception {
    super(
        "00000014-0000-1000-8000-0026BB765291",
        "Identifies the accessory via a physical action on the accessory",
        Optional.empty(),
        Optional.of(setter),
        Optional.empty(),
        Optional.empty());
  }
}
