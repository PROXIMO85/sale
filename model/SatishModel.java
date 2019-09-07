package az.orient.satish.model;

public abstract class SatishModel {

    private long id;
    private int active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SatishModel{" +
                "id=" + id +
                ", active=" + active +
                '}';
    }
}
