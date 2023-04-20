package com.nk.controller;

import com.nk.domain.*;
import com.nk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ApplyService applyService;
    @Autowired
    private AscriptionService ascriptionService;
    @Autowired
    private JurisdictionService jurisdictionService;

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;

    @RequestMapping("/toAdminInfo")
    public String toAdminInfo(){
        return "/admin/admin_details";
    }

    @RequestMapping("/toAdminDetails")
    public ModelAndView toAdminDetails(){
        List<User> userList = userService.findAllUser();
        List<String> ascriptionList = new ArrayList<String>();
        List<String> organizationList = new ArrayList<String>();
        List<String> jurisdictionList = new ArrayList<String>();
        for(int i=0;i<userList.size();i++){
            ascriptionList.add(organizationService.findOrganizationById(userList.get(i).getOrganization_id()).getAscription());
            organizationList.add(organizationService.findOrganizationById(userList.get(i).getOrganization_id()).getName());
            jurisdictionList.add(jurisdictionService.findJurisdictionById(userList.get(i).getJurisdiction_id()).getName());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("ascriptionList",ascriptionList);
        modelAndView.addObject("jurisdictionList",jurisdictionList);
        modelAndView.addObject("organizationList",organizationList);
        modelAndView.setViewName("/admin/admin_manage");
        return modelAndView;
    }

    @RequestMapping("/toAdminUpdateUser")
    public String toAdminUpdateUser(HttpServletRequest request, Model model){
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.findUserById(id);
        List<Jurisdiction> jurisdictionList = jurisdictionService.findAllJurisdiction();
        List<Ascription> ascriptionList = ascriptionService.ascription_List();
        List<Organization> organizationList = organizationService.organization_List();
        List<String> organizations = new ArrayList<String>();
        List<String> ascriptions = new ArrayList<String>();
        for(int i=0;i<organizationList.size();i++){
            organizations.add(organizationList.get(i).getName());
            ascriptions.add(organizationList.get(i).getAscription());
        }
        String jurisdiction = jurisdictionService.findJurisdictionById(user.getJurisdiction_id()).getName();
        String ascription = organizationService.findOrganizationById(user.getOrganization_id()).getAscription();
        String organization = organizationService.findOrganizationById(user.getOrganization_id()).getName();
        model.addAttribute("jurisdictionList",jurisdictionList);
        model.addAttribute("ascriptionList",ascriptionList);
        model.addAttribute("organizations",organizations);
        model.addAttribute("ascriptions",ascriptions);
        model.addAttribute("ascription",ascription);
        model.addAttribute("organization",organization);
        model.addAttribute("jurisdiction",jurisdiction);
        model.addAttribute("user",user);
        return "/admin/admin_info_update";
    }

    @RequestMapping("/adminUpdateUser")
    public String adminUpdateUser(Integer id, User user, String ascription_name, String organization_name, String jurisdiction_name){
        Organization organization = organizationService.findOrganizationByAO(organization_name, ascription_name);
        user.setOrganization_id(organization.getId());
        Jurisdiction jurisdiction = jurisdictionService.findIdByJurisdiction(jurisdiction_name);
        user.setJurisdiction_id(jurisdiction.getId());
        userService.updateUserById(id,user.getUsername(),user.getPassword(),user.getOrganization_id(),user.getJurisdiction_id(),
                user.getRegister_time(),user.getNumber());
        return "redirect:toAdminDetails";
    }

    @RequestMapping("/dropUser")
    public String dropUser(Integer id){
        userService.deleteUserById(id);
        return "redirect:toAdminDetails";
    }

    @RequestMapping("/toApplyManagement")
    public String toApplyManagement(Model model){
        List<Apply> applyList=applyService.findAllApply();
        List<String> organizationList = new ArrayList<>();
        List<String> ascriptionList = new ArrayList<>();
        for(int i=0;i<applyList.size();i++){
            organizationList.add(organizationService.findOrganizationById(applyList.get(i).getOrganization_id()).getName());
            ascriptionList.add(organizationService.findOrganizationById(applyList.get(i).getOrganization_id()).getAscription());
        }
        model.addAttribute("applyList",applyList);
        model.addAttribute("organizationList",organizationList);
        model.addAttribute("ascriptionList",ascriptionList);
        return "/admin/apply_management";
    }

    @RequestMapping("/acceptApply")
    public String acceptApply(Integer id){
        Apply apply = applyService.findApplyById(id);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date_str = sdf.format(date);
        Integer i = 0;
        String s = i>=10? i.toString():"0"+i.toString();
        String number = date_str + s;
        User user = userService.findUserByNumber(number);
        while (user!=null){
            i++;
            s = i>=10? i.toString():"0"+i.toString();
            number = date_str + s;
            user = userService.findUserByNumber(number);
        }
        User user5 = new User();
        user5.setNumber(number);
        user5.setPassword(apply.getPassword());
        user5.setRegister_time(date);
        user5.setUsername(apply.getUsername());
        user5.setOrganization_id(apply.getOrganization_id());
        user5.setJurisdiction_id(2);
        userService.addUser(user5);
        applyService.deleteApplyById(id);
        return "redirect:toApplyManagement";
    }

    @RequestMapping("/refuseApply")
    public String refuseApply(Integer id){
        applyService.deleteApplyById(id);
        return "redirect:toApplyManagement";
    }

    @RequestMapping("/toEditRegion")
    public String toEditRegion(Model model){
        List<Ascription> ascriptionList = ascriptionService.ascription_List();
        model.addAttribute("ascriptionList",ascriptionList);
        return "/admin/admin_editregion";
    }

    @RequestMapping("/dropRegion")
    public String dropRegion(String name, HttpSession session){
        session.setAttribute("message", "");
        List<Organization> organizationList = organizationService.organization_List();
        for(int i=0;i<organizationList.size();i++){
            if(organizationList.get(i).getAscription().equals(name)){
                session.setAttribute("message", "有组织正在使用此地址，无法删除");
                return "redirect:toEditRegion";
            }
        }
        ascriptionService.deleteAscription(name);
        return "redirect:toEditRegion";
    }

    @RequestMapping("/addRegion")
    public String addRegion(String name){
        ascriptionService.addAscription(name);
        return "redirect:toEditRegion";
    }

    @RequestMapping("/toEditOrganization")
    public String toEditOrganization(Model model){
        List<Organization> organizationList = organizationService.organization_List();
        List<Ascription> ascriptionList = ascriptionService.ascription_List();
        model.addAttribute("organizationList",organizationList);
        model.addAttribute("ascriptionList",ascriptionList);
        return "/admin/admin_editorganization";
    }

    @RequestMapping("/dropOrganization")
    public String dropOrganization(Integer id, HttpSession session){
        session.setAttribute("message", "");
        List<User> userList = userService.findAllUser();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getOrganization_id()==id){
                session.setAttribute("message", "有用户正在使用此组织，不可删除");
                return "redirect:toEditOrganization";
            }
        }
        organizationService.deleteOrganizationById(id);
        return "redirect:toEditOrganization";
    }

    @RequestMapping("/addOrganization")
    public String addOrganization(String ascription_name,String organization_name){
        System.out.println(ascription_name+organization_name);
        organizationService.addOrganization(organization_name,ascription_name);
        return "redirect:toEditOrganization";
    }
}
