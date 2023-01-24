package hu.fenyvesvolgyimate.vehicleregisterapp.view;


import hu.fenyvesvolgyimate.vehicleregisterapp.controller.VehicleController;
import hu.fenyvesvolgyimate.vehicleregisterapp.dto.VehicleDTO;

import java.util.Scanner;

public class VehicleConsoleView {
    Scanner sc;

    public VehicleConsoleView(){};

    public VehicleConsoleView(VehicleController vehicleController){
        this.vehicleController = vehicleController;
    }
    VehicleController vehicleController;
    public void start() {
        sc = new Scanner(System.in);
        String command = null;
        System.out.println("Üdvözlet!");
        while (command == null || !"Q".equalsIgnoreCase(command)) {
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
        String registrationNumber = "";
        while (registrationNumber.equals("") && !"Q".equalsIgnoreCase(registrationNumber)) {
            System.out.print("rendszám : ");
            registrationNumber = sc.next();
            vehicleController
                    .getVehicleByRegistrationNumber(registrationNumber);
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
        System.out.print("környezetvédelmi osztályba sorolás : ");
        String motorEmissionType = sc.next();

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setRegistrationNumber(registrationNumber);
        vehicleDTO.setMake(make);
        vehicleDTO.setModel(model);
        vehicleDTO.setNumberOfSeats(numberOfSeats);
        vehicleDTO.setVehicleType(vehicleType);
        vehicleDTO.setMotorEmissionType(motorEmissionType);
        vehicleController.registerVehicle(vehicleDTO);
    }

    public void display(String message){
        System.out.println(message);
    }
}
