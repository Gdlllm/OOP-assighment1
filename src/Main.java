public class Main {
    public static void main(String[] args) {
        TransportService service = new TransportService("Almaty Transport", 120.0);

        Bus bus1 = new Bus("BUS-001", "19", 30);
        Bus bus2 = new Bus("BUS-002", "19", 45);
        Bus bus3 = new Bus("BUS-001", "99", 20); // тот же id, специально для сравнения equals

        service.addBus(bus1);
        service.addBus(bus2);

        Commuter c1 = new Commuter("C-100", "Oruntay Vez", 500.0, false);
        Commuter c2 = new Commuter("C-101", "Aruzhan K.", 50.0, false);

        System.out.println(service);
        service.printFleet();

        System.out.println("\n--- Compare objects ---");
        System.out.println("bus1 equals bus3? " + bus1.equals(bus3)); // true (одинаковый id)
        System.out.println("bus1 capacity > bus2 capacity? " + (bus1.getCapacity() > bus2.getCapacity()));

        System.out.println("\n--- Boarding ---");
        System.out.println("c1 before: " + c1);
        boolean ok1 = service.boardCommuter(c1, bus1);
        System.out.println("c1 boarded? " + ok1);
        System.out.println("bus1 after: " + bus1);
        System.out.println("c1 after: " + c1);

        System.out.println("\nc2 before: " + c2);
        boolean ok2 = service.boardCommuter(c2, bus1); // денег не хватит
        System.out.println("c2 boarded? " + ok2);
        System.out.println("c2 after: " + c2);

        System.out.println("\nRevenue: " + service.getRevenue());
    }
}
