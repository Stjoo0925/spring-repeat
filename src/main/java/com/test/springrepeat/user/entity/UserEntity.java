package com.test.springrepeat.user.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Column(name = "user_address_detail" )
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
        Pattern p = Pattern.compile("^[가-힣]{3}$");

        Matcher m = p.matcher(userName);
        if(m.matches()){
            this.userName = userName;
            return this;
        }else {
           throw new IllegalArgumentException("[경고]성명은 공백이 없는 한글로만 이루어져야 하며 3글자로만 되어져야 합니다.");
        }
    }

    public UserEntity userAge(Integer userAge) {
        if(userAge >= 20){
            this.userAge = userAge;
            return this;
        }else {
            throw new IllegalArgumentException("20살 보다 작습니다.");
        }
    }

    public UserEntity addressPost(String addressPost) {
        Pattern p = Pattern.compile("^[0-4]*$");

        Matcher m = p.matcher(addressPost);

        if(m.matches()){
            this.addressPost = addressPost;

        }else {
            throw new IllegalArgumentException("[경고]숫자는 5자리 숫자 까지만 가능합니다.");
        }
        return this;
    }

    public UserEntity addressDefault(String addressDefault) {
        if(addressDefault == null){
            throw new IllegalArgumentException("기본주소는 생략 할 수 없습니다.");
        }
        this.addressDefault = addressDefault;
        return this;
    }

    public UserEntity addressDetail(String addressDetail) {
        if(addressDetail==null){
            throw new IllegalArgumentException("기본 주소는 삭제 할 수 없습니다.");
        }
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

