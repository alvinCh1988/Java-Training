package com.yao.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.yao.demo.component.FileUtils;
import com.yao.demo.domain.Account;
import com.yao.demo.service.AccountService;

@Controller
public class AccountController {

	
	@Autowired
	private FileUtils fileUtils;
	
	@Autowired
	private AccountService accountSvc;


	/**
	 * 進入表單分頁
	 * @param pageable
	 * @param model
	 * @return
	 */
	@GetMapping("/memberlist")
	public String getAllAccount(
		@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
		Model model) {
		
		Page<Account> pg = accountSvc.findAllByPage(pageable);
		model.addAttribute("page", pg);

		int totalPages = pg.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

		return "memberlist";
	}

	
	/**
	 * 轉入登入頁面 (主畫面)
	 */
	@GetMapping({"/", "/login"})
	public String login() {
		
		return "login";
	}
	
	/**
	 * 轉入新增資料頁面
	 */
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}

	/**
	 * 驗證帳號密碼並登入 進入表單畫面
	 * @param accountName
	 * @param password
	 * @return
	 */
	@PostMapping("/getAccount")
	public String getAccount(
			@RequestParam("accountName") String accountName, 
			@RequestParam("password") String password) {

		Account account = accountSvc.findByAccountNameAndPassword(accountName, password);

		if(account != null) {

			if(account.getAuthGroup().equals("admin")) {
				return "redirect:/memberlist";
			}
		}
			
		return "login";
	}

	/**
	 * 選取一筆資料進入
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/info/{id}")
	public String getAccount(@PathVariable long id, Model model) {
		Account account = accountSvc.getOne(id);
		model.addAttribute("account", account);
		return "info";
	}

	/**
	 * 選取一筆資料進入update畫面
	 * @param id
	 * @param model
	 * @return
	 * @throws FileNotFoundException 
	 */
	@GetMapping("/update/{id}")
	public String getAccountToUpdate(@PathVariable long id, Model model) throws FileNotFoundException {
		Account account = accountSvc.getOne(id);
		model.addAttribute("account", account);
		return "update";
	}

	/**
	 * 選取一筆資料刪除
	 * @param id
	 */
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id) {
		accountSvc.delete(id);
		return "redirect:/memberlist";
	}

	
	/**
	 * 更新一筆資料
	 * @param account
	 * @return
	 */
	@PostMapping("/update")
	public String update(Account account) {
		accountSvc.save(account);
		return "redirect:/memberlist";
	}
	
	/**
	 * 新增一筆資料
	 * @param lastName
	 * @param firstName
	 * @param accountName
	 * @param password
	 * @param file
	 * @param request
	 * @param model
	 * @return
	 * @throws FileNotFoundException 
	 */
	@PostMapping("/insert")
	public String insert(
			@RequestParam("lastName") String lastName, 
			@RequestParam("firstName") String firstName,
			@RequestParam("accountName") String accountName, 
			@RequestParam("password") String password,
			@RequestParam("file") MultipartFile file,
			Model model) {
		
		Account act = new Account();

		String fileName = fileUtils.upload(file, accountName);
		
		if(accountName.equals("") && password.equals("")) {
			model.addAttribute("status", "fail");
			return "register";
		}
		
		act.setAccountName(accountName);
		act.setFirstName(firstName);
		act.setLastName(lastName);
		act.setPassword(password);
		act.setPhotoPath(fileName);
				
		accountSvc.save(act);
		model.addAttribute("status", "success");
		return "register";
	}

}
