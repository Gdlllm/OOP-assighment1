import java.util.Objects;

public class Commuter {
    private String id;
    private String fullName;
    private double balance;
    private boolean hasActiveTicket;

    public Commuter(String id, String fullName, double balance, boolean hasActiveTicket) {
        this.id = id;
        this.fullName = fullName;
        this.balance = Math.max(0.0, balance);
        this.hasActiveTicket = hasActiveTicket;
    }

    public void topUp(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean payFare(double fare) {
        if (fare <= 0) return false;
        if (balance < fare) return false;
        balance -= fare;
        hasActiveTicket = true;
        return true;
    }

    public void invalidateTicket() {
        hasActiveTicket = false;
    }

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = Math.max(0.0, balance); }

    public boolean hasActiveTicket() { return hasActiveTicket; }
    public void setHasActiveTicket(boolean hasActiveTicket) { this.hasActiveTicket = hasActiveTicket; }

    @Override
    public String toString() {
        return "Commuter{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", hasActiveTicket=" + hasActiveTicket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commuter commuter)) return false;
        return Objects.equals(id, commuter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
