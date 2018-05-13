package com.qianfeng.oa.test;

import com.qianfeng.oa.dao.IOaUserDAO;
import com.qianfeng.oa.dto.OaUserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2018/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class OaUserTest {


     @Autowired
     private IOaUserDAO oaUser;


     @Test
     public void getOaUserPhone(){
          OaUserDTO userPhone = oaUser.getUserPhone("15271934940");
         System.out.println(userPhone.getUserPhone());
     }



}
