package com.yao.springD4.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yao.springD4.component.FileUtils;
import com.yao.springD4.model.AccountVO;
import com.yao.springD4.service.IAccountImpl;


@Controller
public class AccountController {
	
//	這邊不確定要不要再改 ↓↓↓↓↓↓↓↓↓↓
	@Autowired
	private FileUtils fileUtils;
	
	@Autowired
	private IAccountImpl accountImpl;

    @RequestMapping(value = { "/", "/login" })
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value="/insert")
    public String insert(
    		@RequestParam("lastName") String lastName, 
    		@RequestParam("firstName") String firstName,
            @RequestParam("account") String account, 
            @RequestParam("password") String password,
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request,
            Model model) {
    	

    	AccountVO accountVO = new AccountVO();
    	accountVO.setAccount(account);
    	accountVO.setFirstName(firstName);
    	accountVO.setLastName(lastName);
    	
//    	驗證帳號
    	if(accountImpl.getOneAct(account) != null) {
    		model.addAttribute("accountVO", accountVO);
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
        	accountImpl.addAct(lastName, firstName, account, password, imgPath);
        	msg = "success";
        }
        
        model.addAttribute("status", msg);
        return "register";
    }

    @RequestMapping("/getAccount")
    public String getAccount(
    		@RequestParam("account") String account,
    		@RequestParam("password") String password,              
    		Map<String, String> model) {
    	
    	AccountVO actVO = new AccountVO();
    	actVO = accountImpl.getOneAct(account);

    	if(actVO == null) {
    		model.put("errorActMsg", "查無此帳號");
    		return "login";
    	} else if (!actVO.getPassword().equals(password)) {
    		model.put("errorPwdMsg", "密碼錯誤");
    		return "login";
    	}
    	
        model.put("account", actVO.getAccount());

        return "loginSuccess";
    }
    

}
