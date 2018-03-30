package com.newer.dao;

import com.newer.bean.Userinfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoMapper")
public interface UserinfoMapper {
    @Select("select * from userinfo"+
            " where username=#{userName}"+
             " and userpwd=#{userPwd}")
    Userinfo findByNameAndPwd(Userinfo userinfo);
    @Update("update userinfo set userpwd = #{userPwd} where userid = #{userId}")
    int updatePwd(Userinfo userinfo);

    @Select("select count(userid) from userinfo where username=#{userName}")
    int findName(String userinfo);

    @Select("select * from userinfo")
    List<Userinfo> findAll();


}
