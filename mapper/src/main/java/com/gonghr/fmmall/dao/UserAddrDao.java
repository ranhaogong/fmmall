package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.UserAddr;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddrDao {
    public List<UserAddr> queryUserAddrById(String userId);

}
