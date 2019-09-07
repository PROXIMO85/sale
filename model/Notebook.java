package az.orient.satish.model;

public class Notebook extends SatishModel {

    private String name;
    private String model;
    private int display;
    private String processor;
    private int ram;
    private String videocard;
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

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", display=" + display +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", videocard='" + videocard + '\'' +
                ", price=" + price +
                '}';
    }
}
