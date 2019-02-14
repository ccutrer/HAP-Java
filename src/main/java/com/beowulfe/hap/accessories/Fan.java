package com.beowulfe.hap.accessories;

import com.beowulfe.hap.*;
import com.beowulfe.hap.accessories.characteristics.RotationDirection;
import com.beowulfe.hap.accessories.characteristics.RotationSpeed;
import com.beowulfe.hap.impl.services.FanService;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * A fan, with power and rotational characteristics.
 *
 * @author Andy Lintner
 */
public interface Fan extends HomekitAccessory, RotationDirection, RotationSpeed {

  /**
   * Retrieves the current binary state of the fan's power.
   *
   * @return a future that will contain the binary state
   */
  CompletableFuture<Boolean> getFanPower();

  /**
   * Sets the binary state of the fan's power
   *
   * @param state the binary state to set
   * @return a future that completes when the change is made
   * @throws Exception when the change cannot be made
   */
  CompletableFuture<Void> setFanPower(boolean state) throws Exception;

  @Override
  default Collection<Service> getServices() {
    return Collections.singleton(new FanService(this));
  }

  /**
   * Subscribes to changes in the binary state of the fan's power.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeFanPower(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the binary state of the fan's power. */
  void unsubscribeFanPower();

  /** returns the optional implementation of RotationDirection */
  default Optional<RotationDirection> getRotationDirectionCharacteristic() {
    return Optional.of(this);
  }

  /** returns the optional implementation of RotationSpeed */
  default Optional<RotationSpeed> getRotationSpeedCharacteristic() {
    return Optional.of(this);
  }
}
