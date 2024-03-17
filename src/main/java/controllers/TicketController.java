package controllers;

import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import services.TicketService;
import dtos.IssueTicketResponse;
import models.Ticket;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    private IssueTicketResponse issueTicket() {
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException e) {
            System.out.println("Gate not found ");
            return new IssueTicketResponse(null,"FAILURE","Invalid Gate");
        } catch (ParkingLotNotFoundException e) {
            System.out.println("Parking Lot not found ");
            return new IssueTicketResponse(null,"FAILURE","Invalid ParkingLot");
        }catch (ParkingLotFullException e) {
            System.out.println("Parking Lot is full");
            return new IssueTicketResponse(null,"FAILURE","ParkingLot FULL");
        }
        return new IssueTicketResponse(ticket,"Success","Ticket Generated");
    }
}
