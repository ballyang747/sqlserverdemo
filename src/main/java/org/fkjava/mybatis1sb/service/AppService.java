package org.fkjava.mybatis1sb.service;

import java.util.List;

import org.fkjava.mybatis1sb.domain.Book;
import org.fkjava.mybatis1sb.domain.MeteringEquipment;
import org.fkjava.mybatis1sb.domain.User;

public interface AppService {
	
	User login(String loginname,String password);

	List<Book> getAll();
	
	Book getById(Integer id);
	
	List<MeteringEquipment> getAllData();
}
