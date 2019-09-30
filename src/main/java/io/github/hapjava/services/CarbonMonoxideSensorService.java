package io.github.hapjava.services;

import io.github.hapjava.accessories.CarbonMonoxideSensor;
import io.github.hapjava.characteristics.carbonmonoxidesensor.CarbonMonoxideDetectedCharacteristic;
import io.github.hapjava.characteristics.common.NameCharacteristic;
import io.github.hapjava.characteristics.common.StatusActiveCharacteristic;
import io.github.hapjava.characteristics.common.StatusFaultCharacteristic;
import io.github.hapjava.characteristics.common.StatusLowBatteryCharacteristic;
import io.github.hapjava.characteristics.common.StatusTamperedCharacteristic;

public class CarbonMonoxideSensorService extends AbstractServiceImpl {

  public CarbonMonoxideSensorService(CarbonMonoxideDetectedCharacteristic carbonMonoxideDetected) {
    super("0000007F-0000-1000-8000-0026BB765291");
    addCharacteristic(carbonMonoxideDetected);
  }

  public void addOptionalCharacteristic(NameCharacteristic name) {
	  addCharacteristic(name);
  }

  public void addOptionalCharacteristic(StatusActiveCharacteristic statusActive) {
	  addCharacteristic(statusActive);
  }

  public void addOptionalCharacteristic(StatusFaultCharacteristic statusFault) {
	  addCharacteristic(statusFault);
  }

  public void addOptionalCharacteristic(StatusTamperedCharacteristic statusTampered) {
	  addCharacteristic(statusTampered);
  }

  public void addOptionalCharacteristic(StatusLowBatteryCharacteristic statusLowBattery) {
	  addCharacteristic(statusLowBattery);
  }

  public void addOptionalCharacteristic(CarbonMonoxideLevelCharacteristic carbonMonoxideLevel) {
	  addCharacteristic(carbonMonoxideLevel);
  }

  public void addOptionalCharacteristic(CarbonMonoxidePeakLevelCharacteristic carbonMonoxidePeakLevel) {
	  addCharacteristic(carbonMonoxidePeakLevel);
  }
}
