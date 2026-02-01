package com.assignment.transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    public void updatePassengers(String id, int newPassengers) throws SQLException {
        String sql = "UPDATE bus SET current_passengers = ? WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newPassengers);
            ps.setString(2, id);

            ps.executeUpdate();
        }
    }

    public void updateInService(String id, boolean inService) throws SQLException {
        String sql = "UPDATE bus SET in_service = ? WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, inService);
            ps.setString(2, id);

            ps.executeUpdate();
        }
    }

    public void deleteById(String id) throws SQLException {
        String sql = "DELETE FROM bus WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);

            ps.executeUpdate();
        }
    }

    public void insert(Bus bus) throws SQLException {
        String sql = "INSERT INTO bus (id, route_number, capacity, current_passengers, in_service) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bus.getId());
            ps.setString(2, bus.getRouteNumber());
            ps.setInt(3, bus.getCapacity());
            ps.setInt(4, bus.getCurrentPassengers());
            ps.setBoolean(5, bus.isInService());

            ps.executeUpdate();
        }
    }

    public List<Bus> findAll() throws SQLException {
        String sql = "SELECT id, route_number, capacity, current_passengers, in_service FROM bus";
        List<Bus> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Bus b = new Bus(
                        rs.getString("id"),
                        rs.getString("route_number"),
                        rs.getInt("capacity"),
                        rs.getInt("current_passengers"),
                        rs.getBoolean("in_service")
                );
                list.add(b);
            }
        }
        return list;
    }
}
