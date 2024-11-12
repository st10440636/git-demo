package QUESTION_1;

public class MovieTickets implements IMovieTickets {

    // Method to calculate the total movie sales for a given movie
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int sale : movieTicketSales) {
            total += sale; // Accumulate the sales
        }
        return total;
    }

    // Method to determine the top-performing movie based on total sales
    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int topIndex = 0; // Initialize with the first movie as top-performing
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i; // Update topIndex if current movie has higher sales
            }
        }
        return movies[topIndex]; // Return the name of the top movie
    }
}
