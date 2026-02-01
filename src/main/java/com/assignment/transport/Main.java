package com.assignment.transport;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        BusDAO busDAO = new BusDAO();
        TramDAO tramDAO = new TramDAO();

        try {


            //create
            //busDAO.insert(new com.assignment.transport.Bus("BUS-777", "19", 35, 0, true));
            //tramDAO.insert(new com.assignment.transport.Tram("TRAM-777", 9, 110, true));

            //Update
            //busDAO.updatePassengers("BUS-777", 5);
            //tramDAO.updateLineNumber("TRAM-777", 10);

            //delete
            //busDAO.deleteById("BUS-777");
            //tramDAO.deleteById("TRAM-777");

            //read
            System.out.println("=== BUSES FROM com.assignment.transport.DB ===");
            for (Bus b : busDAO.findAll()) {
                System.out.println(b);
            }

            System.out.println("\n=== TRAMS FROM com.assignment.transport.DB ===");
            for (Tram t : tramDAO.findAll()) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
