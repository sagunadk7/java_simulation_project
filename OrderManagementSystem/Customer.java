import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Order> orders;
    private double totalSpent;


    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
        this.totalSpent = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }
    @Override
    public String toString(){
        return this.name;
    }
}