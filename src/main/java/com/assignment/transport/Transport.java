package com.assignment.transport;

import java.util.Objects;

public abstract class Transport {
    private String id;
    private int capacity;
    private boolean inService;
    //конструктор
    public Transport(String id, int capacity, boolean inService) {
        this.id = id;
        this.capacity = Math.max(1, capacity);
        this.inService = inService;
    }
    //метод который должен реализовать дочерний класс
    public abstract String getType();

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = Math.max(1, capacity); }

    public boolean isInService() { return inService; }
    public void setInService(boolean inService) { this.inService = inService; }

    @Override
    public String toString() {
        return getType() + "{id='" + id + "', capacity=" + capacity + ", inService=" + inService + "}";
    }

    // equals/hashCode по id
    @Override
    public boolean equals(Object o) {
        //если и вправду одинковые то возвращаем тру
        if (this == o) return true;
        //если обьект вообще не в классе транпорт то фолс
        if (!(o instanceof Transport that)) return false;
        return Objects.equals(id, that.id);
    }

    //если equals вернет тру то хешкод у обьектов должен быть одинаковый
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}