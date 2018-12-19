package com.asiainno.uplive.push.api.service;


import com.asiainno.uplive.push.api.model.UserInfoPush;

import java.util.List;

public interface IUserPushService {
    //单个查询

    //批量查询
    public List<UserInfoPush> getUserPushInfos(String country);
    
    /**
     * 声包，虎鲸包，主包（其他）。三种 ［虎鲸为224，声播为6666，其他均按照uplive的feature 0来处理］
     * 批量获取用户信息
     * 最近三个月数据
     * yhj
     */
    public List<UserInfoPush> getUserPushInfos(String country, Integer feature, String flag, Long uid, Integer num);


}
