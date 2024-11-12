package QUESTION_1;

public class TicketSales {
    public static void main(String[] args) {
        // Array for movie names
        String[] movies = {"Napoleon", "Oppenheimer"};
        
        // 2D array for monthly ticket sales
        // Rows represent movies, columns represent months (January, February, March)
        int[][] ticketSales = {
            {3000, 1500, 1700}, // Napoleon sales data
            {3500, 1200, 1600}  // Oppenheimer sales data
        };

        // Array to store total sales for each movie
        int[] totalSales = new int[movies.length];

        // Create an instance of MovieTickets to call its methods
        MovieTickets movieTickets = new MovieTickets();

        // Display the report header
        System.out.println("*******************************************************************");
        System.out.println("Movie Ticket Sales Report (Jan - Mar 2024)");
        System.out.println("*******************************************************************\n");
        System.out.println("--------------------------------------------------------------------");

        // Print the table header with centered spacing for each column
        System.out.printf("%-18s %8s %10s %10s %15s%n", "Movie", "January", "February", "March", "Total Sales");
        System.out.println("--------------------------------------------------------------------");

        // Calculate total sales for each movie and display sales in a table format
        for (int i = 0; i < movies.length; i++) {
            int movieTotal = movieTickets.TotalMovieSales(ticketSales[i]); // Get total sales for the current movie

            // Store total sales for the current movie and display it
            totalSales[i] = movieTotal;

            // Display movie name and monthly sales
            System.out.printf("%-18s", movies[i]);
            for (int j = 0; j < ticketSales[i].length; j++) {
                System.out.printf("%10d", ticketSales[i][j]);
            }
            System.out.printf("%15d%n", movieTotal);
        }

        // Print a line of dashes after the table
        System.out.println("--------------------------------------------------------------------");

        // Find and display the top-performing movie using MovieTickets class
        String topMovie = movieTickets.TopMovie(movies, totalSales);
        int topSales = totalSales[movies.length - 1]; // Get total sales of the top movie
        System.out.println("\n*******************************************************************");
        System.out.println("Top Performing Movie: " + topMovie + " with " + topSales + " tickets sold.");
        System.out.println("\n*******************************************************************");
    }
}
