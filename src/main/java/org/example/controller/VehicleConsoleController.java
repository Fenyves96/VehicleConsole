package org.example.controller;

import org.example.dto.VehicleDTO;
import org.example.interactor.VehicleRegister;
import org.example.parser.VehicleDTOParser;

import java.util.Scanner;

public class VehicleConsoleController implements VehicleController {
    Scanner sc;
    VehicleRegister vehicleRegister;
    VehicleDTOParser parser = new VehicleDTOParser();

    public VehicleConsoleController(VehicleRegister vehicleRegister){
        this.vehicleRegister = vehicleRegister;
    }

    @Override
    public void start() {
        sc = new Scanner(System.in);
        String command = null;
        System.out.println("Üdvözlet!");
        while (command == null || !"Q".equals(command.toUpperCase())) {
            System.out.printf("Válasszon opciót: jármű regisztrálása(R), autó lekérdezése(L) : ");
            command = sc.next();
            try {
                switch (command.toUpperCase()) {
                    case "R" -> registerVehicle();
                    case "L" -> getVehicle();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private void getVehicle() {
        String registrationNumber = null;
        while (registrationNumber == null || !"Q".equals(registrationNumber.toUpperCase())) {
            System.out.print("rendszám : ");
            registrationNumber = sc.next();
            vehicleRegister
                    .getVehicleByRegisterNumber(
                            "{\"registrationNumber\": \"%s\"}".formatted(registrationNumber));
        }
    }

    private void registerVehicle() {
        System.out.print("rendszám : ");
        String registrationNumber = sc.next();
        System.out.print("gyártó : ");
        String make = sc.next();
        System.out.print("model : ");
        String model = sc.next();
        System.out.print("ülések száma : ");
        int numberOfSeats = sc.nextInt();
        System.out.print("típus : ");
        String vehicleType = sc.next();

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setRegistrationNumber(registrationNumber);
        vehicleDTO.setMake(make);
        vehicleDTO.setModel(model);
        vehicleDTO.setNumberOfSeats(numberOfSeats);
        vehicleDTO.setVehicleType(vehicleType);
        vehicleRegister.register(parser.parseVehicleDTOToJson(vehicleDTO));
    }

    private static VehicleDTO createOpelAstra() {
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setMake("Opel");
        vehicle.setModel("Astra");
        vehicle.setNumberOfSeats(5);
        vehicle.setRegistrationNumber("AA:BC-123");
        vehicle.setVehicleType("m1");
        return vehicle;
    }
}
