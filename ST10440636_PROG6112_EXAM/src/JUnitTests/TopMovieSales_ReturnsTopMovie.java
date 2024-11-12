package JUnitTests;

import QUESTION_1.MovieTickets;
import junit.framework.TestCase;

public class TopMovieSales_ReturnsTopMovie extends TestCase {

    // Constructor for JUnit test case
    public TopMovieSales_ReturnsTopMovie(String name) {
        super(name);
    }

    // Test for the correct determination of the top-performing movie
    public void testTopMovie() {
        // Prepare test data
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300}; // Total sales for Napoleon (6200) and Oppenheimer (6300)

        // Expected result (since Oppenheimer has higher sales)
        String expectedTopMovie = "Oppenheimer";

        // Create an instance of the MovieTickets class
        MovieTickets movieTicketsApp = new MovieTickets();

        // Call the TopMovie method to get the actual top movie
        String actualTopMovie = movieTicketsApp.TopMovie(movies, totalSales);

        // Assert that the top-performing movie is correct
        assertEquals("The top-performing movie should be Oppenheimer", expectedTopMovie, actualTopMovie);
    }
}
