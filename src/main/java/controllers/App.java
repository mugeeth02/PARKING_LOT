package controllers;
// wksnalkgit
import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepostitory;
import services.TicketService;
import strategies.SimpleParkingSpotAllotmentStrategy;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Gate gate = new Gate(1l, GateType.ENTRY, GateStatus.WORKING);
        Floor floor1 = new Floor(1);

        for(int i=0; i<10; i++) {
            floor1.getParkingSpots().add(
                    new ParkingSpot(1, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE, floor1));
        }

        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        ArrayList<Gate> gates = new ArrayList<>();
        gates.add(gate);

        ParkingLot parkingLot = new ParkingLot(1, floors, gates, ParkingStatus.ACTIVE);


        GateRepository gateRepository = new GateRepository();
        gateRepository.getGates().put(1l,gate);

        VehicleRepostitory vehicleRepostitory = new VehicleRepostitory();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotRepository.getParkingLotMap().put(1l,parkingLot);

        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService =
                new TicketService(gateRepository,vehicleRepostitory,
                        parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequest issueTicketRequest =  new IssueTicketRequest(VehicleType.FOUR_WHEELER,"TN-09","MUGEETH",1l,1l,new SimpleParkingSpotAllotmentStrategy());
        IssueTicketResponse ticketResponse = ticketController.issueTicket(issueTicketRequest);
        System.out.println(ticketResponse);
    }
}
