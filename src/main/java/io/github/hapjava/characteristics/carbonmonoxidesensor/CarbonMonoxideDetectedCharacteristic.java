package io.github.hapjava.characteristics.carbonmonoxidesensor;

import io.github.hapjava.HomekitCharacteristicChangeCallback;
import io.github.hapjava.accessories.CarbonMonoxideSensor;
import io.github.hapjava.characteristics.EnumCharacteristic;
import io.github.hapjava.characteristics.EventableCharacteristic;
import java.util.concurrent.CompletableFuture;

public class CarbonMonoxideDetectedCharacteristic extends EnumCharacteristic
    implements EventableCharacteristic {

  public CarbonMonoxideDetectedCharacteristic(CarbonMonoxideSensor carbonMonoxideSensor) {
    super("00000069-0000-1000-8000-0026BB765291", false, true, "Carbon Monoxide Detected", 1);
    this.carbonMonoxideSensor = carbonMonoxideSensor;
  }

  @Override
  protected CompletableFuture<Integer> getValue() {
    return carbonMonoxideSensor
        .getCarbonMonoxideDetectedState()
        .thenApply(CarbonMonoxideDetectedEnum::getCode);
  }

  @Override
  protected void setValue(Integer value) throws Exception {
    // Read Only
  }

  @Override
  public void subscribe(HomekitCharacteristicChangeCallback callback) {
    carbonMonoxideSensor.subscribeCarbonMonoxideDetectedState(callback);
  }

  @Override
  public void unsubscribe() {
    carbonMonoxideSensor.unsubscribeCarbonMonoxideDetectedState();
  }
}
