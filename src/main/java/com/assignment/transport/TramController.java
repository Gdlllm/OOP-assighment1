package com.assignment.transport;

import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trams")
public class TramController {

    private final TramDAO tramDAO = new TramDAO();

    @GetMapping
    public List<Tram> getAll() throws SQLException {
        return tramDAO.findAll();
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody Tram tram) throws SQLException {
        tramDAO.insert(tram);
        return Map.of("status", "created", "id", tram.getId());
    }

    @PutMapping("/{id}/lineNumber")
    public Map<String, Object> updateLineNumber(@PathVariable String id,
                                                @RequestBody Map<String, Integer> body) throws SQLException {
        Integer ln = body.get("lineNumber");
        if (ln == null) throw new IllegalArgumentException("lineNumber is required");
        tramDAO.updateLineNumber(id, ln);
        return Map.of("status", "updated", "id", id, "lineNumber", ln);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable String id) throws SQLException {
        tramDAO.deleteById(id);
        return Map.of("status", "deleted", "id", id);
    }
}
