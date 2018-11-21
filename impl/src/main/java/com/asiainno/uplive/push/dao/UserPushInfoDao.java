package com.asiainno.uplive.push.dao;

import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.base.BatisEntityDao;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserPushInfoDao extends BatisEntityDao {


    //根据类型，批量查询
    public List<UserInfoPush> batchGetPushInfo() {
        return getSqlSession().selectList("userPushInfo.selectByAudienceCountryCode");
    }
    
   /**
    * 根据国家批量获取用户信息
    * yhj
    * @return
    */
    public List<UserInfoPush> batchGetUserInfos() {
        return getSqlSession().selectList("userPushInfo.selectUserInfoByCountryCode");
    }
    
    public List<UserInfoPush> batchGetUserInfos(List<Integer> inclusiveFeatureList, List<Integer> exclusiveFeatureList, String tableId, List pushUserTypes, Integer start, Integer num) {
    	List<UserInfoPush> userPushInfos =null;
    	Map<String, Object> con = new HashMap<>();
        con.put("tableSuffix", tableId);
        con.put("pushUserType", pushUserTypes);
        con.put("inclusiveFeature", com.alibaba.dubbo.common.utils.CollectionUtils.isNotEmpty(inclusiveFeatureList)? inclusiveFeatureList: null);
        con.put("exclusiveFeature", com.alibaba.dubbo.common.utils.CollectionUtils.isNotEmpty(exclusiveFeatureList)? exclusiveFeatureList: null);
        con.put("start", start);
        con.put("limit", num);
        //设置dbKey
//        DBContextHolder.setDBKey(Long.valueOf(dbKey));
        if(CollectionUtils.isNotEmpty(inclusiveFeatureList) || CollectionUtils.isNotEmpty(exclusiveFeatureList)){
        	userPushInfos = getSqlSession().selectList("userPushInfo.selectUserInfoByCountryCode", con);
        }
        return userPushInfos;
    }
    
}

