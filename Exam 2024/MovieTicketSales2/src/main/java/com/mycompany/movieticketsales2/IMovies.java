/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.movieticketsales2;

/**
 *
 * @author brook
 */
    public interface IMovies {
    double calculateTotalPrice(int numTickets, double ticketPrice);
    boolean validateData(TicketData movieTicketData);
}

class MovieTickets implements IMovies {
    @Override
    public double calculateTotalPrice(int numTickets, double ticketPrice) {
        double total = numTickets * ticketPrice;
        double vat = total * 0.14;
        return total + vat;
    }

    @Override
    public boolean validateData(TicketData movieTicketData) {
        return !movieTicketData.getMovieName().isEmpty() &&
                movieTicketData.getNumTickets() > 0 &&
                movieTicketData.getPrice() > 0;
    }
}



