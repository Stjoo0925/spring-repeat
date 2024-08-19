package com.test.springrepeat.user.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    @Column(name = "user_name")
    private final String userName;

    @Column(name = "user_age")
    private final Integer userAge;

    @Column(name = "user_ageaddress_post")
    private final String addressPost;

    @Column(name = "user_address_default")
    private final String addressDefault;

    @Column(name = "user_address_detail")
    private final String addressDetail;

    @Column(name = "user_create_at")
    @CreationTimestamp
    private final LocalDateTime userCreateAt;

    @Column(name = "user_update_at")
    @UpdateTimestamp
    private final LocalDateTime userUpdateAt;

    protected UserEntity() {
        this.id = null;
        this.userName = null;
        this.userAge = null;
        this.addressPost = null;
        this.addressDefault = null;
        this.addressDetail = null;
        this.userCreateAt = null;
        this.userUpdateAt = null;
    }

    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.userAge = builder.userAge;
        this.addressPost = builder.addressPost;
        this.addressDefault = builder.addressDefault;
        this.addressDetail = builder.addressDetail;
        this.userCreateAt = builder.userCreateAt;
        this.userUpdateAt = builder.userUpdateAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String userName;
        private Integer userAge;
        private String addressPost;
        private String addressDefault;
        private String addressDetail;
        private LocalDateTime userCreateAt;
        private LocalDateTime userUpdateAt;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userAge(Integer userAge) {
            if (userAge < 20) {
                throw new IllegalArgumentException("회원의 나이는 20살 이상이여야 합니다.");
            }
            this.userAge = userAge;
            return this;
        }

        public Builder addressPost(String addressPost) {
            this.addressPost = addressPost;
            return this;
        }

        public Builder addressDefault(String addressDefault) {
            this.addressDefault = addressDefault;
            return this;
        }

        public Builder addressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
            return this;
        }

        public Builder userCreateAt(LocalDateTime userCreateAt) {
            this.userCreateAt = userCreateAt;
            return this;
        }

        public Builder userUpdateAt(LocalDateTime userUpdateAt) {
            this.userUpdateAt = userUpdateAt;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
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
                '}';
    }
}
