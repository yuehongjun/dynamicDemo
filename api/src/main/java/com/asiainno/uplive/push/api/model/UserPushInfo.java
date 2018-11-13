package com.asiainno.uplive.push.api.model;

import java.io.Serializable;

public class UserPushInfo implements Serializable {
    private Long uid;
    private int pushType;
    private String pushToken;
    private String country;
    private String language;
    private int lastLoginTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getPushType() {
        return pushType;
    }

    public void setPushType(int pushType) {
        this.pushType = pushType;
    }

    public UserPushInfo() {
    }
}
