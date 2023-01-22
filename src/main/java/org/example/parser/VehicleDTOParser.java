package org.example.parser;

import org.example.dto.VehicleDTO;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleDTOParser {
    JsonParser jsonParser = new JsonParser();
    public VehicleDTO parseJsonToVehicleDTO(String json){
        String registrationNumber = parseRegistrationNumber(json);
        String make = parseMake(json);
        String model = parseModel(json);
        int numberOfSeats = parseNumberOfSeats(json);
        String type = parseType(json);

        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setNumberOfSeats(numberOfSeats);
        vehicle.setVehicleType(type);

        return vehicle;
    }

    public String parseRegistrationNumber(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson ,"registrationNumber");
    }

    private String parseType(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "type");
    }

    private int parseNumberOfSeats(String vehicleJson) {
        return jsonParser.parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");
    }

    private String parseModel(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "model");
    }

    private String parseMake(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "make");
    }

    public String parseVehicleDTOToJson(VehicleDTO vehicleDTO) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", vehicleDTO.getRegistrationNumber());
            jsonObject.put("make", vehicleDTO.getMake());
            jsonObject.put("model", vehicleDTO.getModel());
            jsonObject.put("numberOfSeats", vehicleDTO.getNumberOfSeats());
            jsonObject.put("type", vehicleDTO.getVehicleType());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }
}
