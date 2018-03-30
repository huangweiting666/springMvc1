package com.newer.service;

import com.newer.bean.Userinfo;

import java.util.List;

public interface UserinfoService {

    Userinfo login(Userinfo userinfo);

    int updatePwd(Userinfo userinfo);

    int findName(String userinfo);

    List<Userinfo> findAll();
}
