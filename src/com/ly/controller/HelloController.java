package com.ly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("msg","Hello Index");
        modelView.setViewName("index");
        System.err.println("执行Index");
        return modelView;
    }
    @RequestMapping("/show")
    public ModelAndView show(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("msg","Hello show");
        modelView.setViewName("index");
        System.err.println("执行show");
        return modelView;
    }
    
    @RequestMapping("/result")
    public ModelAndView validate(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //获取session中的验证码的值
        HttpSession session = request.getSession();  
        String code = (String) session  
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        
        //获取输入框的值
        String validateCode = request.getParameter("validateCode");
        ModelAndView modelView = new ModelAndView();
        
        if(code.equals(validateCode)) {
            modelView.addObject("msg","验证通过");
        }else {
            modelView.addObject("msg","验证码输入错误");
        }
        
        modelView.setViewName("result");
        return modelView;
        
    }

}
