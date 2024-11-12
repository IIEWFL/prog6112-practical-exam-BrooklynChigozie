/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movie;

/**
 *
 * @author brook
 */
    public class MovieTickets implements IMovieTickets{

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int totalSales = 0;
        for (int sales : movieTicketSales) {
            totalSales += sales;
        }
        return totalSales;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int maxSales = 0;
        int maxIndex = 0;
        for (int i = 0; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                maxIndex = i;
            }
        }
        return movies[maxIndex];
    }
}

