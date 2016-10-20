package gwt.material.demo.errai.client.local.page.addins.table.model;

import gwt.material.design.client.data.HasDataCategory;

import java.io.Serializable;

public class Person implements HasDataCategory, Serializable {

    private int id;
    private String picture;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String category;

    private Person() {
    }

    public Person(int id, String firstName, String lastName, String phone, String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.category = category;
    }

    public Person(int id, String userName, String picture, String firstName, String lastName, String phone, String category) {
        this.id = id;
        this.userName = userName;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String getDataCategory() {
        return getCategory();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
        return category != null ? category.equals(person.category) : person.category == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
