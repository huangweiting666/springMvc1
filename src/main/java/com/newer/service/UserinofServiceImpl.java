package com.newer.service;

import com.newer.bean.Userinfo;
import com.newer.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserinofServiceImpl implements UserinfoService{
    @Autowired
    private UserinfoMapper userinfoMapper;


    public Userinfo login(Userinfo userinfo) {
        return userinfoMapper.findByNameAndPwd(userinfo);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,rollbackFor = Exception.class)
    public int updatePwd(Userinfo userinfo) {
        return userinfoMapper.updatePwd(userinfo);
    }

    public int findName(String userinfo) {
        return userinfoMapper.findName(userinfo);
    }

    public List<Userinfo> findAll() {
        return userinfoMapper.findAll();
    }
}
