package com.assignment.transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TramDAO {
    public void updateLineNumber(String id, int newLineNumber) throws SQLException {
        String sql = "UPDATE tram SET line_number = ? WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newLineNumber);
            ps.setString(2, id);

            ps.executeUpdate();
        }
    }

    public void updateInService(String id, boolean inService) throws SQLException {
        String sql = "UPDATE tram SET in_service = ? WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, inService);
            ps.setString(2, id);

            ps.executeUpdate();
        }
    }

    public void deleteById(String id) throws SQLException {
        String sql = "DELETE FROM tram WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);

            ps.executeUpdate();
        }
    }

    public void insert(Tram tram) throws SQLException {
        String sql = "INSERT INTO tram (id, line_number, capacity, in_service) VALUES (?, ?, ?, ?)";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tram.getId());
            ps.setInt(2, tram.getLineNumber());
            ps.setInt(3, tram.getCapacity());
            ps.setBoolean(4, tram.isInService());

            ps.executeUpdate();
        }
    }

    public List<Tram> findAll() throws SQLException {
        String sql = "SELECT id, line_number, capacity, in_service FROM tram";
        List<Tram> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Tram t = new Tram(
                        rs.getString("id"),
                        rs.getInt("line_number"),
                        rs.getInt("capacity")
                );

                // если in_service = false, выключим
                t.setInService(rs.getBoolean("in_service"));

                list.add(t);
            }
        }
        return list;
    }
}
