package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(Long id) {
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		
		
		TbItemExample example = new TbItemExample();
		//创建查询条件
		com.taotao.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

}
