package org.example.presenter;


import org.example.dto.VehicleDTO;
import org.example.parser.JsonParser;
import org.example.parser.VehicleDTOParser;

public class VehicleConsolePresenter implements VehicleUserInterface {
     VehicleDTOParser vehicleParser = new VehicleDTOParser();
     JsonParser jsonParser = new JsonParser();

    @Override
    public void displayVehicle(String json) {
        VehicleDTO vehicleDTO = vehicleParser.parseJsonToVehicleDTO(json);
        String message = """
                Jármű adatai:
                rendszám: %s
                gyártó : %s
                model : %s
                ülések száma : %d
                típus : %s
                """.formatted(vehicleDTO.getRegistrationNumber(),
                vehicleDTO.getMake(),
                vehicleDTO.getModel(),
                vehicleDTO.getNumberOfSeats(),
                vehicleDTO.getVehicleType());
        System.out.println(message);
    }

    @Override
    public void displayMessage(String json) {
        String message = jsonParser.parseStringValueFromJsonStringByKey(json, "message");
        System.out.println(message);
    }
}
