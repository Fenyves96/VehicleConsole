package hu.fenyvesvolgyimate.vehicleregisterapp.presenter;


import hu.fenyvesvolgyimate.vehicleregisterapp.dto.VehicleDTO;
import hu.fenyvesvolgyimate.vehicleregisterapp.parser.JsonParser;
import hu.fenyvesvolgyimate.vehicleregisterapp.parser.VehicleDTOParser;

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
