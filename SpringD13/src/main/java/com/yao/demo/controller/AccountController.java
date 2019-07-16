package com.yao.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yao.demo.component.FileUtils;
import com.yao.demo.domain.Account;
import com.yao.demo.service.AccountService;
import com.yao.demo.valid.AccountForm;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private FileUtils fileUtils;

	@Autowired
	private AccountService accountSvc;

	/**
	 * 進入表單分頁
	 * 
	 * @param pageable
	 * @param model
	 * @return
	 */
	@GetMapping("/memberlist")
	public String getAllAccount(
			@PageableDefault(size = 5, sort = { "id" }, direction = Sort.Direction.ASC) Pageable pageable,
			Model model) {

		Page<Account> pg = accountSvc.findAllByPage(pageable);
		model.addAttribute("page", pg);

		int totalPages = pg.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "memberlist";
	}

	/**
	 * 轉入登入頁面 (主畫面)
	 */
	@GetMapping({ "/", "/index" })
	public String loginPage() {

		return "login";
	}

	/**
	 * 轉入新增資料頁面
	 */
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("accountForm", new AccountForm());
		return "register";
	}

	/**
	 * 驗證帳號密碼並登入 進入表單畫面
	 * 
	 * @param accountName
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public String logingPost(
			@RequestParam("accountName") String accountName,
			@RequestParam("password") String password,
			HttpSession session, Model model) {
		

		Map<String, Object> map = accountSvc.findByAccountNameAndPassword(accountName, password);

		String status = map.get("status").toString();

		if (status.equals("SUCCESS")) {
			session.setAttribute("account", map.get("account"));
			return "redirect:/account/memberlist";
		}
		model.addAttribute("status", status);

		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("account");
		return "login";
	}

	/**
	 * 選取一筆資料進入
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/info/{accountName}")
	public String getAccount(@PathVariable String accountName, Model model) {
		Account account = accountSvc.findByAccountName(accountName);
		model.addAttribute("account", account);
		return "info";
	}

	/**
	 * 選取一筆資料進入update畫面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws FileNotFoundException
	 */
	@GetMapping("/update/{accountName}")
	public String getAccountToUpdate(@PathVariable String accountName, Model model) throws FileNotFoundException {
		Account account = accountSvc.findByAccountName(accountName);
		
		model.addAttribute("account", account);
		return "update";
	}

	/**
	 * 選取一筆資料刪除
	 * 
	 * @param id
	 */
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id) {
		accountSvc.delete(id);
		return "redirect:/account/memberlist";
	}

	/**
	 * 更新一筆資料
	 * 
	 * @param account
	 * @return
	 */
	@PostMapping("/update")
	public String update(@Valid Account account, BindingResult result) {
		
		if (result.hasErrors()) {
			return "update";
		}
		
		accountSvc.save(account);
		return "redirect:/account/memberlist";
	}

	/**
	 * 新增一筆資料
	 * 
	 * @param account
	 * @param file
	 * @param model
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(@Valid AccountForm accountForm, BindingResult result, @RequestParam("file") MultipartFile file,
			Model model) {

		if (!accountForm.confirmPassword()) {
			result.rejectValue("confirmPassword", "confirmError", "Two password inputs are different");
		}

		if (accountSvc.checkAccountNameUsed(accountForm.getAccountName())) {
			result.rejectValue("accountName", "confirmError", "Account Used");
		}

		if (result.hasErrors()) {
			model.addAttribute("status", "fail");
			return "register";
		}

		String fileName = fileUtils.upload(file, accountForm.getAccountName());
		accountForm.setPhotoPath(fileName);
		Account account = accountForm.ConvertToAccount();

		accountSvc.save(account);
		model.addAttribute("status", "success");
		return "register";
	}
}
