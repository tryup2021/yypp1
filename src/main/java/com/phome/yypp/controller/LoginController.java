package com.phome.yypp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phome.yypp.pojo.Nums;
import com.phome.yypp.service.NumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private NumsService numsService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    /*
    * 登录用户，需要去数据库中寻找用户
    * */
    @PostMapping("/login")
    public String loginNums(Nums nums,
                            HttpSession session,
                            HttpServletRequest request,
                            HttpServletResponse response)  {
        int i = numsService.selectNum(nums);
        if (i>0){
            //当数据库中有该用户时，跳转到date页面
            session.setAttribute("loginUser",nums.getNum());
            return "table/date";
        }else{
            //当数据库中没有该用户时，返回以下内容并到login页面
            request.setAttribute("msg","未创建用户");
            return "login";
        }
    }
    /*
    * 注册用户账号和密码，只需要保存即可
    * */
    @PostMapping("/register")
    public String registerUser(Nums nums){
        numsService.saveNum(nums);
        return "login";
    }
    /*
    * ajax 发送请求 获取数据
    * */
    @GetMapping("/date")
    @ResponseBody  //转化为json格式数据，和视图是矛盾的，所以不建议使用RestCotroller
    public PageInfo<Nums> date(@RequestParam(value="pn",defaultValue = "1") Integer pn,HttpServletRequest request){
        System.out.println("contentType：==============================" + request.getHeader("Content-Type"));
        System.out.println("contentType：==============================" + request.getHeader("Accept"));

        //pageNum=pn，pageSIze：一页多少行数据
        PageHelper.startPage(pn,6);
        //navigatePages: 一页获取的数据
        PageInfo<Nums> numsPageInfo = new PageInfo<>(numsService.queryNum(),5);
        return numsPageInfo;
    }
}
