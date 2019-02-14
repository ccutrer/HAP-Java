package com.beowulfe.hap.accessories;

import com.beowulfe.hap.accessories.characteristics.Brightness;
import java.util.Optional;

/**
 * Extends {@link Lightbulb} with brightness values.
 *
 * @author Andy Lintner
 */
@Deprecated
public interface DimmableLightbulb extends Lightbulb, Brightness {
  @Override
  default Optional<Brightness> getBrightnessCharacteristic() {
    return Optional.of(this);
  }
}
