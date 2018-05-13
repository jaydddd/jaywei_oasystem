package com.qianfeng.oa.dto;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/12.
 */
public class OaUserDTO implements Serializable{


      private Integer userId;
      private String userPhone;

      private String userName;
      private String  userPassword;
      private String userSale;

    public OaUserDTO(Integer userId, String userPhone, String userName, String userPassword, String userSale) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSale = userSale;
    }

    public OaUserDTO() {
        super();
    }

    @Override
    public String toString() {
        return "OaUserDTO{" +
                "userId=" + userId +
                ", userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSale='" + userSale + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OaUserDTO oaUserDTO = (OaUserDTO) o;

        if (userId != null ? !userId.equals(oaUserDTO.userId) : oaUserDTO.userId != null) return false;
        if (userPhone != null ? !userPhone.equals(oaUserDTO.userPhone) : oaUserDTO.userPhone != null) return false;
        if (userName != null ? !userName.equals(oaUserDTO.userName) : oaUserDTO.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(oaUserDTO.userPassword) : oaUserDTO.userPassword != null)
            return false;
        return userSale != null ? userSale.equals(oaUserDTO.userSale) : oaUserDTO.userSale == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userSale != null ? userSale.hashCode() : 0);
        return result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSale() {
        return userSale;
    }

    public void setUserSale(String userSale) {
        this.userSale = userSale;
    }
}
