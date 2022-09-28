package ru.netology.repository;

import ru.netology.exception.AlreadyExistException;
import ru.netology.exception.NotFoundException;
import ru.netology.ticket.Ticket;

public class Repository {

    Ticket[] tickets = new Ticket[0];

    //добавить билет
    public void save(Ticket ticket) {

        if (this.findById(ticket.getId()) != null)
            throw new AlreadyExistException(
                    "Product with ID " + ticket.getId() + " already exist"
            );

        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    public Ticket[] getTickets() {
        return tickets;
    }

    //получить набор билетов
    public Ticket[] findAll() {
        Ticket[] all = getTickets();
        Ticket[] list = new Ticket[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }


    //удалить билет по id
    public void removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException(
                    "Elements with ID: " + id + " not found"
            );
        }

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }


    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


}

