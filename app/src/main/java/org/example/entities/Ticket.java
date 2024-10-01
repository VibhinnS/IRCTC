package org.example.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfDeparture;
    private Train train;

    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfDeparture, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfDeparture = dateOfDeparture;
        this.train = train;
    }

    public Ticket() {}

    public Map<String, Object> getTicketInfo() {
        Map<String, Object> ticketInfo = new HashMap<>();
        ticketInfo.put("ticketId", ticketId); // String
        ticketInfo.put("userId", userId); // String
        ticketInfo.put("source", source); // String
        ticketInfo.put("destination", destination); // String
        ticketInfo.put("dateOfDeparture", dateOfDeparture); // Date
        ticketInfo.put("train", train); // Train object
        return ticketInfo;
    }

    public String getTicketId() {
        return ticketId;
    }
}