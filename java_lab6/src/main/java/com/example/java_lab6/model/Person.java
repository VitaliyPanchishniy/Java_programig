package com.example.java_lab6.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty groupCode;
    private final ObjectProperty<LocalDate> birthday;

    // Нові поля
    private final StringProperty address;
    private final IntegerProperty phoneNumber;
    private final DoubleProperty averageScore;

    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Фіктивні дані для зручності
        this.groupCode = new SimpleIntegerProperty(1747);
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(2000, 2, 21));

        // Ініціалізація нових полів
        this.address = new SimpleStringProperty("It`s my adress");
        this.phoneNumber = new SimpleIntegerProperty(123456789);
        this.averageScore = new SimpleDoubleProperty(5.5);
    }

    // Геттери і сеттери для firstName
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    // Геттери і сеттери для lastName
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    // Геттери і сеттери для groupCode
    public int getGroupCode() {
        return groupCode.get();
    }

    public void setGroupCode(int groupCode) {
        this.groupCode.set(groupCode);
    }

    public IntegerProperty groupCodeProperty() {
        return groupCode;
    }

    // Геттери і сеттери для birthday
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    // Геттери і сеттери для address
    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    // Геттери і сеттери для phoneNumber
    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    // Геттери і сеттери для averageScore
    public double getAverageScore() {
        return averageScore.get();
    }

    public void setAverageScore(double averageScore) {
        this.averageScore.set(averageScore);
    }

    public DoubleProperty averageScoreProperty() {
        return averageScore;
    }
}
