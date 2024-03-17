package strategies;

import exceptions.ParkingLotFullException;
import models.*;

public class SimpleParkingSpotAllotmentStrategy implements ParkingPlaceAllotmentStrategy{

    public ParkingSpot getParkingSpot(VehicleType vehicle, ParkingLot parkingLot) throws ParkingLotFullException {
         /*
      1. Find the parking spot
      2. Get all the floors of the parking lot
      For each other, check the slots with specified vehicle type and a status of being free
      Return the parking spot.
     */
        for(Floor floor: parkingLot.getFloors()){
            for(ParkingSpot parkingSpot: floor.getParkingSpots()){
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    if(parkingSpot.getVehicleType().equals(vehicleType)){
                        return parkingSpot;
                    }
                }
            }
        }

        throw new ParkingLotFullException();
    }
}
