package com.beowulfe.hap.impl.characteristics.lightbulb;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.DimmableLightbulb;
import com.beowulfe.hap.characteristics.EventableCharacteristic;
import com.beowulfe.hap.characteristics.IntegerCharacteristic;
import java.util.concurrent.CompletableFuture;

public class BrightnessCharacteristic extends IntegerCharacteristic
    implements EventableCharacteristic {

  private final DimmableLightbulb lightbulb;

  public BrightnessCharacteristic(DimmableLightbulb lightbulb) {
    super("00000008-0000-1000-8000-0026BB765291", true, true, null, 0, 100, "%");
    this.lightbulb = lightbulb;
  }

  @Override
  public void subscribe(HomekitCharacteristicChangeCallback callback) {
    lightbulb.subscribeBrightness(callback);
  }

  @Override
  public void unsubscribe() {
    lightbulb.unsubscribeBrightness();
  }

  @Override
  protected void setValue(Integer value) throws Exception {
    lightbulb.setBrightness(value);
  }

  @Override
  protected CompletableFuture<Integer> getValue() {
    return lightbulb.getBrightness();
  }
}
