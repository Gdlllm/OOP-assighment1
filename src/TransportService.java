import java.util.ArrayList;
import java.util.List;

public class TransportService {
    private String name;
    private double fare;
    private final List<Bus> fleet = new ArrayList<>();
    private double revenue;

    public TransportService() {
        this("City Transport", 120.0);
    }

    public TransportService(String name, double fare) {
        this.name = name;
        this.fare = Math.max(0.0, fare);
        this.revenue = 0.0;
    }

    public void addBus(Bus bus) {
        if (bus != null && !fleet.contains(bus)) {
            fleet.add(bus);
        }
    }

    public Bus findByRoute(String routeNumber) {
        for (Bus b : fleet) {
            if (b.getRouteNumber().equals(routeNumber)) return b;
        }
        return null;
    }

    public boolean boardCommuter(Commuter commuter, Bus bus) {
        if (commuter == null || bus == null) return false;
        if (!bus.isInService()) return false;

        // если нет активного билета — пытаемся оплатить
        if (!commuter.isHasActiveTicket()) {
            boolean paid = commuter.payFare(fare);
            if (!paid) return false;
            revenue += fare;
        }

        // посадка 1 пассажира
        boolean boarded = bus.board(1);
        if (!boarded) {
            // если автобус полный — вернём билет как "не использован"
            commuter.invalidateTicket();
            revenue -= fare; // упрощённо
            return false;
        }

        // билет "погашен"
        commuter.invalidateTicket();
        return true;
    }

    public void printFleet() {
        System.out.println("=== Fleet of " + name + " ===");
        for (Bus b : fleet) System.out.println(b);
    }

    // getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = Math.max(0.0, fare); }

    public double getRevenue() { return revenue; }

    @Override
    public String toString() {
        return "TransportService{" +
                "name='" + name + '\'' +
                ", fare=" + fare +
                ", fleetSize=" + fleet.size() +
                ", revenue=" + revenue +
                '}';
    }
}
