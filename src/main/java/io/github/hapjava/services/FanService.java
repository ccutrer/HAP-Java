package io.github.hapjava.services;

import io.github.hapjava.accessories.Fan;
import io.github.hapjava.characteristics.common.PowerStateCharacteristic;
import io.github.hapjava.impl.characteristics.fan.RotationDirectionCharacteristic;
import io.github.hapjava.impl.characteristics.fan.RotationSpeedCharacteristic;

public class FanService extends AbstractServiceImpl {

  public FanService(Fan fan) {
    this(fan, fan.getLabel());
  }

  public FanService(Fan fan, String serviceName) {
    super("00000040-0000-1000-8000-0026BB765291", fan, serviceName);
    addCharacteristic(
        new PowerStateCharacteristic(
            () -> fan.getFanPower(),
            v -> fan.setFanPower(v),
            c -> fan.subscribeFanPower(c),
            () -> fan.unsubscribeFanPower()));
    addCharacteristic(new RotationDirectionCharacteristic(fan));
    addCharacteristic(new RotationSpeedCharacteristic(fan));
  }
}
