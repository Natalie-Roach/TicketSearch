package ru.netology.manager;

import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class Manager {

    public Repository repo;

    public Manager(Repository repo) {

        this.repo = repo;
    }

    public void add(Ticket ticket) {

        repo.save(ticket);
    }


    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }

        Arrays.sort(result);
        return result;

    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getDepartureAirport().contains(searchFrom)) {
            return true;
        }
        if (ticket.getArrivalAirport().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }

}
