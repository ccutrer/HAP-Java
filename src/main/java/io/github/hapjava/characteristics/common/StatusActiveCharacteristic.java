package io.github.hapjava.characteristics.common;

import io.github.hapjava.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.BooleanCharacteristic;
import io.github.hapjava.impl.ExceptionalConsumer;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StatusActiveCharacteristic extends BooleanCharacteristic {
  public StatusActiveCharacteristic(
      Supplier<CompletableFuture<Boolean>> getter,
      ExceptionalConsumer<Boolean> setter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "00000075-0000-1000-8000-0026BB765291",
        "Accessory active and functioning",
        Optional.of(getter),
        Optional.empty(),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}
