public class Customer {
    private String name;

    public Customer(String name){
        this.name = name;
    }

    public Order placeOrder(MenuItem ... item) {
        Order order = new Order();
        for (MenuItem item1 : item) {
            order.addFood(item1);
        }
        System.out.println(name + " placed an order. Total: $" + order.totalPrice());
        return order;
    }
}
