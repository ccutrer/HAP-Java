package com.beowulfe.hap.impl.services;

import com.beowulfe.hap.accessories.AbstractSensor;
import com.beowulfe.hap.impl.characteristics.common.FaultCharacteristic;
import com.beowulfe.hap.impl.characteristics.common.LowBatteryStatusCharacteristic;
import com.beowulfe.hap.impl.characteristics.common.TamperedCharacteristic;

public class AbstractSensorServiceImpl extends AbstractServiceImpl {
  public AbstractSensorServiceImpl(String type, AbstractSensor sensor, String serviceName) {
    super(type, sensor, serviceName);

    sensor
        .getLowBatteryStatusCharacteristic()
        .ifPresent(
            status ->
                addCharacteristic(
                    new LowBatteryStatusCharacteristic(
                        status::getLowBatteryState,
                        status::subscribeLowBatteryState,
                        status::unsubscribeLowBatteryState)));

    sensor
        .getTamperedStatusCharacteristic()
        .ifPresent(
            status ->
                addCharacteristic(
                    new TamperedCharacteristic(
                        status::getTamperedState,
                        status::subscribeTamperedState,
                        status::unsubscribeTamperedState)));

    sensor
        .getFaultStatusCharacteristic()
        .ifPresent(
            status ->
                addCharacteristic(
                    new FaultCharacteristic(
                        status::getFaultState,
                        status::subscribeFaultState,
                        status::unsubscribeFaultState)));
  }
}
