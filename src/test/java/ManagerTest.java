import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

public class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 300, "KZN", "SVO", 95);
    Ticket ticket2 = new Ticket(34, 1200, "DXB", "ARH", 86);
    Ticket ticket3 = new Ticket(408, 4800, "KZN", "SVO", 70);
    Ticket ticket4 = new Ticket(29, 6000, "ZIA", "VOG", 120);
    Ticket ticket5 = new Ticket(5, 500, "IJK", "VKO", 101);
    Ticket ticket6 = new Ticket(66, 400, "KZN", "SVO", 79);
    Ticket ticket7 = new Ticket(1086, 3500, "ZIA", "VOG", 230);
    Ticket ticket8 = new Ticket(11, 25_000, "DXB", "ARH", 211);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test

    public void shouldShowAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = manager.repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByAirportDepartureAndArrival() {
        Ticket[] expected = {ticket1, ticket6, ticket3};
        Ticket[] actual = manager.searchBy("KZN", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotSearchByTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("KVX", "MMK");

        Assertions.assertArrayEquals(expected, actual);
    }

}








