package repositories;

import exceptions.parkingLotNotFoundException;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public Map<Long, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(Map<Long, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public ParkingLot getparkingLotById(Long id) throws parkingLotNotFoundException {
        if(parkingLotMap.containsKey(id)){
            return parkingLotMap.get(id);
        }
        throw new parkingLotNotFoundException();
    }
}
