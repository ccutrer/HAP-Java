package com.beowulfe.hap.impl.characteristics.garage;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.GarageDoor;
import com.beowulfe.hap.characteristics.EnumCharacteristic;
import com.beowulfe.hap.characteristics.EventableCharacteristic;
import java.util.concurrent.CompletableFuture;

public class TargetDoorStateCharacteristic extends EnumCharacteristic
    implements EventableCharacteristic {

  private final GarageDoor door;

  public TargetDoorStateCharacteristic(GarageDoor door) {
    super("0000000E-0000-1000-8000-0026BB765291", false, true, null, 4);
    this.door = door;
  }

  @Override
  protected void setValue(Integer value) throws Exception {
    // Read Only
  }

  @Override
  protected CompletableFuture<Integer> getValue() {
    return door.getCurrentDoorState().thenApply(s -> s.getCode());
  }

  @Override
  public void subscribe(HomekitCharacteristicChangeCallback callback) {
    door.subscribeCurrentDoorState(callback);
  }

  @Override
  public void unsubscribe() {
    door.unsubscribeCurrentDoorState();
  }
}
