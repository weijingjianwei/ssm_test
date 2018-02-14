package com.bbu.service;

import java.util.List;

import com.bbu.pojo.Items;

public interface ItemService {
   public List<Items> findAllItems();
   public Items findItemsByid(Integer id);
   public void update(Items items) throws Exception;   
  
}
