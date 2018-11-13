package com.asiainno.uplive.push.api.service;


import com.asiainno.uplive.push.api.model.UserPushInfo;

import java.util.List;

public interface IUserPushService {
    //单个查询

    //批量查询
    public List<UserPushInfo> getUserPushInfos(String country);


}
