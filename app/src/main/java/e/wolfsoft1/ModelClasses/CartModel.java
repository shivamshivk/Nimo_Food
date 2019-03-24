package e.wolfsoft1.ModelClasses;

public class CartModel {
    String foodName;

    public CartModel(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
