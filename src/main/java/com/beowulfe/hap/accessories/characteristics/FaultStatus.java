package com.beowulfe.hap.accessories.characteristics;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import java.util.concurrent.CompletableFuture;

public interface FaultStatus {
  /**
   * Queries if the device has a fault.
   *
   * @return a future that will contain the accessory's fault state
   */
  CompletableFuture<Boolean> getFaultState();

  /**
   * Subscribes to changes in the fault state.
   *
   * @param callback the function to call when fault state changes.
   */
  void subscribeFaultState(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the fault state. */
  void unsubscribeFaultState();
}
