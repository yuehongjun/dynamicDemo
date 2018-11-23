package com.asiainno.uplive.push.common;

import java.io.Serializable;
import java.util.List;

public class DaoRequestInfo implements Serializable {
    Integer feature;
    String countryCode;
    List<Integer> pushUserTypes;
    Integer start;
    Integer num;

    public Integer getFeature() {
        return feature;
    }

    public void setFeature(Integer feature) {
        this.feature = feature;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Integer> getPushUserTypes() {
        return pushUserTypes;
    }

    public void setPushUserTypes(List<Integer> pushUserTypes) {
        this.pushUserTypes = pushUserTypes;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public DaoRequestInfo() {
    }

    public DaoRequestInfo(Integer feature, String countryCode, List<Integer> pushUserTypes, Integer start, Integer num) {
        this.feature = feature;
        this.countryCode = countryCode;
        this.pushUserTypes = pushUserTypes;
        this.start = start;
        this.num = num;
    }
}
