package e.wolfsoft1.ModelClasses;

public class ShippingModel {
    String addressName,address;
    Integer radioButton;

    public ShippingModel(String addressName, String address, Integer radioButton) {
        this.addressName = addressName;
        this.address = address;
        this.radioButton = radioButton;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(Integer radioButton) {
        this.radioButton = radioButton;
    }
}
