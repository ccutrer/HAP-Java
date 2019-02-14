package com.beowulfe.hap.accessories.characteristics;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import java.util.concurrent.CompletableFuture;

public interface RotationDirection {
  /**
   * Retrieves the current rotation direction of the fan.
   *
   * @return a future that will contain the direction
   */
  default CompletableFuture<com.beowulfe.hap.accessories.properties.RotationDirection>
      getRotationDirection() {
    return CompletableFuture.completedFuture(
        com.beowulfe.hap.accessories.properties.RotationDirection.CLOCKWISE);
  }

  /**
   * Sets the rotation direction of the fan
   *
   * @param direction the direction to set
   * @return a future that completes when the change is made
   * @throws Exception when the change cannot be made
   */
  default CompletableFuture<Void> setRotationDirection(
      com.beowulfe.hap.accessories.properties.RotationDirection direction) throws Exception {
    return CompletableFuture.completedFuture(null);
  }

  /**
   * Subscribes to changes in the rotation direction of the fan.
   *
   * @param callback the function to call when the direction changes.
   */
  default void subscribeRotationDirection(HomekitCharacteristicChangeCallback callback) {}

  /** Unsubscribes from changes in the rotation direction of the fan. */
  default void unsubscribeRotationDirection() {}
}
