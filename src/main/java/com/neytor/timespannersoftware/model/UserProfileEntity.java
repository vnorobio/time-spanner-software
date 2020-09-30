package com.neytor.timespannersoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "users_profiles")
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;

    public UserProfileEntity() {
        // Empty constructor
    }

    public UserProfileEntity(Long id, UserEntity user, ProfileEntity profile) {
        this.id = id;
        this.user = user;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }
}
