/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.movie;

/**
 *
 * @author brook
 */
public class Movie {
    public static void main(String[] args) {
        // Movie names and sales data
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[][] salesData = {
                {3000, 1500, 1700},
                {3500, 1200, 1600}
        };

        // Calculate total sales for each movie
        int[] totalSales = new int[movies.length];
        for (int i = 0; i < movies.length; i++) {
            totalSales[i] = TotalMovieSales(salesData[i]);
        }

        // Find the top-performing movie
        MovieTickets movieTickets = new MovieTickets();
        String topMovie = movieTickets.TopMovie(movies, totalSales);

        // Display the report
        System.out.println("MOVIE TICKET SALES REPORT 2024\n");
        System.out.println("        JAN\tFEB\tMAR");
        for (int i = 0; i < movies.length; i++) {
            System.out.print(movies[i] + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(salesData[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nTotal movie ticket sales for Napoleon: " + totalSales[0]);
        System.out.println("Total movie ticket sales for Oppenheimer: " + totalSales[1]);
        System.out.println("Top performing movie: " + topMovie);
    }
}