package io.github.hapjava.services;

import io.github.hapjava.accessories.Switch;
import io.github.hapjava.characteristics.common.PowerStateCharacteristic;

public class SwitchService extends AbstractServiceImpl {

  public SwitchService(Switch switchAccessory) {
    this(switchAccessory, switchAccessory.getLabel());
  }

  public SwitchService(Switch switchAccessory, String serviceName) {
    super("00000049-0000-1000-8000-0026BB765291", switchAccessory, serviceName);
    addCharacteristic(
        new PowerStateCharacteristic(
            () -> switchAccessory.getSwitchState(),
            v -> switchAccessory.setSwitchState(v),
            c -> switchAccessory.subscribeSwitchState(c),
            () -> switchAccessory.unsubscribeSwitchState()));
  }
}
