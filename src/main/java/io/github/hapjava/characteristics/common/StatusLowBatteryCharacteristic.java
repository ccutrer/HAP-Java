package io.github.hapjava.characteristics.common;

import io.github.hapjava.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.EnumCharacteristic;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StatusLowBatteryCharacteristic extends EnumCharacteristic<StatusLowBatteryEnum> {

  public StatusLowBatteryCharacteristic(
      Supplier<CompletableFuture<StatusLowBatteryEnum>> getter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super("00000079-0000-1000-8000-0026BB765291", "Status Low Battery", 1, Optional.of(getter), Optional.empty(), Optional.of(subscriber), Optional.of(unsubscriber));
  }

  @Override
  protected void setValue(Integer value)
  {}
}
