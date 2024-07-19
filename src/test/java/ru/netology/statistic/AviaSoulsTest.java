package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    public void testAddAndFindAll() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 5, 7);
        Ticket ticket2 = new Ticket("Moscow", "Paris", 200, 6, 8);

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchMultipleTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 5, 7);
        Ticket ticket2 = new Ticket("Moscow", "London", 50, 6, 8);
        Ticket ticket3 = new Ticket("Moscow", "London", 150, 7, 9);
        Ticket ticket4 = new Ticket("Moscow", "Paris", 200, 6, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = manager.search("Moscow", "London");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSingleTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 5, 7);
        Ticket ticket2 = new Ticket("Moscow", "Paris", 200, 6, 8);

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Moscow", "London");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Paris", 200, 6, 8);
        Ticket ticket2 = new Ticket("Moscow", "Berlin", 300, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Moscow", "London");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 5, 7);
        Ticket ticket2 = new Ticket("Moscow", "London", 50, 6, 9);
        Ticket ticket3 = new Ticket("Moscow", "Paris", 200, 6, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "London", comparator);
        assertArrayEquals(expected, actual);
    }
}

