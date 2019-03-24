package e.wolfsoft1.ModelClasses;

public class MenuModel2 {
    String foodName,foodType,rupees;

    public MenuModel2(String foodName, String foodType, String rupees) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.rupees = rupees;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getRupees() {
        return rupees;
    }

    public void setRupees(String rupees) {
        this.rupees = rupees;
    }
}
