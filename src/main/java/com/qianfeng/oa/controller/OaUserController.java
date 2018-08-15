package com.qianfeng.oa.controller;

import com.qianfeng.oa.dao.IOaUserDAO;
import com.qianfeng.oa.dto.OaUserDTO;
import com.qianfeng.oa.listener.LoginListener;
import com.qianfeng.oa.service.IOaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by admin on 2018/5/12.
 */
@Controller
@RequestMapping("/user")
public class OaUserController {

    @Autowired
    private IOaUserService userService;
    @Autowired
    private IOaUserDAO oauser;

    private static final Random rand=new Random();

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getUserLogin(String userPhone, String userPassword, HttpSession session,String index,HttpServletRequest req){


        boolean userPhone1=false;
        HttpSession httpSession=null;
        OaUserDTO userPhone2=null;
        try{
            if(userPhone!=null&&userPhone!=""&&userPassword!=null&&userPassword!=""){
                userPhone1 = userService.getUserPhone(userPhone, userPassword);
                 userPhone2 = oauser.getUserPhone(userPhone);
                httpSession = LoginListener.map.get(userPhone2.getUserName());
            }


            System.out.println(session.toString());

            if(httpSession!=null&&httpSession.equals(session)&&index==null) {
                return "clone";
            }


            session.setAttribute("userLogin", userPhone2);

        if(userPhone1){

             return "main";

          }


        }catch (NullPointerException e){
            e.printStackTrace();
            return "userPhonenot";
        }

        return "fail";
    }


    @RequestMapping("/mainPage")
    public String getUserMain(ModelMap modelMap,String userPhone,HttpSession session){
        String userName = userService.getUserName(userPhone);

        int num = rand.nextInt();
        session.setAttribute("num",num+"");
        session.setAttribute("userName",userName);
        return "redirect:/user/add";
    }
    @RequestMapping("/add")
    public String getUserMainPage(ModelMap modelMap,HttpSession session){
         String num = (String) session.getAttribute("num");
        String userName = (String) session.getAttribute("userName");
        modelMap.put("userName",userName);
        modelMap.put("num",num);
          return "main";
    }

    @RequestMapping("/refresh")
    @ResponseBody
    public String getUserRefresh(String hidden,HttpSession session){

         String num = (String) session.getAttribute("num");

          if(!hidden.equals(num)){

              return "refresh";
          }

        return "success";
    }





}
