import java.util.Objects;

public class Bus {
    private String id;
    private String routeNumber;
    private int capacity;
    private int currentPassengers;
    private boolean inService;

    public Bus() {
        this("UNKNOWN", "0", 40, 0, true);
    }

    public Bus(String id, String routeNumber, int capacity) {
        this(id, routeNumber, capacity, 0, true);
    }

    public Bus(String id, String routeNumber, int capacity, int currentPassengers, boolean inService) {
        this.id = id;
        this.routeNumber = routeNumber;
        this.capacity = capacity;
        this.currentPassengers = Math.max(0, currentPassengers);
        this.inService = inService;
    }

    public boolean board(int count) {
        if (!inService || count <= 0) return false;
        if (currentPassengers + count > capacity) return false;
        currentPassengers += count;
        return true;
    }

    public boolean alight(int count) {
        if (count <= 0) return false;
        if (currentPassengers - count < 0) return false;
        currentPassengers -= count;
        return true;
    }

    public boolean isFull() {
        return currentPassengers >= capacity;
    }

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRouteNumber() { return routeNumber; }
    public void setRouteNumber(String routeNumber) { this.routeNumber = routeNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = Math.max(1, capacity); }

    public int getCurrentPassengers() { return currentPassengers; }
    public void setCurrentPassengers(int currentPassengers) { this.currentPassengers = Math.max(0, currentPassengers); }

    public boolean isInService() { return inService; }
    public void setInService(boolean inService) { this.inService = inService; }

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                ", capacity=" + capacity +
                ", currentPassengers=" + currentPassengers +
                ", inService=" + inService +
                '}';
    }

    // Для сравнения объектов (equals/hashCode)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus bus)) return false;
        return Objects.equals(id, bus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
