package com.beowulfe.hap.accessories;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import java.util.concurrent.CompletableFuture;

/**
 * An accessory that runs on batteries. Accessories that run on batteries are able to report battery
 * level.
 *
 * @author Tim Harper
 */
public interface BatteryStatusAccessory {

  /**
   * Queries if this accessory actually supports battery status.
   *
   * <p>This is useful to build a single concrete class that can optionally and dynamically support
   * battery status or not, depending on the backing object.
   *
   * @return if the BatteryStatusAccessory interface should be used
   */
  default boolean supportsBatteryStatus() {
    return true;
  }

  /**
   * Queries if the device battery level is low; returning a value of true will cause a low-battery
   * status to appear in Home for the device.
   *
   * @return a future that will contain the accessory's low battery state
   */
  CompletableFuture<Boolean> getLowBatteryState();

  /**
   * Subscribes to changes in the battery level.
   *
   * @param callback the function to call when low battery state changes.
   */
  void subscribeLowBatteryState(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the low battery state. */
  void unsubscribeLowBatteryState();
}
