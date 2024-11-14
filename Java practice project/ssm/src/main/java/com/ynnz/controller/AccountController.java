package com.ynnz.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ynnz.pojo.Account;
import com.ynnz.pojo.Pager;
import com.ynnz.service.IAccountService;

@Controller
public class AccountController {

	@Autowired
	private IAccountService accountServiceImpl;

	/**
	 * 接收客户端请求：查所有账户信息
	 * 
	 * @parammodel
	 * @param account 接收搜索条件
	 * @return
	 */
	@RequestMapping("/getList")
	public ModelAndView getList(Account account, Integer pageNumber, Integer pageSize) {
		ModelAndView mv = new ModelAndView();
		// 调用service查询条件
		Pager<Account> pager = accountServiceImpl.getList(account, pageNumber, pageSize);
		mv.addObject("accountList", pager.getList());
		mv.addObject("pager", pager);//把分页组件对象带到页页面
		mv.addObject("ac", account);// 把搜索条件带到查询页面显示

		////////// 查询账户类别////////////////
		mv.setViewName("/index");
		return mv;
	}
	
	
	/**
	 * 接收前端提交的一批ID，实现批量删除
	 * @param allTr
	 * @return
	 */
	@RequestMapping("/batchDelet")
	public String batchDelet(Integer allTr[]) {
		for (int i = 0; i < allTr.length; i++) {
			System.out.println(allTr[i]);
		}
		//调用service的批量删除方法
		accountServiceImpl.batchDel(allTr);
		return "redirect:/getList.do";
	}
	
	/**
	 * 打开新增页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "/accountAdd";
	}
	
	/**
	 * 添加账户信息（支持上传文件）
	 * @param account
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/addAccount")
	public String addAccount(Account account,@RequestParam("myfile")CommonsMultipartFile file) throws IllegalStateException, IOException {
		
		Date d = new Date();
		//定义文件存放的目录
		String path = "D://springfiles/"+d.getTime()+"/"+file.getOriginalFilename();
		File f = new File(path);
		//创建定义的目录，如果创建成功则保存文件
		if(f.mkdirs()) {
			//将文件存到定义的目录下
			file.transferTo(f);
		}
		//////////////////保存表单填写的账户信息到数据库////////////////////////
		return "redirect:/getList.do";
	}
}
