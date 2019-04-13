package com.miaoshaproject.service;

import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {
    //通过对象id获取对象
    UserModel getUserById(Integer id);
    //注册
    void register(UserModel userModel) throws BussinessException;

    /**
     * 登陆验证
     * @param telphone 用户注册的手机
     * @param encrptPassword 用户加密后的密码
     */
    UserModel validateLogin(String telphone,String encrptPassword) throws BussinessException;

}
