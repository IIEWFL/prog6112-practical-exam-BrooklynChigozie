/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brook
 */
class TestTicketSales {

    @Test
    void calculateTotalPrice_CalculatedSuccessfully() {
        MovieTickets movieTickets = new MovieTickets();
        double totalPrice = movieTickets.calculateTotalPrice(3, 100.0);
        assertEquals(342.0, totalPrice);
    }

    @Test
    void validateData_ValidData() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData2 validData = new MovieTicketData2("Napoleon", 3, 100.0);
        assertTrue(movieTickets.validateData(validData));
    }

    @Test
    void validateData_InvalidMovieName() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData2 invalidData = new MovieTicketData2("", 3, 100.0);
        assertFalse(movieTickets.validateData(invalidData));
    }

    @Test
    void validateData_InvalidNumTickets() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData2 invalidData = new MovieTicketData2("Napoleon", 0, 100.0);
        assertFalse(movieTickets.validateData(invalidData));
    }

    @Test
    void validateData_InvalidPrice() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData2 invalidData = new MovieTicketData2("Napoleon", 3, 0.0);
        assertFalse(movieTickets.validateData(invalidData));
    }
}