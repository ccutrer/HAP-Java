package com.beowulfe.hap.impl.characteristics.thermostat;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.properties.TemperatureUnit;
import com.beowulfe.hap.accessories.thermostat.BasicThermostat;
import com.beowulfe.hap.characteristics.EnumCharacteristic;
import com.beowulfe.hap.characteristics.EventableCharacteristic;
import java.util.concurrent.CompletableFuture;

public class TemperatureUnitsCharacteristic extends EnumCharacteristic
    implements EventableCharacteristic {

  private final BasicThermostat thermostat;

  public TemperatureUnitsCharacteristic(BasicThermostat thermostat) {
    super("00000036-0000-1000-8000-0026BB765291", true, true, null, 1);
    this.thermostat = thermostat;
  }

  @Override
  protected void setValue(Integer value) throws Exception {
    thermostat.setTemperatureUnit(
        value == 1 ? TemperatureUnit.FAHRENHEIT : TemperatureUnit.CELSIUS);
  }

  @Override
  protected CompletableFuture<Integer> getValue() {
    return CompletableFuture.completedFuture(thermostat.getTemperatureUnit().getCode());
  }

  @Override
  public void subscribe(final HomekitCharacteristicChangeCallback callback) {
    thermostat.subscribeTemperatureUnit(callback);
  }

  @Override
  public void unsubscribe() {
    thermostat.unsubscribeTemperatureUnit();
  }
}
