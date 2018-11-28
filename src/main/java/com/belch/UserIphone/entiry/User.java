package com.belch.UserIphone.entiry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Iphone> iphones;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        iphones = new ArrayList<>();
    }

    public void addIphone(Iphone iphone)
    {
        iphone.setUser(this);
        iphones.add(iphone);
    }

    public void removeIphone(Iphone iphone)
    {
        iphones.remove(iphone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Iphone> getIphones() {
        return iphones;
    }

    public void setIphones(List<Iphone> iphones) {
        this.iphones = iphones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
