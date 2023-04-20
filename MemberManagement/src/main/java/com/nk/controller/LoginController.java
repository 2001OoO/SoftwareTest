package com.nk.controller;

import com.nk.domain.Apply;
import com.nk.domain.Ascription;
import com.nk.domain.Organization;
import com.nk.domain.User;
import com.nk.mapper.AscriptionMapper;
import com.nk.service.ApplyService;
import com.nk.service.AscriptionService;
import com.nk.service.OrganizationService;
import com.nk.service.UserService;
import com.nk.service.impl.UserServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private AscriptionService ascriptionService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login_about/login";
    }

    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        List<Ascription> ascriptionList = ascriptionService.ascription_List();
        List<Organization> organizationList = organizationService.organization_List();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<ascriptionList.size();i++){
            list.add(ascriptionList.get(i).getName());
        }
        List<String> organization = new ArrayList<String>();
        List<String> ascription = new ArrayList<String>();
        for(int i=0;i<organizationList.size();i++){
            organization.add(organizationList.get(i).getName());
            ascription.add(organizationList.get(i).getAscription());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("AscriptionList",list);
        modelAndView.addObject("organization", organization);
        modelAndView.addObject("ascription", ascription);
        modelAndView.setViewName("/login_about/register");
        return modelAndView;
    }

    @RequestMapping("/registerUser")
    public String registerUser(Apply apply, String ascription_name, String organization_name){
        System.out.println(ascription_name+organization_name);
        Organization organization = organizationService.findOrganizationByAO(organization_name, ascription_name);
        apply.setOrganization_id(organization.getId());
        applyService.insertApply(apply);
        return "/login_about/register_success";
    }

    @RequestMapping("/loginUser")
    public String loginUser(User user2, HttpSession session){
        User user = userService.findUserByNumber(user2.getNumber());
        if (user==null){
            session.setAttribute("message", "用户名或密码有误");
            return "/login_about/login_fail";
        }else {
            if (user2.getPassword().equals(user.getPassword())){
                session.setAttribute("UserSession", user);
                String jurisdiction = userService.findJurisdictionById(user.getJurisdiction_id());
                session.setAttribute("jurisdiction", jurisdiction);
                Organization organization = userService.findOrganizationById(user.getOrganization_id());
                session.setAttribute("organization", organization.getName());
                session.setAttribute("ascription",organization.getAscription());
                return "/user/user_details";
            }else {
                session.setAttribute("messages", "用户名或密码有误");
                return "/login_about/login_fail";
            }
        }
    }

    @RequestMapping("/toLoginAdmin")
    public String toLoginAdmin(){
        return "/admin/admin_login";
    }

    @RequestMapping("/loginAdmin")
    public String loginAdmin(User user2, HttpSession session){
        User user = userService.findUserByNumber(user2.getNumber());
        if (user==null){
            session.setAttribute("message", "用户不存在");
            return "/login_about/login_fail";
        }else {
            if (user2.getPassword().equals(user.getPassword())){
                if(user.getJurisdiction_id()!=1){
                    session.setAttribute("message", "对不起您不是管理员");
                    return "/login_about/login_fail";
                }else {
                    session.setAttribute("UserSession", user);
                    String jurisdiction = userService.findJurisdictionById(user.getJurisdiction_id());
                    session.setAttribute("jurisdiction", jurisdiction);
                    Organization organization = userService.findOrganizationById(user.getOrganization_id());
                    session.setAttribute("organization", organization.getName());
                    session.setAttribute("ascription", organization.getAscription());
                    return "/admin/admin_details";
                }
            }else {
                session.setAttribute("messages", "用户名或密码有误");
                return "/login_about/login_fail";
            }
        }
    }

    @RequestMapping("/quitLogin")
    public String quitLogin(HttpSession session){
        session.invalidate();
        return "/login_about/login";
    }
}
