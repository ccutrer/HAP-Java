package io.github.hapjava.accessories.thermostat;

import io.github.hapjava.*;
import io.github.hapjava.accessories.TemperatureSensor;
import io.github.hapjava.accessories.properties.ThermostatMode;
import io.github.hapjava.services.ThermostatService;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public interface BasicThermostat extends HomekitAccessory, TemperatureSensor {

  /**
   * Retrieves the current {@link ThermostatMode} of the thermostat.
   *
   * @return a future that will contain the mode.
   */
  CompletableFuture<ThermostatMode> getCurrentMode();

  /**
   * Subscribes to changes in the {@link ThermostatMode} of the thermostat.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeCurrentMode(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the mode of the thermostat. */
  void unsubscribeCurrentMode();

  /**
   * Sets the {@link ThermostatMode} of the thermostat.
   *
   * @param mode The {@link ThermostatMode} to set.
   * @throws Exception when the change cannot be made.
   */
  void setTargetMode(ThermostatMode mode) throws Exception;

  /**
   * Retrieves the pending, but not yet complete, {@link ThermostatMode} of the thermostat.
   *
   * @return a future that will contain the target mode.
   */
  CompletableFuture<ThermostatMode> getTargetMode();

  /**
   * Subscribes to changes in the pending, but not yet complete, {@link ThermostatMode} of the
   * thermostat.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeTargetMode(HomekitCharacteristicChangeCallback callback);

  /**
   * Unsubscribes from changes in the pending, but not yet complete, {@link ThermostatMode} of the
   * thermostat.
   */
  void unsubscribeTargetMode();

  /**
   * Retrieves the target temperature, in celsius degrees.
   *
   * @return a future that will contain the target temperature.
   */
  CompletableFuture<Double> getTargetTemperature();

  /**
   * Sets the target temperature.
   *
   * @param value the target temperature, in celsius degrees.
   * @throws Exception when the temperature cannot be changed.
   */
  void setTargetTemperature(Double value) throws Exception;

  /**
   * Subscribes to changes in the target temperature.
   *
   * @param callback the function to call when the state changes.
   */
  void subscribeTargetTemperature(HomekitCharacteristicChangeCallback callback);

  /** Unsubscribes from changes in the target temperature. */
  void unsubscribeTargetTemperature();

  @Override
  default Collection<Service> getServices() {
    return Collections.singleton(new ThermostatService(this));
  }
}
