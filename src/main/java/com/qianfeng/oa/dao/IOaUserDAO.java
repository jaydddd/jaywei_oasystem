package com.qianfeng.oa.dao;

import com.qianfeng.oa.dto.OaUserDTO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2018/5/12.
 */
public interface IOaUserDAO {

     OaUserDTO getUserPhone(@Param(value = "userPhone")String userPhone);




}
