package org.fkjava.mybatis1sb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class RandomData {
	@Autowired
	private AddressList addressList;
	
	Random rand = new Random();
	
	public String getRandomCity() {
		
		
				int index = rand.nextInt(30);
				String name = addressList.getAllAdd().get(index);
				
				return name;
			}
	
	public String getRandomType() {
		int index = rand.nextInt(5);
		if(index == 0) {
			return "抽样检验";
		}else if(index ==1) {
			return "每月检查";
		}else if(index == 2) {
			return "每日检查";
		}else if (index ==3) {
			return "每年检查";
		}else {
			return "季度检查";
		}
		
	}
	
	public Integer getRandomNum() {
		
		int index = rand.nextInt(1000);
		
		return index;
	}
	
	

		
	
	}


