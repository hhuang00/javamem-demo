package com.example.demo.Main;

public class User {
    public String id;
    public String name;
    private String password;
    private String phone;

    public User(){
        System.out.println("无参构造");
    }

    public User(String id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getId() {
        System.out.println("getId");
        return id;
    }

    public void setId(String id) {
        System.out.println("setId");
        this.id = id;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getPassword() {
        System.out.println("getPassword");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

    public String getPhone() {
        System.out.println("getPhone");
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("setPhone");
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
