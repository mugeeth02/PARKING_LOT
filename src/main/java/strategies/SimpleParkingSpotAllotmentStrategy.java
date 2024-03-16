package strategies;

import models.ParkingSpot;
import models.VehicleType;

public class SimpleParkingSpotAllotmentStrategy implements ParkingPlaceAllotmentStrategy{

    public ParkingSpot getParkingSpot(VehicleType vehicle, Long parkingLotId) {
         /*
      1. Find the parking spot
      2. Get all the floors of the parking lot
      For each other, check the slots with specified vehicle type and a status of being free
      Return the parking spot.
     */

        return null;
    }
}
