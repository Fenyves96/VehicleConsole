package hu.fenyvesvolgyimate.vehicleregisterapp.controller;

import hu.fenyvesvolgyimate.vehicleregisterapp.dto.VehicleDTO;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleReader;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleWriter;
import hu.fenyvesvolgyimate.vehicleregisterapp.parser.VehicleDTOParser;

public class VehicleConsoleController implements VehicleController {
    VehicleWriter vehicleWriter;
    VehicleReader vehicleReader;
    VehicleDTOParser parser = new VehicleDTOParser();

    public VehicleConsoleController(VehicleWriter vehicleWriter, VehicleReader vehicleReader){
        this.vehicleWriter = vehicleWriter;
        this.vehicleReader = vehicleReader;
    }

    @Override
    public void getVehicleByRegistrationNumber(String registrationNumber) {
        vehicleReader.getVehicleByRegisterNumber("{\"registrationNumber\": \"%s\"}".formatted(registrationNumber));
    }

    @Override
    public void registerVehicle(VehicleDTO vehicle) {
        String requestJson = parser.parseVehicleDTOToJson(vehicle);
        vehicleWriter.register(requestJson);
    }
}
