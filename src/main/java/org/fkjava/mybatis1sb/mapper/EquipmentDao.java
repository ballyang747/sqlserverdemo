package org.fkjava.mybatis1sb.mapper;

import java.util.List;

import org.fkjava.mybatis1sb.domain.MeteringEquipment;


public interface EquipmentDao {
	
	void insertData(MeteringEquipment me);
	
 	List<MeteringEquipment> findAll();
	
	
	

}
