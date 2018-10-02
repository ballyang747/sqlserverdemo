package org.fkjava.mybatis1sb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.fkjava.mybatis1sb.domain.Book;
import org.fkjava.mybatis1sb.domain.MeteringEquipment;
import org.fkjava.mybatis1sb.mapper.BookMapper;
import org.fkjava.mybatis1sb.mapper.EquipmentDao;
import org.fkjava.mybatis1sb.util.DateRandom;
import org.fkjava.mybatis1sb.util.RandomData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Resource
	private BookMapper bookMapper;
	
	@Resource
	private EquipmentDao equipmentDao;
	
	@Resource
	private RandomData randomData;

	@Test
	public void contextLoads() {
		List<Book> books =bookMapper.findAll();
		
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
	
	@Test
	public void findAll() {
	List<MeteringEquipment> findAll = equipmentDao.findAll();
		
		for (MeteringEquipment meteringEquipment : findAll) {
			System.out.println(meteringEquipment);
		}
		
	}
	

	@Test
	public void insertTest() {
		
		try {
			
			
			DateRandom dr = new DateRandom();
			List<MeteringEquipment> list1 = new ArrayList<MeteringEquipment>();
			
			for (int i = 0; i < 200; i++) {
				MeteringEquipment me1 = new MeteringEquipment();
				 String randomCity = randomData.getRandomCity();
					
			      me1.setArea(randomCity);
			      me1.setRemark("123");
			      me1.setName("123");
			      me1.setNumber(randomData.getRandomNum());
			      me1.setQuantity(randomData.getRandomNum());
			      me1.setType(randomData.getRandomType());
			      me1.setChecktype("123");
			      me1.setChecktime(dr.getRanDate("2018-10-01", "2018-10-30"));
			      me1.setTochecktime(dr.getRanDate("2018-10-01", "2018-10-30"));
			      me1.setTousetime(dr.getRanDate("2018-10-01", "2018-10-30"));
			      list1.add(me1);
			   
			}
			equipmentDao.insertData(list1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	


	

}
