package com.gb.data;

public class WinningToy extends Toy {

    protected String firstname;
    protected String lastname;
    protected String phone;


    public WinningToy(Long id, String name, Integer count, Integer probability, String firstname, 
    String lastname, String phone) {
        super(id, name, count, probability);
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "WinningToy [id=" + super.getId() + ", toyname=" + super.getName() + ", count=" + super.getCount() +
        ", probability=" + super.getProbability() + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + "]";
    }
}
