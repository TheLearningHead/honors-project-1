package com.example.honors_project_1.services;

import com.example.honors_project_1.dto.Ticket;
import com.example.honors_project_1.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.getTicket(ticketId);
    }

    public Ticket bookTicket(Ticket ticketDetails) {
        return ticketRepository.bookTicket(ticketDetails);
    }

    public boolean cancelTicket(Long ticketId) {
        return ticketRepository.cancelTicket(ticketId);
    }
}
