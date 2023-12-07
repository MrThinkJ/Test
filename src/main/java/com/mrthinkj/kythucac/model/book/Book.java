package com.mrthinkj.kythucac.model.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mrthinkj.kythucac.annotation.ListMax;
import com.mrthinkj.kythucac.annotation.NotNumberSpecial;
import com.mrthinkj.kythucac.model.user.Account;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    @NotNull(message = "Tên truyện không được để trống")
    @NotEmpty(message = "Tên truyện không được để trống")
    @Size(min = 5, message = "Tên truyện ít nhất 5 ký tự")
    @Size(max = 25, message = "Tên truyện nhiều nhất 25 ký tự")
    @NotNumberSpecial(source = "Tên truyện")
    private String name;
    @Column(name = "book_image")
    private String image;
    @Column(name = "book_description", columnDefinition = "MEDIUMTEXT")
    @NotNull(message = "Mô tả không được để trống")
    @NotEmpty(message = "Mô tả không được để trống")
    @Size(min = 10, message = "Mô tả ít nhất 10 ký tự")
    @Size(max = 200, message = "Mô tả nhiều nhất 200 ký tự")
    private String description;
    @Column(name = "book_post_date")
    private LocalDate postDate;
    @Column(name = "book_status")
    private Status status;
    @Column(name = "book_author")
    @NotNull(message = "Tên tác giả không được để trống")
    @NotEmpty(message = "Tên tác giả không được để trống")
    @Size(min = 1, message = "Tên tác giả ít nhất 1 ký tự")
    @Size(max = 20, message = "Tên tác giả nhiều nhất 20 ký tự")
    @NotNumberSpecial(source = "Tên tác giả")
    private String author;
    @Column(name = "book_view")
    private int view;
    @ManyToMany(cascade = CascadeType.ALL)
    @NotNull(message = "Thể loại không được để trống")
    @ListMax(value =  3)
    @JoinTable(name = "book_type",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"))
    private List<Type> typeList;
    @ManyToOne
    @JoinColumn(name = "account_id")
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", postDate=" + postDate +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", view=" + view +
                ", typeList=" + typeList +
                ", account=" + account +
                '}';
    }

    public String convert() throws UnsupportedEncodingException {
        String output = name.toLowerCase()
                .replaceAll("\\s+", "-");
        return output;
    }

    public String convertAll(){
        String output = Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("[đĐ]", "[d]")
                .replaceAll("[^\\p{ASCII}]+", "") // Remove non-ASCII characters
                .replace("[", "").replace("]", "")
                .replaceAll("\\W+", "-") // Replace consecutive non-word characters with a single hyphen
                .toLowerCase(); // Convert to lowercase
        return output;
    }
}
