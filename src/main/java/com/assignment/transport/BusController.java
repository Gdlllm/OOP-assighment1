package com.assignment.transport;

import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusDAO busDAO = new BusDAO();

    @GetMapping
    public List<Bus> getAll() throws SQLException {
        return busDAO.findAll();
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody Bus bus) throws SQLException {
        busDAO.insert(bus);
        return Map.of("status", "created", "id", bus.getId());
    }

    @PutMapping("/{id}/passengers")
    public Map<String, Object> updatePassengers(@PathVariable String id,
                                                @RequestBody Map<String, Integer> body) throws SQLException {
        Integer p = body.get("currentPassengers");
        if (p == null) throw new IllegalArgumentException("currentPassengers is required");
        busDAO.updatePassengers(id, p);
        return Map.of("status", "updated", "id", id, "currentPassengers", p);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable String id) throws SQLException {
        busDAO.deleteById(id);
        return Map.of("status", "deleted", "id", id);
    }
}
