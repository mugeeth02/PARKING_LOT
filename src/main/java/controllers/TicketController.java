package controllers;

import exceptions.GateNotFoundException;
import exceptions.parkingLotNotFoundException;
import services.TicketService;
import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.Ticket;

import java.sql.SQLOutput;

public class TicketController {
    private TicketService ticketService;
    private IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException e) {
            System.out.println("Gate not found ");
            return new IssueTicketResponse(null,"FAILURE","Invalid Gate");
        } catch (parkingLotNotFoundException e) {
            System.out.println("ParkingLot not found ");
            return new IssueTicketResponse(null,"FAILURE","Invalid ParkingLot");
        }
        return new IssueTicketResponse(ticket,"Success","Ticket Generated");
    }
}
