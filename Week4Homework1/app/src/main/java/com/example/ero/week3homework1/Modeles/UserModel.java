package com.example.ero.week3homework1.Modeles;

import java.util.List;

public class UserModel {

    private String image;
    private String nameSurname;
    private String status;
    private String phone;
    private String email;
    private List<MessengeModel> messege;
    private String age;

    public UserModel() {
    }

    public UserModel(String image, String nameSurname, String age, String status, String phone, String email, List<MessengeModel> messege) {
        this.image = image;
        this.nameSurname = nameSurname;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.messege = messege;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MessengeModel> getMessege() {
        return messege;
    }

    public void setMessege(List<MessengeModel> messege) {
        this.messege = messege;
    }
}
