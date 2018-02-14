package com.bbu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbu.dao.ItemsMapper;
import com.bbu.pojo.Items;
import com.bbu.pojo.ItemsExample;

@Service
public class ItemServiceImpl implements ItemService {
   @Resource
   private ItemsMapper itemsMapper;
   
   //查询所有的订单
	@Override
	public List<Items> findAllItems() {
		
		ItemsExample example=new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}
    //根据id修改订单
	@Override
	public void update(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		
	}
	//根据id查找某一订单
	@Override
	public Items findItemsByid(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}
}
