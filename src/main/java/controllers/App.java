package controllers;

import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepostitory;
import services.TicketService;

public class App {
    public static void main(String[] args) {

        Gate gate = new Gate(1, GateType.ENTRY, GateStatus.WORKING);
        Floor floor1 = new Floor(1);
        floor1.getParkingSpots().add(
                new ParkingSpot(1, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE, floor1));


        GateRepository gateRepository = new GateRepository();
        VehicleRepostitory vehicleRepostitory = new VehicleRepostitory();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService =
                new TicketService(gateRepository,vehicleRepostitory,parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        ticketController.issueTicket();
    }
}
