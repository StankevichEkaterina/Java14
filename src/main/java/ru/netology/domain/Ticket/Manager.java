package ru.netology.domain.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor

public class Manager {

    TicketRepository repository = new TicketRepository();


    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Ticket[] findAll() {
        return repository.findAll();
    }

    public Ticket[] findAllAirport(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] newTicket = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    newTicket[i] = result[i];
                }
                newTicket[newTicket.length - 1] = ticket;
                result = newTicket;
            }
        }
        Arrays.sort(result);
        return result;
    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom() != from) {
            return false;
        }
        if (ticket.getTo() != to) {
            return false;
        }
        return true;
    }
}

