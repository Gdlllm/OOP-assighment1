import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransportService {
    private String name;
    private double fare;

    //Data pool создаем списки
    private final List<Transport> fleet = new ArrayList<>();
    private final List<Commuter> commuters = new ArrayList<>();

    private double revenue = 0.0;

    public TransportService(String name, double fare) {
        this.name = name;
        this.fare = Math.max(0.0, fare);
    }

    //добавляем транспорты и коммютеры
    public void addTransport(Transport transport) {
        if (transport != null && !fleet.contains(transport)) {
            fleet.add(transport);
        }
    }

    public void addCommuter(Commuter commuter) {
        if (commuter != null && !commuters.contains(commuter)) {
            commuters.add(commuter);
        }
    }

    public List<Transport> getFleet() {
        return fleet;
    }

    public List<Commuter> getCommuters() {
        return commuters;
    }

    //Поиск по айди
    public Transport findTransportById(String id) {
        for (Transport t : fleet) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    public Commuter findCommuterById(String id) {
        for (Commuter c : commuters) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    //Фильтрация
    public List<Transport> getInServiceTransports() {
        List<Transport> res = new ArrayList<>();
        for (Transport t : fleet) {
            if (t.isInService()) res.add(t);
        }
        return res;
    }

    public List<Bus> getBusesByRoute(String routeNumber) {
        List<Bus> res = new ArrayList<>();
        for (Transport t : fleet) {
            if (t instanceof Bus b) {
                if (b.getRouteNumber().equals(routeNumber)) res.add(b);
            }
        }
        return res;
    }

    //Сортировка
    //по капасити
    public void sortFleetByCapacity() {
        fleet.sort(Comparator.comparingInt(Transport::getCapacity));
    }
    //по айди
    public void sortFleetById() {
        fleet.sort(Comparator.comparing(Transport::getId));
    }
    //по комютерам
    public void sortCommutersByBalanceDesc() {
        commuters.sort((a, b) -> Double.compare(b.getBalance(), a.getBalance()));
    }

    public boolean boardCommuter(Commuter commuter, Bus bus) {
        if (commuter == null || bus == null) return false;
        if (!bus.isInService()) return false;

        // оплатить проезд, если нет билета
        if (!commuter.hasActiveTicket()) {
            boolean paid = commuter.payFare(fare);
            if (!paid) return false;
            revenue += fare;
        }

        // посадка 1 пассажира
        boolean boarded = bus.board(1);
        if (!boarded) {
            // если не смогли сесть — откатываем "билет" и доход (упрощённо)
            commuter.invalidateTicket();
            revenue -= fare;
            return false;
        }

        // билет использован
        commuter.invalidateTicket();
        return true;
    }

    public void printFleet() {
        System.out.println("=== Fleet of " + name + " ===");
        for (Transport t : fleet) {
            System.out.println(t); // ✅ polymorphism: вызовется toString() конкретного типа
        }
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
                ", commuters=" + commuters.size() +
                ", revenue=" + revenue +
                '}';
    }
}
