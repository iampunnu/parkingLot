package com.lld.parkinglot.services;

import com.lld.parkinglot.assignment.spotassignment.SpotAssignmentStrategy;
import com.lld.parkinglot.controller.TicketController;
import com.lld.parkinglot.models.*;
import com.lld.parkinglot.repository.TicketRepository;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy, TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) {
        // Check if this vehicle is there in DB
        //    1. VehicleService.getVehicleByNumber() - Approach
        //    2. VehicleRepository.fetchByNumber()
        // If yes, get vehicle object
        // Else, create a vehicle
        // Create a Ticket

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if (vehicle == null) {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);
        if (parkingSpot == null) {
         //   throw new NoParkingSpotAvailableException("No available slot");
        }

        ticket.setParkingSpot(parkingSpot);

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
}

