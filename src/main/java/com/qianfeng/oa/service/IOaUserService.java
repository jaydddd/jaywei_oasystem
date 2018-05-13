package com.qianfeng.oa.service;

/**
 * Created by admin on 2018/5/12.
 */
public interface IOaUserService {


     boolean getUserPhone(String userPhone,String password);

     String getUserName(String userPhone);
}
