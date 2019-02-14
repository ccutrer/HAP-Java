package com.beowulfe.hap.impl.characteristics.fan;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.characteristics.RotationDirection;
import com.beowulfe.hap.characteristics.EnumCharacteristic;
import com.beowulfe.hap.characteristics.EventableCharacteristic;
import java.util.concurrent.CompletableFuture;

public class RotationDirectionCharacteristic extends EnumCharacteristic
    implements EventableCharacteristic {

  private final RotationDirection fan;

  public RotationDirectionCharacteristic(RotationDirection fan) {
    super("00000028-0000-1000-8000-0026BB765291", true, true, null, 1);
    this.fan = fan;
  }

  @Override
  protected void setValue(Integer value) throws Exception {
    fan.setRotationDirection(
        com.beowulfe.hap.accessories.properties.RotationDirection.fromCode(value));
  }

  @Override
  protected CompletableFuture<Integer> getValue() {
    return fan.getRotationDirection().thenApply(s -> s.getCode());
  }

  @Override
  public void subscribe(HomekitCharacteristicChangeCallback callback) {
    fan.subscribeRotationDirection(callback);
  }

  @Override
  public void unsubscribe() {
    fan.unsubscribeRotationDirection();
  }
}
