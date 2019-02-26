package com.beowulfe.hap.accessories.characteristics;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import java.util.concurrent.CompletableFuture;

public interface TamperedStatus {
  /**
   * Queries if the device has been tampered with.
   *
   * @return a future that will contain the accessory's tampered state
   */
  CompletableFuture<Boolean> getTamperedState();

  /**
   * Subscribes to changes in the tamper state.
   *
   * @param callback the function to call when tamper state changes.
   */
  void subscribeTamperedState(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the tamper state. */
  void unsubscribeTamperedState();
}
