/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.movie.MovieTickets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brook
 */
public class TestMovieTickets {

    @Test
    public void testTotalMovieSales() {
        MovieTickets movieTickets = new MovieTickets();
        int[] salesData = {3000, 1500, 1700};
        int expectedTotalSales = 6200;

        int actualTotalSales = movieTickets.TotalMovieSales(salesData);

        assertEquals(expectedTotalSales, actualTotalSales);
    }

    @Test
    public void testTopMovie() {
        MovieTickets movieTickets = new MovieTickets();
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};
        String expectedTopMovie = "Oppenheimer";

        String actualTopMovie = movieTickets.TopMovie(movies, totalSales);

        assertEquals(expectedTopMovie, actualTopMovie);
    }
}
