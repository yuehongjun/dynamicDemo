package com.asiainno.uplive.push.dao;

import com.asiainno.uplive.push.api.model.UserInfoPush;
import com.asiainno.uplive.push.base.BatisEntityDao;

import com.asiainno.uplive.push.common.DaoRequestInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserInfoPushDao extends BatisEntityDao {


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

    public List<UserInfoPush> batchGetUserInfos(Integer feature, String countryCode, List<Integer> pushUserTypes, Integer start, Integer num) {
        List<UserInfoPush> userPushInfos = null;
        DaoRequestInfo con = new DaoRequestInfo(feature, countryCode, pushUserTypes, start, num);
        //设置dbKey
//        DBContextHolder.setDBKey(Long.valueOf(dbKey));
        userPushInfos = getSqlSession().selectList("userInfoPush.selectUserInfoByCountryCode", con);
        return userPushInfos;
    }

}

