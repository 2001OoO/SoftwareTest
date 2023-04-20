package com.nk.controller;

import com.nk.domain.Ascription;
import com.nk.domain.Organization;
import com.nk.domain.User;
import com.nk.service.AscriptionService;
import com.nk.service.OrganizationService;
import com.nk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private AscriptionService ascriptionService;
    @Autowired
    private UserService userService;

//    跳转用户信息页面
    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "/user/user_details";
    }

    @RequestMapping("/toUpdateUserInfo")
    public ModelAndView toUpdateUserInfo(HttpSession session){
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
        modelAndView.addObject("organizations", organization);
        modelAndView.addObject("ascriptions", ascription);
        modelAndView.setViewName("/user/user_info_update");
        return modelAndView;
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(HttpSession session, User user, String ascription_name, String organization_name){
        Organization organization = organizationService.findOrganizationByAO(organization_name, ascription_name);
        user.setOrganization_id(organization.getId());
        User user1 = (User) session.getAttribute("UserSession");
        user.setRegister_time(user1.getRegister_time());
        user.setNumber(user1.getNumber());
        user.setJurisdiction_id(user1.getJurisdiction_id());
        userService.updateUserById(user1.getId(),user.getUsername(),user.getPassword(),user.getOrganization_id(),user.getJurisdiction_id(),
                user.getRegister_time(),user.getNumber());

        session.setAttribute("UserSession", user);
        session.setAttribute("organization", organization.getName());
        session.setAttribute("ascription",organization.getAscription());
        return "/user/user_details";
    }

}
