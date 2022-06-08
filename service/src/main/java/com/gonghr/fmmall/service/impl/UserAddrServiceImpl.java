package com.gonghr.fmmall.service.impl;

import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import com.gonghr.fmmall.dao.UserAddrDao;
import com.gonghr.fmmall.entity.UserAddr;
import com.gonghr.fmmall.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Autowired
    private UserAddrDao userAddrDao;

    @Override
    public Result queryUserAddrById(String userId) {
        List<UserAddr> list = userAddrDao.queryUserAddrById(userId);
        return new Result(ResultCodeEnum.SUCCESS, list);
    }
}
