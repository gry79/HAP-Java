package com.beowulfe.hap.impl.characteristics.thermostat;

import java.util.concurrent.CompletableFuture;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Thermostat;

public class CoolingThresholdTemperatureCharacteristic extends
		AbstractTemperatureCharacteristic {

	private final Thermostat thermostat;
	
	public CoolingThresholdTemperatureCharacteristic(Thermostat thermostat) {
		super("0000000D-0000-1000-8000-0026BB765291", true, "Temperature above which cooling will be active", thermostat);
		this.thermostat = thermostat;
	}

	@Override
	public void subscribe(HomekitCharacteristicChangeCallback callback) {
		thermostat.subscribeCoolingThresholdTemperature(callback);
	}

	@Override
	public void unsubscribe() {
		thermostat.unsubscribeCoolingThresholdTemperature();
	}

	@Override
	protected CompletableFuture<Double> getDoubleValue() {
		return thermostat.getCoolingThresholdTemperature();
	}

	@Override
	protected void setValue(Double value) throws Exception {
		thermostat.setCoolingThresholdTemperature(value);
	}

}