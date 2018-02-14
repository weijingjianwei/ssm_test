package com.bbu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bbu.pojo.Items;
import com.bbu.service.ItemService;
//解决测试版本冲突
@Controller
public class ItemController {
	@Autowired
    private ItemService itemService;
	@RequestMapping("/list")
	private ModelAndView itemList(){
		ModelAndView modelAndView=new ModelAndView();
		//调用service层完成订单的查询
		List<Items> list = itemService.findAllItems();
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	//根据id修改订单详情
	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest request,Model model ){
		//获取参数
		String id = request.getParameter("id");
		//先完成查找订单，然后跳转
		int ids = Integer.parseInt(id);
		Items items = itemService.findItemsByid(ids);
		model.addAttribute("item", items);
		return "editItem";
		
	}
	//修改订单的方法,将其分装在items的pojo对象中
	@RequestMapping("/updateItem")
    public String update(Items items,HttpServletRequest request) throws Exception{
		
		items.setCreatetime(new Date());
    	itemService.update(items);
    	return "success";
    }
//	@RequestMapping("/updateItem")
//	public String update1(Integer id,String name,Float price,String detail) throws Exception{
//		Items items=new Items();
//		items.setId(id);
//		items.setName(name);
//		items.setPrice(price);
//		items.setDetail(detail);
//		items.setCreatetime(new Date());
//		itemService.update(items);
//		return "success";
//	}
}
