public class Main {

    public static void main(String[] args) {

        TransportService service =
                new TransportService("Almaty Transport", 120);

        // POLYMORPHISM транспорт работает как ссылка, обьект создается в басе а не в транспорте
        Transport t1 = new Bus("BUS-001", "19", 30);
        Transport t2 = new Bus("BUS-002", "19", 40);

        service.addTransport(t1);
        service.addTransport(t2);

        Commuter c1 = new Commuter("C-001", "Oruntay", 500, false);
        Commuter c2 = new Commuter("C-002", "Aruzhan", 50, false);

        service.addCommuter(c1);
        service.addCommuter(c2);

        service.printFleet();

        Bus bus = (Bus) service.findTransportById("BUS-001");

        service.boardCommuter(c1, bus);
        service.boardCommuter(c2, bus);

        System.out.println(bus);
        System.out.println("Revenue: " + service.getRevenue());
    }
}
