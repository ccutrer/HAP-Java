package com.beowulfe.hap.accessories;

import com.beowulfe.hap.AccessoryCategory;
import com.beowulfe.hap.HomekitAccessory;
import com.beowulfe.hap.accessories.characteristics.FaultStatus;
import com.beowulfe.hap.accessories.characteristics.LowBatteryStatus;
import com.beowulfe.hap.accessories.characteristics.TamperedStatus;
import java.util.Optional;

/**
 * A several characteristics that are shared among all Sensor type accessories
 *
 * @author Cody Cutrer initial contribution
 */
public interface AbstractSensor extends HomekitAccessory {
  /** returns the optional implementation of LowBatteryStatus */
  default Optional<LowBatteryStatus> getLowBatteryStatusCharacteristic() {
    Optional<LowBatteryStatus> result = Optional.empty();
    return result;
  }

  /** returns the optional implementation of TamperedStatus */
  default Optional<TamperedStatus> getTamperedStatusCharacteristic() {
    Optional<TamperedStatus> result = Optional.empty();
    return result;
  }

  /** returns the optional implementation of FaultStatus */
  default Optional<FaultStatus> getFaultStatusCharacteristic() {
    Optional<FaultStatus> result = Optional.empty();
    return result;
  }

  default AccessoryCategory getAccessoryCategory() {
    return AccessoryCategory.SENSOR;
  }
}
