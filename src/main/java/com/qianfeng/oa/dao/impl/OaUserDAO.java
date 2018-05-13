package com.qianfeng.oa.dao.impl;

import com.qianfeng.oa.dao.IOaUserDAO;
import com.qianfeng.oa.dto.OaUserDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2018/5/12.
 */
@Repository
public class OaUserDAO implements IOaUserDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public OaUserDTO getUserPhone(String userPhone) {
        OaUserDTO oaUser = sqlSession.selectOne("com.qianfeng.oa.user.user_phone", userPhone);
        return oaUser;
    }


}
