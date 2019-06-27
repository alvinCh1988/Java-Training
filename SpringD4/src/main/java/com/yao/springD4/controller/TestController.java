package com.yao.springD4.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yao.springD4.model.AccountDAO;
import com.yao.springD4.model.AccountVO;

@Controller
public class TestController {

    @RequestMapping(value = { "/", "/login" })
    public String login() {
        System.out.println("test!!!!!");
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName,
            @RequestParam("account") String account, @RequestParam("password") String password,
            @RequestParam("file") MultipartFile file) {

        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(account);
        System.out.println(password);
        System.out.println(file.getOriginalFilename());

        File path = new File("C:/upload");
        if (!path.exists())
        path.mkdirs();

        File covertFile = new File(path + file.getOriginalFilename());
        
        try {
            covertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(covertFile);
            fout.write(file.getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return "login";
    }

    @RequestMapping("/getAccount")
    public String getAccount(@RequestParam("account") String account,
                             @RequestParam("password") String password,
                             Map<String, Object> model) {
    	
    						AccountDAO accountDAO = new AccountDAO();
    						AccountVO accountVO = new AccountVO();
    						accountVO = accountDAO.findAccount(account);

                                model.put("account", accountVO.getAccount());

        return "loginSuccess";
    }

}
