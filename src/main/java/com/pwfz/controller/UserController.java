package com.pwfz.controller;

import com.mchange.v2.beans.BeansUtils;
import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.model.Json;
import com.pwfz.model.SessionInfo;
import com.pwfz.model.UserModel;
import com.pwfz.repository.UserRepository;
import com.pwfz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Json login(UserModel userModel, HttpSession session){
        Json json = new Json();
        System.out.println(userModel);
        UserModel user = userService.login(userModel);
        if (user != null){
            SessionInfo sessionInfo = new SessionInfo();
            BeanUtils.copyProperties(user,sessionInfo);
            session.setAttribute("sessionInfo",sessionInfo);
            json.setSuccess(true);
            json.setMsg("登录成功");
            json.setObj(user);
        }else {
            json.setSuccess(false);
            json.setMsg("用户名或密码不正确");
        }
        return json;
    }

    @RequestMapping("register")
    @ResponseBody
    public Json register(UserModel userModel){
        Json json = new Json();
        try {
            userService.register(userModel);
            json.setSuccess(true);
            json.setMsg("注册成功");
            json.setObj(userModel);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg("用户已经存在");
        }
        return json;
    }

    @RequestMapping("logout")
    @ResponseBody
    public Json logout(HttpSession session){
        Json json = new Json();
        if (session != null) {
            session.invalidate();
        }
        json.setSuccess(true);
        json.setMsg("注销成功！");
        return json;
    }

    @RequestMapping("saveBody")
    @ResponseBody
    public Json saveBody(String body){
        //todo 从session获取id
        int userId = 1;
        Json json = new Json();
        userService.saveBody(body,userId);
        json.setSuccess(true);
        json.setMsg("保存成功");
        return json;
    }

    @RequestMapping("getBody")
    @ResponseBody
    public Json getBody(){
        //todo 从session获取id
        int userId = 1;
        Json json = new Json();
        String body = userService.getBody(userId);
        json.setSuccess(true);
        json.setMsg("页面body");
        json.setObj(body);
        return json;
    }

    @RequestMapping("showLogin")
    public String showLogin(){
        return "login";
    }

    @RequestMapping("showRegister")
    public String showRegister(){
        return "register";
    }
}
