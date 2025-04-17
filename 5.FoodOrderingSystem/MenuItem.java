public class MenuItem {
    private String foodName;
    private int foodPrice;

    public MenuItem(String name , int price){
        this.foodName = name;
        this.foodPrice = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

}

