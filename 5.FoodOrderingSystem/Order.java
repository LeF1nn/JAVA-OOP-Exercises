import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addFood(MenuItem item) {

        boolean find = true;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                System.out.println("is already added!");
                find = false;
            }
        }
        if (!find) {
            items.add(item);
            System.out.println("Food added!");
        }
    }

    public void removeFood(MenuItem item) {
        boolean notFind = true;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                items.remove(item);
                System.out.println("Food removed!");
                notFind = false;
            }
            if (notFind) {
                System.out.println("food not find!");
            }
        }

    }

    public  int totalPrice(){
        int total = 0;
        for (MenuItem item : items) {
            total += item.getFoodPrice();
        }
        return total;
    }

}
