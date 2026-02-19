class Order {
    private int productId;
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalPrice;
    private int orderTime;
    private OrderStatus orderstatus;

    public int getProductId() {
        return productId;
    }

    public void setproductId(int productId) {
        this.productId = productId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProductTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getProductstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Order(int productId,Customer customer, Product product, int quantity, double totalPrice, int orderTime, OrderStatus orderstatus) {
        this.productId = productId;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
        this.orderstatus = orderstatus;
    }
}
