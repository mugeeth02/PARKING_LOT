package models;
import models.Floor;
import models.Gate;
import java.util.List;



public class ParkingLot {
    private long id;
    private List<Floor> floors;
    private List<Gate> gates;
    private ParkingStatus parkingStatus;

    public ParkingLot(long id, List<Floor> floors, List<Gate> gates, ParkingStatus parkingStatus) {
        this.id = id;
        this.floors = floors;
        this.gates = gates;
        this.parkingStatus = parkingStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }
}
