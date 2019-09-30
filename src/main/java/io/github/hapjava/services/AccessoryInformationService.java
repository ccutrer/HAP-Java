package io.github.hapjava.services;

import io.github.hapjava.HomekitAccessory;
import io.github.hapjava.characteristics.accessoryinformation.FirmwareRevisionCharacteristic;
import io.github.hapjava.characteristics.accessoryinformation.HardwareRevisionCharacteristic;
import io.github.hapjava.characteristics.accessoryinformation.IdentifyCharacteristic;
import io.github.hapjava.characteristics.accessoryinformation.ManufacturerCharacteristic;
import io.github.hapjava.characteristics.accessoryinformation.ModelCharacteristic;
import io.github.hapjava.characteristics.accessoryinformation.SerialNumberCharacteristic;
import io.github.hapjava.characteristics.common.NameCharacteristic;

public class AccessoryInformationService extends AbstractServiceImpl {

  public AccessoryInformationService(
		  IdentifyCharacteristic identify,
		  ManufacturerCharacteristic manufacturer,
		  ModelCharacteristic model,
		  NameCharacteristic name,
		  SerialNumberCharacteristic serialNumber,
		  FirmwareRevisionCharacteristic firmwareRevision)
      throws Exception {
    super("0000003E-0000-1000-8000-0026BB765291");
    addCharacteristic(identify);
    addCharacteristic(manufacturer);
    addCharacteristic(model);
    addCharacteristic(name);
    addCharacteristic(serialNumber);
    addCharacteristic(firmwareRevision);
  }

  public AccessoryInformationService(HomekitAccessory accessory) throws Exception
  {
	  this(new IdentifyCharacteristic(value -> { if (value) { accessory.identify(); } }),
			  new ManufacturerCharacteristic(accessory.getManufacturer()),
			  new ModelCharacteristic(accessory.getModel()),
			  new NameCharacteristic(accessory.getLabel()),
			  new SerialNumberCharacteristic(accessory.getSerialNumber()),
			  new FirmwareRevisionCharacteristic(accessory.getFirmwareRevision()));
  }

  public void addOptionalCharacteristic(HardwareRevisionCharacteristic hardwareRevision) {
	  addCharacteristic(hardwareRevision);
  }
}
