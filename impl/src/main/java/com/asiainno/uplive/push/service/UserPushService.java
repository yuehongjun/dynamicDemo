package com.asiainno.uplive.push.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.api.service.IUserPushService;
import com.asiainno.uplive.push.dao.UserInfoPushDao;
import com.asiainno.uplive.user.common.EnumConstant;

@Service
public class UserPushService implements IUserPushService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	 
    @Autowired
    private UserInfoPushDao userInfoPushDao;
    

    @Override
    public List<UserInfoPush> getUserPushInfos(String country) {
        return userInfoPushDao.batchGetPushInfo(country);
    }
    
    /**
     * 声包，虎鲸包，主包（其他）。三种 ［虎鲸为224，声播为6666，其他均按照uplive的feature 0来处理］
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    @Override
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Long uid, Integer num) {
        List<Integer> flags = null;
        if(StringUtils.isNotEmpty(flag)){
        	flags = converInts(flag.split(","));
        }
        List<Integer> inclusiveFeatureList = new ArrayList<Integer>();
        List<Integer> exclusiveFeatureList = new ArrayList<Integer>();
        if(feature != null && (feature == EnumConstant.FEATURE_UPVOICE_MAIN || feature == EnumConstant.FEATURE_ORCALIVE_MAIN)){
        	inclusiveFeatureList.add(feature);
        }else{
        	exclusiveFeatureList.add(EnumConstant.FEATURE_UPVOICE_MAIN);//声包
        	exclusiveFeatureList.add(EnumConstant.FEATURE_ORCALIVE_MAIN);//虎鲸
        }
        return userInfoPushDao.batchGetUserInfosByFeature(inclusiveFeatureList, exclusiveFeatureList, country, flags, uid, num);
    }
    
    private static ArrayList<Integer> converInts(String[] flags){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < flags.length; i++) {
    		if(StringUtils.isNotEmpty(flags[i])){
    			list.add(Integer.parseInt(flags[i]));
    		}
		}
    	return list;
    }
    
}
