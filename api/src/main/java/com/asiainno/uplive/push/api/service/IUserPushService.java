package com.asiainno.uplive.push.api.service;


import com.asiainno.uplive.push.api.model.UserInfoPush;

import java.util.List;

public interface IUserPushService {
    //单个查询

    //批量查询
    public List<UserInfoPush> getUserPushInfos(String country);
    
    /**
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Integer start, Integer num);


}
