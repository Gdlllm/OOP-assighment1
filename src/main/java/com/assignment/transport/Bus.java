package com.assignment.transport;

//бас екстендить все с транспорта
public class Bus extends Transport {
    private String routeNumber;
    private int currentPassengers;

    public Bus(String id, String routeNumber, int capacity) {
        this(id, routeNumber, capacity, 0, true);
    }
    //берет атрибуты с класса транспорта
    public Bus(String id, String routeNumber, int capacity, int currentPassengers, boolean inService) {
        super(id, capacity, inService);
        this.routeNumber = routeNumber;
        this.currentPassengers = Math.max(0, currentPassengers);
    }
    //возвращает тип класса
    //@Override проверяет совпадает ли сигнатура и используемый метод через компилятор
    @Override
    public String getType() {
        return "com.assignment.transport.Bus";
    }
    //посадка
    public boolean board(int count) {
        if (!isInService() || count <= 0) return false;
        if (currentPassengers + count > getCapacity()) return false;
        currentPassengers += count;
        return true;
    }
    //высадка
    public boolean alight(int count) {
        if (count <= 0) return false;
        if (currentPassengers - count < 0) return false;
        currentPassengers -= count;
        return true;
    }
    //метод который показывает полный ли автобус
    public boolean isFull() {
        return currentPassengers >= getCapacity();
    }

    // getters/setters
    public String getRouteNumber() { return routeNumber; }
    public void setRouteNumber(String routeNumber) { this.routeNumber = routeNumber; }

    public int getCurrentPassengers() { return currentPassengers; }
    public void setCurrentPassengers(int currentPassengers) {
        this.currentPassengers = Math.max(0, currentPassengers);
    }

    @Override
    public String toString() {
        return "com.assignment.transport.Bus{" +
                "id='" + getId() + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                ", capacity=" + getCapacity() +
                ", currentPassengers=" + currentPassengers +
                ", inService=" + isInService() +
                '}';
    }
}
