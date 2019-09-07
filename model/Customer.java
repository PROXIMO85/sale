package az.orient.satish.model;

import java.util.Date;

public class Customer extends SatishModel {
    private String name;
    private String surname;
    private String card;
    private String address1;
    private Date dob;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAddress() {
        return address1;
    }

    public void setAddress(String address) {
        this.address1 = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", card='" + card + '\'' +
                ", address='" + address1 + '\'' +
                ", dob='" + dob +
                '}';
    }
}
