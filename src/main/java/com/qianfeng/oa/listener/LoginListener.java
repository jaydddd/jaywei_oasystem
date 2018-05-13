package com.qianfeng.oa.listener;

import com.qianfeng.oa.dto.OaUserDTO;

import javax.servlet.http.*;

import java.util.HashMap;

import java.util.Map;

/**
 * Created by admin on 2018/5/13.
 */

public class LoginListener implements HttpSessionAttributeListener {

    public static final  Map<String,HttpSession> map=new HashMap<>();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        String name = event.getName();
        if(name.equals("userLogin")){
            OaUserDTO oauserDto= (OaUserDTO) event.getValue();
             if(map.get(oauserDto.getUserName())!=null){
                 HttpSession httpSession = map.get(oauserDto.getUserName());
                 httpSession.removeAttribute(oauserDto.getUserName());
                 //销毁session
                 httpSession.invalidate();
             }
            map.put(oauserDto.getUserName(),event.getSession());
        }
    }

    /**
     * 当像session移除的时候触发
     * @param event
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

        String name = event.getName();
        if(name.equals("userLogin")){
            OaUserDTO oauserDto= (OaUserDTO) event.getValue();
            map.remove(oauserDto.getUserName());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {


    }
}
