package ru.netology.domain.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        Ticket[] newTicket = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            newTicket[i] = tickets[i];
        }
        newTicket[newTicket.length - 1] = ticket;
        tickets = newTicket;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] removeById(int id) {
        Ticket[] newTicket = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                newTicket[index] = ticket;
                index++;
            }
        }
        tickets = newTicket;
        return tickets;
    }
}


