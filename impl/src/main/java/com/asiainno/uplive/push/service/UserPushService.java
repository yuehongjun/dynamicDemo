package com.asiainno.uplive.push.service;

import com.asiainno.uplive.push.api.model.UserPushInfo;
import com.asiainno.uplive.push.api.service.IUserPushService;
import com.asiainno.uplive.push.dao.UserPushInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPushService implements IUserPushService {

    @Autowired
    private UserPushInfoDao userPushInfoDao;

    @Override
    public List<UserPushInfo> getUserPushInfos(String country) {
        return userPushInfoDao.batchGetPushInfo();
    }
}
