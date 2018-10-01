package org.fkjava.mybatis1sb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.fkjava.mybatis1sb.domain.Book;
import org.fkjava.mybatis1sb.domain.MeteringEquipment;
import org.fkjava.mybatis1sb.domain.User;
import org.fkjava.mybatis1sb.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppController {
	
	// 依赖注入服务层
	@Resource
	private AppService appService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/mt")
	public String show() {
		return "meteringToolManage";
		
	}
	

   @ResponseBody
   @RequestMapping(value="/findAll",produces= {"application/json;charset=utf-8"})
	public   List<MeteringEquipment> findAll() {
	   List<MeteringEquipment> allData = appService.getAllData();
	   
	   return allData ;
	}
	

	
}
