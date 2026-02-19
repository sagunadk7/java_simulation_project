import java.util.List;
import java.util.ArrayList;

public class Store {
    public List<Product> productList;
    public  List<Customer> customerList;
    private List<Order> orderHistory;
    private double totalRevenue;
    private int failedAttempt;
    public Store(){
        this.customerList = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public boolean placeOrder(Customer customer,int productId,int qty){
        for(Product product: productList){
            if(product.getId()==productId){
                if(product.getQuantityInStock()>=qty){
                    double totalPrice = product.getPrice()*qty;
                    product.setQuantityInStock(product.getQuantityInStock()-qty);
                    int orderTime = 2027;
                    Order order = new Order(productId,customer,product,qty,totalPrice,orderTime,OrderStatus.PLACED);
                    orderHistory.add(order);
                    customerList.add(customer);
                    totalRevenue+=totalPrice;
                    return true;
                }
                else {
                    failedAttempt++;
                    return false;
                }
            }
        } 
        failedAttempt++;
        return false;
    }
    public boolean cancelOrder(int productId) {
        for(Order order:orderHistory) {
            if(order.getProductId()==productId) {
                double totalPrice = order.getTotalPrice();
                totalRevenue-=totalPrice;
                orderHistory.remove(order);
                for(Product product: productList){
                    if(product.getId()==productId) {
                       product.setQuantityInStock(order.getQuantity());
                    }
                }
                return true;
            }
        }
        return false;
    }
    public boolean restockProduct(int productId,int qty){
        for(Product product: productList){
            if(product.getId()==productId){
                product.setQuantityInStock(product.getQuantityInStock()+qty);
                return true;
            }
        }
        return false;
    }
    public void showLowStockProducts(){
        for(Product pro: productList) {
            if(pro.getQuantityInStock()<=5) {
                System.out.println(pro.getName() + (pro.getQuantityInStock()==0?" out of stock":" getting out of Stock."));
            }
        }
    }
    public void  showStatistcs(){
        System.out.println("Total Revenue: $"+totalRevenue);
        System.out.println("Total Orders: "+orderHistory.size());
        System.out.println("Failed Attempts: "+failedAttempt);
        
    }
}