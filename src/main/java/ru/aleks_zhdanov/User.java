package ru.aleks_zhdanov;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by alien on 22.12.16.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="sex")
    private char sex;
    @Column(name="age")
    private int age;
    @Column(name="isAdmin")
    private boolean isAdmin;
    @Column(name="date")
    private Date createDate;

    public User() {
    }

    public User(int id, String name, char sex, int age, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createDate = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
