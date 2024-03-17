package repositories;

import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepostitory {

    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber){
            return vehicleMap.get(vehicleNumber);
    }

    public static void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getNumber(),vehicle);
    }
}
