package com.lld.parkinglot.controller;

import com.lld.parkinglot.dtos.GenerateTicketRequestDto;
import com.lld.parkinglot.dtos.GenerateTicketResponseDto;
import com.lld.parkinglot.dtos.ResponseStatus;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;
    //Dependency Injection
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        // 1. Get vehicle
        // 2. Generate ticket

        // TicketService - generateTicket()
        //     VehicleService - getVehicleByNumber()
        //     VehiclerService - createVehicle()
        //     assignSpot()
        //     createTicketObjectAndStore()

        try {
            Ticket ticket = ticketService.generateTicket(
                    request.getVehicleNumber(), request.getVehicleType(), request.getGateId()
            );

            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setTicket(ticket);
            response.setResponseStatus(com.lld.parkinglot.dtos.ResponseStatus.SUCCESS);
            return response;
        } catch (Exception E) {
            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }

}
