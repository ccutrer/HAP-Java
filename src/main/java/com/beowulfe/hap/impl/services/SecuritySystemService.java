package com.beowulfe.hap.impl.services;

import com.beowulfe.hap.accessories.SecuritySystem;
import com.beowulfe.hap.impl.characteristics.common.FaultCharacteristic;
import com.beowulfe.hap.impl.characteristics.common.TamperedCharacteristic;
import com.beowulfe.hap.impl.characteristics.securitysystem.CurrentSecuritySystemStateCharacteristic;
import com.beowulfe.hap.impl.characteristics.securitysystem.SecuritySystemAlarmTypeCharacteristic;
import com.beowulfe.hap.impl.characteristics.securitysystem.TargetSecuritySystemStateCharacteristic;

public class SecuritySystemService extends AbstractServiceImpl {

  public SecuritySystemService(SecuritySystem securitySystem) {
    this(securitySystem, securitySystem.getLabel());
  }

  public SecuritySystemService(SecuritySystem securitySystem, String serviceName) {
    super("0000007E-0000-1000-8000-0026BB765291", securitySystem, serviceName);
    addCharacteristic(new CurrentSecuritySystemStateCharacteristic(securitySystem));
    addCharacteristic(new TargetSecuritySystemStateCharacteristic(securitySystem));
    addCharacteristic(new SecuritySystemAlarmTypeCharacteristic(securitySystem));

    securitySystem
        .getTamperedStatusCharacteristic()
        .ifPresent(
            status ->
                addCharacteristic(
                    new TamperedCharacteristic(
                        status::getTamperedState,
                        status::subscribeTamperedState,
                        status::unsubscribeTamperedState)));

    securitySystem
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
