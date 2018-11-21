package com.asiainno.uplive.push.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.api.service.IUserPushService;
import com.asiainno.uplive.push.common.EnumConstant;
import com.asiainno.uplive.push.dao.UserPushInfoDao;
import com.asiainno.uplive.push.utils.FeatureUtils;
import com.asiainno.uplive.user.service.IFeatureService;

@Service
public class UserPushService implements IUserPushService {

    @Autowired
    private UserPushInfoDao userPushInfoDao;
    
    @Autowired
    private IFeatureService featureService;

    @Override
    public List<UserInfoPush> getUserPushInfos(String country) {
        return userPushInfoDao.batchGetPushInfo();
    }
    
    /**
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    @Override
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Integer start, Integer num) {
        List<Integer> inclusiveFeatureList = null;
        List<Integer> exclusiveFeatureList = null;
        if (feature != null && !featureService.isUpLive(feature)) {
            inclusiveFeatureList = getFeatureList(feature);
        } else {
            exclusiveFeatureList = getFeatureList(EnumConstant.FEATURE_UPVOICE_MAIN);
        }
        List flags = null;
        if(flag!= null){
        	flags = Arrays.asList(flag.split(","));
        }
        
        return userPushInfoDao.batchGetUserInfos(inclusiveFeatureList, exclusiveFeatureList, country, flags, start, num);
    }

    private List<Integer> getFeatureList(Integer feature) {
        Map<Integer, List<Integer>> appAndFeatureMap = featureService.getAppAndFeatureMap();
        return FeatureUtils.getFeatureList(feature, appAndFeatureMap);
    }
}
