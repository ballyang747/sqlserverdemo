package org.fkjava.mybatis1sb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.fkjava.mybatis1sb.domain.Book;
import org.fkjava.mybatis1sb.domain.MeteringEquipment;
import org.fkjava.mybatis1sb.domain.User;
import org.fkjava.mybatis1sb.mapper.BookMapper;
import org.fkjava.mybatis1sb.mapper.EquipmentDao;
import org.fkjava.mybatis1sb.mapper.UserMapper;
import org.fkjava.mybatis1sb.service.AppService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



// 服务层实现
@Service
public class AppServiceImpl implements AppService {
	
	// 依赖注入持久层接口
	@Resource
	private UserMapper userMapper;
	@Resource
	private BookMapper bookMapper;
	
	@Resource
	private EquipmentDao equipmentDao;

	@Override
	public User login(String loginname, String password) {
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		return userMapper.login(user);
	}

	@Override
	public List<Book> getAll() {

		return bookMapper.findAll();
	}

	@Override
	public Book getById(Integer id) {
		
		return bookMapper.findById(id);
	}

	@Override
	public List<MeteringEquipment> getAllData() {
	
	

		
		return equipmentDao.findAll();
	}

}
