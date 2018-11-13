package com.asiainno.uplive.push.dao;

import com.asiainno.uplive.push.api.model.UserPushInfo;
import com.asiainno.uplive.push.base.BatisEntityDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPushInfoDao extends BatisEntityDao {


    //根据类型，批量查询
    public List<UserPushInfo> batchGetPushInfo() {
        return getSqlSession().selectList("userPushInfo.selectByAudienceCountryCode");
    }
}

