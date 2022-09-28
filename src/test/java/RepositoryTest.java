import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exception.AlreadyExistException;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

public class RepositoryTest {

    Repository repo = new Repository();

    Ticket ticket1 = new Ticket(1, 1200, "KZN", "SVO", 95);
    Ticket ticket2 = new Ticket(34, 1995, "KZN", "SVO", 86);
    Ticket ticket3 = new Ticket(408, 4800, "KZN", "SVO", 70);
    Ticket ticket4 = new Ticket(29, 1000, "KZN", "VKO", 120);
    Ticket ticket5 = new Ticket(5, 2199, "KZN", "VKO", 101);
    Ticket ticket6 = new Ticket(66, 990, "KZN", "VKO", 79);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

    }

    @Test

    public void shouldSave() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test

    public void shouldFindAll() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveByIdExists() {
        repo.removeById(ticket4.getId());

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldThrowException() {

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(100)
        );
    }

    @Test
    public void shouldAlreadyExistException() {

        Assertions.assertThrows(AlreadyExistException.class,
                () -> repo.save(ticket5)
        );
    }

}
