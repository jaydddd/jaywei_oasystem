package com.qianfeng.oa.service.impl;


import com.qianfeng.oa.dao.IOaUserDAO;
import com.qianfeng.oa.dto.OaUserDTO;
import com.qianfeng.oa.service.IOaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/5/12.
 */
@Service
public class OaUserService implements IOaUserService {

    @Autowired
     private IOaUserDAO userDAO;
    @Override
    public boolean getUserPhone(String userPhone,String password) {
        OaUserDTO userPhone1 = userDAO.getUserPhone(userPhone);
        if(userPhone1.getUserPhone()==null||userPhone1.getUserPhone().equalsIgnoreCase("")){
             throw  new NullPointerException("用户名不能为空");
        }
         String userPassword = userPhone1.getUserPassword();
         if(userPassword!=null&&userPassword.equalsIgnoreCase(password)){
               return true;
         }

        return false;
    }

    @Override
    public String getUserName(String userPhone) {
        OaUserDTO userPhone1 = userDAO.getUserPhone(userPhone);
        return userPhone1.getUserName();
    }
}
