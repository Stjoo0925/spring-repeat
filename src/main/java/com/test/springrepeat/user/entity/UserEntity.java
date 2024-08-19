package com.test.springrepeat.user.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_ageaddress_post")
    private String addressPost;

    @Column(name = "user_address_default")
    private String addressDefault;

    @Column(name = "user_address_detail")
    private String addressDetail;

    @Column(name = "user_create_at")
    private LocalDateTime userCreateAt;

    @Column(name = "user_update_at")
    private LocalDateTime userUpdateAt;

    @Column(name = "user_delete_at")
    private LocalDateTime userDeleteAt;

    private UserEntity(Integer id, String userName, Integer userAge, String addressPost, String addressDefault, String addressDetail, LocalDateTime userCreateAt, LocalDateTime userUpdateAt, LocalDateTime userDeleteAt) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.addressPost = addressPost;
        this.addressDefault = addressDefault;
        this.addressDetail = addressDetail;
        this.userCreateAt = userCreateAt;
        this.userUpdateAt = userUpdateAt;
        this.userDeleteAt = userDeleteAt;
    }

    public UserEntity() {
    }

    public static UserEntity builder(){
        return new UserEntity();
    }


    public UserEntity id(Integer id) {
        this.id = id;
        return this;
    }

    public UserEntity userName(String userName) {
        this.userName = userName;
        return  this;
    }

    public UserEntity userAge(Integer userAge) {
        if(userAge < 20){

            return null;
        }
        this.userAge = userAge;
        return this;
    }

    public UserEntity addressPost(String addressPost) {
        this.addressPost = addressPost;
        return this;
    }

    public UserEntity addressDefault(String addressDefault) {
        this.addressDefault = addressDefault;
        return this;
    }

    public UserEntity addressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public UserEntity userCreateAt(LocalDateTime userCreateAt) {
        this.userCreateAt = userCreateAt;
        return this;
    }

    public UserEntity userUpdateAt(LocalDateTime userUpdateAt) {
        this.userUpdateAt = userUpdateAt;
        return this;
    }

    public UserEntity userDeleteAt(LocalDateTime userDeleteAt) {
        this.userDeleteAt = userDeleteAt;
        return this;
    }
    public UserEntity build() {
        return new UserEntity(id,userName,userAge,addressPost,addressDefault,addressDetail,userCreateAt,userUpdateAt,userDeleteAt);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", addressPost='" + addressPost + '\'' +
                ", addressDefault='" + addressDefault + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", userCreateAt=" + userCreateAt +
                ", userUpdateAt=" + userUpdateAt +
                ", userDeleteAt=" + userDeleteAt +
                '}';
    }
}
