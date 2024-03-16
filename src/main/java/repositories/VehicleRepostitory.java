package repositories;

import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepostitory {

    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicle getVehicleByNumber(String vehicleNumber){
            return vehicleMap.get(vehicleNumber);
    }

    public static void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getNumber(),vehicle);
    }
}
