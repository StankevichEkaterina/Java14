package ru.netology.domain.Ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    protected TicketRepository repository = new TicketRepository();
    protected Manager manager = new Manager(repository);

    protected Ticket First = new Ticket(1, 1300, "DME", "KZN", 2);
    protected Ticket Two = new Ticket(2, 2200, "DME", "KZN", 3);
    protected Ticket Three = new Ticket(3, 2000, "LED", "DME", 4);
    protected Ticket For = new Ticket(4, 2500, "LED", "DME", 3);

    @Test
    public void shouldTicketSave() {
        manager.save(Two);
        manager.save(First);
        manager.save(Three);
        manager.save(For);
        Ticket[] expected = new Ticket[]{Two, First, Three, For};
        Ticket[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddingTicketsAndSearchingForTicketsByDirectionOfDepartureAndArrivalAndSortingByPrice() {
        manager.save(Two);
        manager.save(First);
        manager.save(Three);
        Ticket[] expected = {First, Two};
        Ticket[] actual = manager.findAllAirport("DME", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddingTicketsDeletingByIdSearchForTicketsByDirectionOfDepartureAndArrivalAndSortingByPrice() {
        manager.save(Two);
        manager.save(First);
        manager.save(Three);
        manager.removeById(1);
        Ticket[] expected = new Ticket[]{Two};
        Ticket[] actual = manager.findAllAirport("DME", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddingTicketsSearchForTicketsForDirectionThatIsNotInTheTickets() {
        manager.save(Two);
        manager.save(First);
        manager.save(Three);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAllAirport("LED", "KZN");
        assertArrayEquals(expected, actual);
    }


}