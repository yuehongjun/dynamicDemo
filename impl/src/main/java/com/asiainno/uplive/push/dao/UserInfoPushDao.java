package com.asiainno.uplive.push.dao;

import com.asiainno.base.utils.ItvJsonUtil;
import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.base.BatisEntityDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserInfoPushDao extends BatisEntityDao {

	 private Logger logger = LoggerFactory.getLogger(getClass());

    //根据类型，批量查询
    public List<UserInfoPush> batchGetPushInfo(String countryCode) {
    	Map<String, String> params = new HashMap<>();
        params.put("countryCode", countryCode);
        return getSqlSession().selectList("userInfoPush.selectByAudienceCountryCode");
    }

    /**
     * 根据国家批量获取用户信息
     * yhj
     *
     * @return
     */
    public List<UserInfoPush> batchGetUserInfos() {
        return getSqlSession().selectList("userInfoPush.selectUserInfoByCountryCode");
    }

    public List<UserInfoPush> batchGetUserInfos(Integer feature, String countryCode, List<Integer> pushUserTypes,  Long uid, Integer num) {
        List<UserInfoPush> userPushInfos = null;
        Map<String, Object> con =  new HashMap<>();
        con.put("feature", feature);
        con.put("countryCode", countryCode);
        con.put("pushUserTypes", pushUserTypes);
        con.put("num", num);
        con.put("uid", uid);
        //设置dbKey
        long startTime = System.currentTimeMillis();
        userPushInfos = getSqlSession().selectList("userInfoPush.selectUserInfoByCountryCode", con);
        long endTime = System.currentTimeMillis();
        logger.info("test con:"+ItvJsonUtil.writeValue(con)+"  耗时："+(endTime-startTime));
        return userPushInfos;
    }

}

