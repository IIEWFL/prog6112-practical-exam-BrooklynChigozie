/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieticketsales2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author brook
 */
     public class MovieTicketSales extends JFrame {

    private final JComboBox<String> movieComboBox;
    private final JTextField numTicketsField;
    private final JTextField priceField;
    private final JTextArea reportArea;
    private final MovieTickets movieTickets = new MovieTickets();

    public MovieTicketSales() {
        setTitle("Movie Ticket Sales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel movieLabel = new JLabel("Movie:");
        movieComboBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        JLabel numTicketsLabel = new JLabel("Number of Tickets:");
        numTicketsField = new JTextField(10);
        JLabel priceLabel = new JLabel("Ticket Price:");
        priceField = new JTextField(10);
        topPanel.add(movieLabel);
        topPanel.add(movieComboBox);
        topPanel.add(numTicketsLabel);
        topPanel.add(numTicketsField);
        topPanel.add(priceLabel);
        topPanel.add(priceField);

        reportArea = new JTextArea(10, 20);
        reportArea.setEditable(false);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processTicketSales();
            }
        });
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
   
    private boolean validateData() {
        String movieName = (String) movieComboBox.getSelectedItem();
        int numTickets = Integer.parseInt(numTicketsField.getText());
        double price = Double.parseDouble(priceField.getText());

        return movieTickets.validateData(movieName, numTickets, price);
    }

    private void processTicketSales() {
        String movieName = (String) movieComboBox.getSelectedItem();
        int numTickets = Integer.parseInt(numTicketsField.getText());
        double price = Double.parseDouble(priceField.getText());

        double total = numTickets * price;
        double vat = total * 0.15;
        double grandTotal = total + vat;

        reportArea.setText("MOVIE NAME: " + movieName + "\n" +
                "MOVIE TICKET PRICE: R " + price + "\n" +
                "NUMBER OF TICKETS: " + numTickets + "\n" +
                "TOTAL TICKET PRICE: R " + total + "\n" +
                "VAT: R " + vat + "\n" +
                "GRAND TOTAL: R " + grandTotal);
    
    }

    private void clearFields() {
        movieComboBox.setSelectedIndex(0);
        numTicketsField.setText("");
        priceField.setText("");
        reportArea.setText("");
    }
    
class MovieTickets {
    public boolean validateData(String movieName, int numTickets, double price) {
        return !movieName.isEmpty() && numTickets > 0 && price > 0;
    }

    public double calculateTotalPrice(int numTickets, double price) {
        double total = numTickets * price;
        double vat = total * 0.14;
        return total + vat;
    }
}
}

