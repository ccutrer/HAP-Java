package io.github.hapjava.characteristics.common;

import io.github.hapjava.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.EnumCharacteristic;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StatusTamperedCharacteristic extends EnumCharacteristic<StatusTamperedEnum> {

  public StatusTamperedCharacteristic(
      Supplier<CompletableFuture<StatusTamperedEnum>> getter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "0000007A-0000-1000-8000-0026BB765291",
        "Status Tampered",
        1,
        Optional.of(getter),
        Optional.empty(),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }

  @Override
  protected void setValue(Integer value) {}
}
