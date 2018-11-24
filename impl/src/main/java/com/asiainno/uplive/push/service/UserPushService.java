package com.asiainno.uplive.push.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.api.service.IUserPushService;
import com.asiainno.uplive.push.dao.UserInfoPushDao;

@Service
public class UserPushService implements IUserPushService {

    @Autowired
    private UserInfoPushDao userInfoPushDao;
    

    @Override
    public List<UserInfoPush> getUserPushInfos(String country) {
        return userInfoPushDao.batchGetPushInfo();
    }
    
    /**
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    @Override
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Integer start, Integer num) {
        List flags = null;
        if(flag!= null){
        	flags = Arrays.asList(flag.split(","));
        }
        return userInfoPushDao.batchGetUserInfos(feature, country, flags, start, num);
    }

}
