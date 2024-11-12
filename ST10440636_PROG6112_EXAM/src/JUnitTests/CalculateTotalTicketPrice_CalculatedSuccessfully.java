package JUnitTests;

import QUESTION_2.MovieTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalTicketPriceTest {

    private MovieTicket movieTicket;

    @BeforeEach
    void setUp() {
        // Initialize the MovieTicket object before each test
        movieTicket = new MovieTicket();
    }

    // Test case for valid input: ticket price 100 and 2 tickets
    @Test
    void testCalculateTotalTicketPrice_ValidInput() {
        // Given
        int numberOfTickets = 2;
        double ticketPrice = 100.0;

        // When
        double totalPrice = movieTicket.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Then
        double expectedTotalPrice = numberOfTickets * ticketPrice * (1 + 0.14);  // Including VAT
        assertEquals(expectedTotalPrice, totalPrice, "The total ticket price should be calculated correctly.");
    }

    // Test case for more tickets (5 tickets, 150 per ticket)
    @Test
    void testCalculateTotalTicketPrice_MoreTickets() {
        // Given
        int numberOfTickets = 5;
        double ticketPrice = 150.0;

        // When
        double totalPrice = movieTicket.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Then
        double expectedTotalPrice = numberOfTickets * ticketPrice * (1 + 0.14);  // Including VAT
        assertEquals(expectedTotalPrice, totalPrice, "The total ticket price for more tickets should be calculated correctly.");
    }

    // Test case for a single ticket
    @Test
    void testCalculateTotalTicketPrice_SingleTicket() {
        // Given
        int numberOfTickets = 1;
        double ticketPrice = 120.0;

        // When
        double totalPrice = movieTicket.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Then
        double expectedTotalPrice = numberOfTickets * ticketPrice * (1 + 0.14);  // Including VAT
        assertEquals(expectedTotalPrice, totalPrice, "The total ticket price for a single ticket should be calculated correctly.");
    }

    // Test case for invalid input (number of tickets <= 0)
    @Test
    void testCalculateTotalTicketPrice_InvalidTickets() {
        // Given
        int numberOfTickets = -2;
        double ticketPrice = 100.0;

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            movieTicket.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        });
        assertEquals("Number of tickets must be greater than 0.", exception.getMessage());
    }

    // Test case for invalid input (ticket price <= 0)
    @Test
    void testCalculateTotalTicketPrice_InvalidPrice() {
        // Given
        int numberOfTickets = 2;
        double ticketPrice = -100.0;

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            movieTicket.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        });
        assertEquals("Ticket price must be greater than 0.", exception.getMessage());
    }
}
