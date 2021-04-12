package entities;

public class Person {
    private String name;
    private String address;
    private double money;

    public Person(){

    }

    public Person(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return name.equals(person.getName())
                && address.equals(person.getAddress())
                && money == person.getMoney();
    }
}
