package com.asiainno.uplive.push.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
        return userInfoPushDao.batchGetPushInfo(country);
    }
    
    /**
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    @Override
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Integer start, Integer num) {
        List<Integer> flags = null;
        if(flag!= null){
        	flags = Arrays.asList(converInts(flag.split(",")));
        }
        return userInfoPushDao.batchGetUserInfos(feature, country, flags, start, num);
    }
    
    private static Integer[] converInts(String[] flags){
    	Integer[] flagInt = new Integer[flags.length];
    	int j = 0;
    	for (int i = 0; i < flags.length; i++) {
    		if(StringUtils.isNotEmpty(flags[i])){
    			flagInt[j++] = Integer.parseInt(flags[i]);
    		}
		}
    	return flagInt;
    }

}
