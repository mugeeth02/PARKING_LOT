package services;

import dtos.IssueTicketRequest;
import exceptions.GateNotFoundException;
import exceptions.parkingLotNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepostitory;
import strategies.ParkingPlaceAllotmentStrategy;

import java.util.Date;
import java.util.UUID;
import java.util.function.LongToDoubleFunction;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepostitory vehicleRepostitory;

    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException,
            parkingLotNotFoundException {
/*
        1. SET TIME
        2. GET VEHICLE AMD GATE DETAILS
        3. GET PARKING LOT
        4. ASSIGN AN EMPTY SPOT FOR THIS VEHICLE
        5. GENERATE TICKET NUMBER
        6. SAVE AND RETURN THE TICKET
 */
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(request.getGateId());
        ticket.setGate(gate);

        /*
        **********************
         */

        Vehicle vehicle = vehicleRepostitory.getVehicleByNumber(request.getVehicleNumber());
        if(vehicle == null){
            vehicle = new Vehicle(request.getVehicleNumber(),request.getVehicleType(), request.getOwner());
            vehicleRepostitory.save(vehicle);
        }
        ticket.setVehicle(vehicle);

        /*
         **********************
         */

        ParkingLot parkingLot = parkingLotRepository.getparkingLotById(request.getParkingLotId());
        ParkingPlaceAllotmentStrategy allotmentStrategy = request.getParkingPlaceAllotmentStrategy();


        ParkingSpot parkingSpot = allotmentStrategy.getParkingSpot(request.getVehicleType(), request.getParkingLotId());

        ticket.setParklingSpot(parkingSpot);
        ticket.setNumber(request.getVehicleNumber()+ UUID.randomUUID() );
        ticketRepository.save(ticket);


        return ticket;
    }

}
