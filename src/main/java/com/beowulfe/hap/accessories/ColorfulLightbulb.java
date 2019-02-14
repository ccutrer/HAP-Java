package com.beowulfe.hap.accessories;

import com.beowulfe.hap.accessories.characteristics.Color;
import java.util.Optional;

/**
 * Extends {@link com.beowulfe.hap.accessories.Lightbulb} with color settings. This will usually be
 * implemented along with {@link DimmableLightbulb}, but not necessarily so.
 *
 * @author Andy Lintner
 */
@Deprecated
public interface ColorfulLightbulb extends Lightbulb, Color {
  @Override
  default Optional<Color> getColorCharacteristics() {
    return Optional.of(this);
  }
}
