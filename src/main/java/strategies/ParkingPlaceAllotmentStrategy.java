package strategies;

import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {
    ParkingSpot getParkingSpot(VehicleType vehicleType, Long parkingLot);
}
