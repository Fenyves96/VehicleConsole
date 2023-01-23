package hu.fenyvesvolgyimate.vehicleregisterapp.controller;

import hu.fenyvesvolgyimate.vehicleregisterapp.dto.VehicleDTO;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.parser.VehicleDTOParser;

public class VehicleConsoleController implements VehicleController {
    VehicleRegister vehicleRegister;
    VehicleDTOParser parser = new VehicleDTOParser();

    public VehicleConsoleController(VehicleRegister vehicleRegister){
        this.vehicleRegister = vehicleRegister;
    }

    @Override
    public void getVehicleByRegistrationNumber(String registrationNumber) {
        vehicleRegister.getVehicleByRegisterNumber("{\"registrationNumber\": \"%s\"}".formatted(registrationNumber));
    }

    @Override
    public void registerVehicle(VehicleDTO vehicle) {
        String requestJson = parser.parseVehicleDTOToJson(vehicle);
        vehicleRegister.register(requestJson);
    }
}
