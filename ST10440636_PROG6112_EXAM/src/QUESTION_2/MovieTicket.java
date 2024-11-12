package QUESTION_2;

public class MovieTicket implements IMovieTickets {

    // Constants for VAT calculation
    private static final double VAT_RATE = 0.14;  // 14% VAT

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        // Validate the input data
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be greater than 0.");
        }
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price must be greater than 0.");
        }

        // Calculate total ticket price
        double totalTicketPrice = numberOfTickets * ticketPrice;

        // Return total price including VAT
        double totalPriceIncludingVAT = totalTicketPrice + (totalTicketPrice * VAT_RATE);
        return totalPriceIncludingVAT;
    }

    @Override
    public boolean ValidateData(MovieTicketSales movieTicketData) {
        // Validate the ticket price and number of tickets
        try {
            double ticketPrice = Double.parseDouble(movieTicketData.getTicketPrice());
            int numberOfTickets = Integer.parseInt(movieTicketData.getNumTickets());

            // Validation rules
            return ticketPrice > 0 && numberOfTickets > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
