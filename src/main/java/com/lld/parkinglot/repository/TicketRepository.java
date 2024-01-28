package com.lld.parkinglot.repository;

import com.lld.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    //    private List<Ticket> tickets = new ArrayList<>();
    private long lastIdCount = 0;
    private Map<Long, Ticket> tickets = new HashMap<>();

    public Ticket save(Ticket ticket) {
        lastIdCount += 1;
        ticket.setId(lastIdCount);
        tickets.put(lastIdCount, ticket);
        return ticket;
    }
}
