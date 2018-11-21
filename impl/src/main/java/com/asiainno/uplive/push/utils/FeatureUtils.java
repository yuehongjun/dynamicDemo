package com.asiainno.uplive.push.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.asiainno.uplive.push.common.EnumConstant;

public class FeatureUtils {
    public static int getFeatureByPushType(int pushType) {
        return pushType / 100;
    }

    public static int getFeature(String feature, Integer build) {
        int featureId = 0;
        if (NumberUtils.isDigits(feature)) {
            featureId = Integer.valueOf(feature);
        }
        if (featureId == 0) {
            if (build != null && build == 7027) {
                featureId = 2;
            }
        }

        return featureId;
    }

    public static int getPushTokenFeature(String feature, Integer build, String bundleId) {
        int featureId = getFeature(feature, build);
        return getPushTokenFeature(featureId, bundleId);
    }

    public static int getPushTokenFeature(int feature, String bundleId) {
        if("com.asiainnovations.taiwnan".equals(bundleId)) {
            return 226;
        } else {
            return feature;
        }
    }

    public static int getFeature(String feature) {
        return getFeature(feature, null);
    }

    public static int getPushType(String feature, Integer pushTypeNumber) {
        return getPushType(getFeature(feature), pushTypeNumber);
    }

    public static int getPushType(int feature, Integer pushTypeNumber) {
        return feature * 100 + pushTypeNumber;
    }


    public static int getTransformedFeature(int feature, Map<Integer, List<Integer>> appAndFeatureListMap) {
        if (MapUtils.isEmpty(appAndFeatureListMap)) {
            return EnumConstant.FEATURE_UPLIVE_MAIN;
        }

        if (feature == EnumConstant.FEATURE_NOT_SPECIFIED) {
            return EnumConstant.FEATURE_NOT_SPECIFIED;
        }

        for (Integer appId : appAndFeatureListMap.keySet()) {
            if (appAndFeatureListMap.get(appId).contains(feature)) {
                return appId;
            }
        }

        return EnumConstant.FEATURE_UPLIVE_MAIN;
    }

    public static List<Integer> getFeatureList(int feature, Map<Integer, List<Integer>> appAndFeatureListMap) {
        for (Integer appId : appAndFeatureListMap.keySet()) {
            if (appAndFeatureListMap.get(appId).contains(feature)) {
                return appAndFeatureListMap.get(appId);
            }
        }

        return new ArrayList<>();
    }


    public static String getAppendKey(int feature, String separator, boolean left, boolean right) {
        if (feature == EnumConstant.FEATURE_UPLIVE_MAIN || feature == EnumConstant.FEATURE_NOT_SPECIFIED) {
            return "";
        } else {
            return (left? separator: "") + "feature_" + feature + (right? separator: "") ;
        }
    }
}
