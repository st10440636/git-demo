import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MovieTicketSales extends JFrame {

    // Declare components
    private JLabel lblMovieName, lblTicketPrice, lblNumTickets, lblSalesReport;
    private JComboBox<String> comboMovies;
    private JTextField txtTicketPrice, txtNumTickets;
    private JButton btnCalculate;
    private JTextArea txtSalesReport;

    // Movies array
    private static final String[] MOVIES = {"Napoleon", "Oppenheimer", "Damsel"};

    public MovieTicketSales() {
        // Set up the JFrame
        this.setTitle("Movie Ticket Sales Application");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Set layout manager with fine control
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between elements

        // Initialize labels and text fields
        lblMovieName = new JLabel("Movie Name:");
        lblTicketPrice = new JLabel("Ticket Price:");
        lblNumTickets = new JLabel("Number of Tickets:");
        lblSalesReport = new JLabel("Sales Report:");

        comboMovies = new JComboBox<>(MOVIES);
        txtTicketPrice = new JTextField(20);
        txtNumTickets = new JTextField(20);

        btnCalculate = new JButton("Calculate Sales");

        txtSalesReport = new JTextArea(10, 40);
        txtSalesReport.setEditable(false);
        txtSalesReport.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Position components using GridBag constraints for alignment

        // Row 1: Movie Name (ComboBox)
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblMovieName, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(comboMovies, gbc);

        // Row 2: Ticket Price
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(lblTicketPrice, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTicketPrice, gbc);

        // Row 3: Number of Tickets
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(lblNumTickets, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumTickets, gbc);

        // Row 4: Calculate Button
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnCalculate, gbc);

        // Row 5: Sales Report Label
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblSalesReport, gbc);

        // Row 6: Sales Report Text Area
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(txtSalesReport), gbc);

        // Action listener for Calculate button
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processMovieTicketSale();
            }
        });
    }

    // Method to process the movie ticket sale
    private void processMovieTicketSale() {
        try {
            // Get input values
            double ticketPrice = Double.parseDouble(txtTicketPrice.getText());
            int numTickets = Integer.parseInt(txtNumTickets.getText());

            // Create a MovieTicket object that implements IMovieTickets
            MovieTicket movieTicket = new MovieTicket(ticketPrice, numTickets);

            // Validate the data using IMovieTickets interface
            if (movieTicket.ValidateData(this)) {
                // Calculate the ticket prices and VAT
                double totalPrice = movieTicket.CalculateTotalTicketPrice(numTickets, ticketPrice);
                double vatAmount = movieTicket.calculateVAT();
                double totalWithVAT = movieTicket.calculateTotalWithVAT();

                // Update the sales report
                String selectedMovie = (String) comboMovies.getSelectedItem();
                txtSalesReport.setText("Movie: " + selectedMovie + "\n" +
                        "Ticket Price: R" + ticketPrice + "\n" +
                        "Number of Tickets: " + numTickets + "\n" +
                        "Total Ticket Price: R" + totalPrice + "\n" +
                        "VAT Amount (14%): R" + vatAmount + "\n" +
                        "Total Price with VAT: R" + totalWithVAT);

                // Save the sales report to a text file
                saveSalesReportToFile(selectedMovie, ticketPrice, numTickets, totalPrice, vatAmount, totalWithVAT);

            } else {
                // If data is invalid, show an error message
                JOptionPane.showMessageDialog(this, "Ticket Price and Number of Tickets must be greater than 0.");
            }
        } catch (NumberFormatException ex) {
            // Handle invalid input (non-numeric values)
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ticket price and number of tickets.");
        }
    }

    // Method to save the sales report to a text file
    private void saveSalesReportToFile(String movie, double ticketPrice, int numTickets, double totalPrice, double vatAmount, double totalWithVAT) {
        try (FileWriter writer = new FileWriter("report.txt", true)) {
            writer.write("Movie: " + movie + "\n" +
                    "Ticket Price: R" + ticketPrice + "\n" +
                    "Number of Tickets: " + numTickets + "\n" +
                    "Total Ticket Price: R" + totalPrice + "\n" +
                    "VAT Amount (14%): R" + vatAmount + "\n" +
                    "Total Price with VAT: R" + totalWithVAT + "\n\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving report to file.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovieTicketSales().setVisible(true);
            }
        });
    }
}
