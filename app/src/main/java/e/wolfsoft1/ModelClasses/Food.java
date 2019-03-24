package e.wolfsoft1.ModelClasses;

public class Food {

    private String food_name;
    private String price;
    private String qnt;

    public Food(String food_name, String price,String qnt) {
        this.food_name = food_name;
        this.price = price;
        this.qnt = qnt;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getPrice() {
        return price;
    }

    public String getQnt() {
        return qnt;
    }
}
