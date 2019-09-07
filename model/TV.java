package az.orient.satish.model;

public class TV extends SatishModel {

    private String name;
    private String model;
    private int screen;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TV{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", screen=" + screen +
                ", price=" + price +
                '}';
    }
}
