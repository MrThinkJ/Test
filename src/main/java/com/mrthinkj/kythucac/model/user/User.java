package com.mrthinkj.kythucac.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    @NotEmpty(message = "Tên không được để trống")
    @NotNull(message = "Tên không được để trống")
    @Size(min = 6, message = "Tên phải có độ dài lớn hơn 6 ký tự")
    @Size(max = 20, message = "Tên phải có độ dài nhỏ hơn 20 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Tên không được chứa ký tự đặc biệt")
    private String name;
    @Column(name = "gender")
    @NotNull
    private Gender gender;
    @Column(name = "user_description")
    @NotNull(message = "Mô tả không được để trống")
    @NotEmpty(message = "Mô tả không được để trống")
    @Size(min = 6, message = "Mô tả phải có độ dài lớn hơn 6 ký tự")
    @Size(max = 100, message = "Mô tả phải có độ dài nhỏ hơn 100 ký tự")
    private String description;
    @Column(name = "user_avatar")
    private String avatar;
    @Column(name = "user_address")
    @Size(min = 6, message = "Địa chỉ phải có độ dài lớn hơn 6 ký tự")
    @Size(max = 20, message = "Địa chỉ phải có độ dài nhỏ hơn 20 ký tự")
    private String address;
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Account account;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
