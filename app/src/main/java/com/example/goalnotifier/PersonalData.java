package com.example.goalnotifier;

public class PersonalData {
    private String name;
    private String email;
    private String fathername;
    private String number;
    private String goal_aim;
    private String city;
    private int pin;
    private String gender;

    public PersonalData() {
    }

    public PersonalData(String name, String email, String fathername, String number, String goal_aim, String city, int pin, String gender) {
        this.name = name;
        this.email = email;
        this.fathername = fathername;
        this.number = number;
        this.goal_aim = goal_aim;
        this.city = city;
        this.pin = pin;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFathername() {
        return fathername;
    }

    public String getNumber() {
        return number;
    }

    public String getGoal_aim() {
        return goal_aim;
    }

    public String getCity() {
        return city;
    }

    public int getPin() {
        return pin;
    }

    public String getGender() {
        return gender;
    }
}
