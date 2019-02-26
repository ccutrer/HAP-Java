package com.beowulfe.hap.accessories.characteristics;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import java.util.concurrent.CompletableFuture;

public interface RotationSpeed {
  /**
   * Retrieves how many speeds the fan has.
   *
   * @return an integer of how speed steps the fan has.
   */
  default int getNumberOfSpeeds() {
    return 100;
  }

  /**
   * Retrieves the current speed of the fan's rotation
   *
   * @return a future that will contain the speed, expressed as an integer between 0 and full speed.
   */
  default CompletableFuture<Integer> getRotationSpeed() {
    return CompletableFuture.completedFuture(getNumberOfSpeeds());
  }

  /**
   * Sets the speed of the fan's rotation
   *
   * @param speed the speed to set, expressed as an integer between 0 and 100.
   * @return a future that completes when the change is made
   * @throws Exception when the change cannot be made
   */
  default CompletableFuture<Void> setRotationSpeed(Integer speed) throws Exception {
    return CompletableFuture.completedFuture(null);
  }

  /**
   * Subscribes to changes in the rotation speed of the fan.
   *
   * @param callback the function to call when the speed changes.
   */
  default void subscribeRotationSpeed(HomekitCharacteristicChangeCallback callback) {}

  /** Unsubscribes from changes in the fan's rotation speed. */
  default void unsubscribeRotationSpeed() {}
}
