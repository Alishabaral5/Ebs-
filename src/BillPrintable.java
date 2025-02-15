import java.awt.*;
import java.awt.print.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BillPrintable implements Printable {
    private String content;

    // Constructor to receive the content to print
    public BillPrintable(String content) {
        this.content = content;
    }

    // Override the print method to specify how to render content on the printed page
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) {
            return NO_SUCH_PAGE;  // Only one page in this case
        }

        // Set up the graphics context for printing
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.setFont(new Font("Serif", Font.PLAIN, 12));

        // Split the content into individual lines by newlines
        String[] lines = content.split("\n");

        // Title section (centered at the top of the page)
        int yPosition = 50;  // Starting Y position for the title
        Font titleFont = new Font("Serif", Font.BOLD, 30); // Title font
        g2d.setFont(titleFont);

        // Center the title
        String title = "Electricity Bill Report";
        int titleWidth = g2d.getFontMetrics().stringWidth(title);
        int xPosition = (int) (pageFormat.getWidth() / 2 - titleWidth / 2); // Centered horizontally

        g2d.drawString(title, xPosition, yPosition); // Draw the title centered
         
        yPosition += 20; // Move down a bit after title for the line
        int lineStartX = 0; // Start the line from the far left
        int lineEndX = (int) pageFormat.getWidth(); // End the line at the far right
        g2d.setStroke(new BasicStroke(4));
        // Draw the line across the page
        g2d.drawLine(lineStartX, yPosition, lineEndX, yPosition); // Wider line
        
        // Add some space after the title
        yPosition += 20; // Move down after the title for content

        // Now we need to print the bill content (left-aligned)
        g2d.setFont(new Font("Serif", Font.PLAIN, 16)); // Reset the font for content
        for (String line : lines) {
            g2d.drawString(line, 100, yPosition); // Left-align content starting at 100 pixels from the left
            yPosition += 30; // Increase the gap between lines (adjust as needed)
        }
         LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd      hh:mm:ss a"); // Format for date and time
        String formattedDateTime = currentDateTime.format(formatter);
        
        // Draw the date and time at the bottom
        yPosition += 40; // Move down a bit from the last line of content
        g2d.setFont(new Font("Serif", Font.PLAIN, 16)); // Smaller font for date and time
        g2d.drawString("Printed on: " + formattedDateTime, 100, yPosition); // Left-aligned

        return PAGE_EXISTS; // Page exists
    }
}
