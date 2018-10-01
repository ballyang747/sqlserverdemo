package org.fkjava.mybatis1sb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkjava.mybatis1sb.domain.Book;

public interface BookMapper {
	
	@Select(" select * from tb_book ")
	List<Book> findAll(); 
	
	Book findById(Integer id);

}
