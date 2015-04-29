package com.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Form1;
import com.domain.LoginForm;
import com.domain.Shop;
import com.service.AdviceManager;

@Controller
@SessionAttributes("loginform")
// ①让ModelMap的loginform属性拥有session级作用域
public class LoginController {

	@RequestMapping(value = "login")
	// , method = RequestMethod.POST
	public String login(LoginForm loginform,ModelMap model,String username) {// 可以将封装好的LoginForm loginform作为入参(自动封装)，也可以将username，password分别作为入参

		 long currentTime = System.currentTimeMillis();// 好像没什么用，直接new Date()不就好了？
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
		 Date date = new Date(currentTime);//long转date
		 String str2 = formatter.format(date);// date 转string
		 System.out.println(str2);
		
		 String str1 = "2008-04-24";
		 SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		 try{
		 Date date2 = formatter2.parse(str1);//string 转date
		 System.out.println(date2);
		 }
		 catch(ParseException e){
		 e.printStackTrace();
		 }

//		 String username = request.getParameter("username");//还可以用老方法，通过request获取参数，,HttpServletRequest request要作为入参
//		 username = new String(username.getBytes("ISO-8859-1"),"utf-8"); //解决乱码的终极办法，没办法的办法

		 ModelAndView mv = new ModelAndView("/index/index");//ModelAndView不如ModelMap实在，不过省了ModelMap model这一步
		 mv.addObject("command","登录成功!");
		 mv.addObject("username",username);
		 mv.addObject("loginform",loginform);

		model.addAttribute("loginform",loginform);
		System.out.println(loginform.getUsername());
		return "index/index";
	}

	@RequestMapping(value = "JqueryUIAutocomplete")
	public String JqueryUIAutocomplete(@ModelAttribute("loginform") LoginForm loginform) {
		// LoginForm loginform2 = (LoginForm)model.get("loginform");
		// 等同于@ModelAttribute("loginform") LoginForm loginform，不过需要ModelMap model作为入参
		System.out.println("loginform:"+loginform.getUsername()+','+loginform.getPassword());
		return "JqueryUIAutocomplete";
	}

	@RequestMapping(value = "get_person")
	public String get_person() {
		AdviceManager manager = new AdviceManager();
		manager.toBeAdvice();
		// manager.throwingException();
		String result = manager.toBeAround("param1","param2");
		System.out.println("返回值："+result);
		return "get_person";
	}

	@RequestMapping(value = "ichartjs")
	public String ichartjs() {
		return "ichartjs/ichartjs";
	}

	@RequestMapping(value = "echarts")
	public String echarts() {
		return "echarts";
	}

	@RequestMapping(value = "getperson/{name}")
	@ResponseBody
	public List<Shop> getperson(@PathVariable String name) {
		List<Shop> shopList = new ArrayList<Shop>();
		Shop shop = new Shop();
		shop.setName(name+1);
		shop.setStaffName("mkyong1");
		shopList.add(shop);
		Shop shop2 = new Shop();
		shop2.setName(name+2);
		shop2.setStaffName("mktong2");
		shopList.add(shop2);
		return shopList;
	}

	@RequestMapping(value = "jquery_form")
	public String jquery_form(ModelMap model,HttpServletRequest request) {
		model.addAttribute("IP",request.getRemoteAddr());
		model.addAttribute("User",request.getRemoteUser()!=null ? 0 : 1);
		model.addAttribute("requestClass",request.getClass());
		model.addAttribute("requestCookies",request.getCookies());
		model.addAttribute("requestContextPath",request.getContextPath());
		return "jquery_form";
	}

	@RequestMapping(value = "post_jquery_form", method = RequestMethod.POST)
	@ResponseBody
	public Form1 post_jquery_form(Form1 form1) {
		return form1;
	}
}
