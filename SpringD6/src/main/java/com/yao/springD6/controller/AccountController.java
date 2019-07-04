package com.yao.springD6.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yao.springD6.component.FileUtils;
import com.yao.springD6.domain.Account;
import com.yao.springD6.service.AccountService;
;


@Controller
public class AccountController {
	
	@Autowired
	private FileUtils fileUtils;
	
	@Autowired
	private AccountService accountService;

    @RequestMapping(value = { "/", "/login" })
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/insert")
    public String insert(
    		@RequestParam("lastName") String lastName, 
    		@RequestParam("firstName") String firstName,
            @RequestParam("accountName") String accountName, 
            @RequestParam("password") String password,
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request,
            Model model) {
    	

    	Account act = new Account();
    	act.setAccountName(accountName);
    	act.setFirstName(firstName);
    	act.setLastName(lastName);
    	act.setPassword(password);
    	
//    	驗證帳號
    	if(accountService.findByAccountName(accountName) != null) {
    		model.addAttribute("accountVO", act);
    		model.addAttribute("accountMsg", "帳號已註冊");
    		return "register";
    	}
    	
    	
//		要上傳的目標檔案存放路徑
    	ServletContext servletContext = request.getServletContext();
    	String fileName = file.getOriginalFilename();
        String localPath = servletContext.getRealPath("/images_uploaded");
        

        String msg = "";
        String imgPath = fileUtils.upload(file, localPath, fileName);
        if (imgPath != null){
        	act.setImgPath(imgPath);
        	accountService.save(act);
        	msg = "success";
        }
        
        model.addAttribute("status", msg);
        return "register";
    }

    @RequestMapping("/getAccount")
    public String getAccount(
    		@RequestParam("accountName") String accountName,
    		@RequestParam("password") String password,              
    		Map<String, String> model) {
    	
    	Account actVO = new Account();
    	actVO = accountService.findByAccountName(accountName);

    	if(actVO == null) {
    		model.put("errorActMsg", "查無此帳號");
    		return "login";
    	} else if (!actVO.getPassword().equals(password)) {
    		model.put("errorPwdMsg", "密碼錯誤");
    		return "login";
    	}
    	
        model.put("account", actVO.getAccountName());

        return "loginSuccess";
    }
    

}
