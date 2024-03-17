package repositories;

import exceptions.ParkingLotNotFoundException;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    Map<Long, ParkingLot> parkingLotMap = new HashMap<>();



    public static Map<Long, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(Map<Long, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public ParkingLot getparkingLotById(Long parkingLotId) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(parkingLotId)){
            return parkingLotMap.get(parkingLotId);
        }
        throw new ParkingLotNotFoundException();
    }
}
