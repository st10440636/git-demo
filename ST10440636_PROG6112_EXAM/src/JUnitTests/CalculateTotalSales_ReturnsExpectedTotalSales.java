package JUnitTests;

import QUESTION_1.MovieTickets;
import junit.framework.TestCase;

public class CalculateTotalSales_ReturnsExpectedTotalSales extends TestCase {

    // Constructor for JUnit test case
    public CalculateTotalSales_ReturnsExpectedTotalSales(String name) {
        super(name);
    }

    // Test for the correct calculation of the total movie sales
    public void testCalculateTotalMovieSales() {
        // Set up test data for TicketSales
        int[] napoleonSales = {3000, 1500, 1700};  // Napoleon's sales (January, February, March)
        int[] oppenheimerSales = {3500, 1200, 1600};  // Oppenheimer's sales (January, February, March)

        // Expected total sales for each movie
        int expectedNapoleonTotal = 3000 + 1500 + 1700;  // 6200
        int expectedOppenheimerTotal = 3500 + 1200 + 1600;  // 6300

        // Initialize MovieTickets instance
        MovieTickets movieTicketsApp = new MovieTickets();

        // Call the TotalMovieSales method and assert the expected result
        int actualNapoleonTotal = movieTicketsApp.TotalMovieSales(napoleonSales);
        int actualOppenheimerTotal = movieTicketsApp.TotalMovieSales(oppenheimerSales);

        // Assert that the calculated total sales match the expected values
        assertEquals("Napoleon total sales should be 6200", expectedNapoleonTotal, actualNapoleonTotal);
        assertEquals("Oppenheimer total sales should be 6300", expectedOppenheimerTotal, actualOppenheimerTotal);
    }
}
