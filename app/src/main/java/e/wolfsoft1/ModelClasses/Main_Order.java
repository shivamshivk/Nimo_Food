package e.wolfsoft1.ModelClasses;

import java.util.List;

public class Main_Order {

    private int food_img;
    private String food_price;
    private String food_date;
    private List<Food> food_items;
    private boolean is_delivered;

    public Main_Order(int food_img,String food_price, String food_date, List<Food> food_items, boolean is_delivered) {
        this.food_img = food_img;
        this.food_price = food_price;
        this.food_date = food_date;
        this.food_items = food_items;
        this.is_delivered = is_delivered;
    }

    public int getFood_img() {
        return food_img;
    }

    public String getFood_price() {
        return food_price;
    }

    public String getFood_date() {
        return food_date;
    }

    public List<Food> getFood_items() {
        return food_items;
    }

    public boolean isIs_delivered() {
        return is_delivered;
    }
}
