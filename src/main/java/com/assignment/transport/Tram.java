package com.assignment.transport;

public class Tram extends Transport {

    private int lineNumber; // номер линии трамвая

    public Tram(String id, int lineNumber, int capacity) {
        super(id, capacity, true);
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String getType() {
        return "com.assignment.transport.Tram";
    }

    @Override
    public String toString() {
        return "com.assignment.transport.Tram{" +
                "id='" + getId() + '\'' +
                ", lineNumber=" + lineNumber +
                ", capacity=" + getCapacity() +
                ", inService=" + isInService() +
                '}';
    }
}
