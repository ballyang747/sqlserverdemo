package org.fkjava.mybatis1sb.util;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.transform.dom.DOMSource;

import org.fkjava.mybatis1sb.domain.AirLine;
import org.fkjava.mybatis1sb.domain.AirLine.Address;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import cn.com.webxml.DomesticAirline;
import cn.com.webxml.DomesticAirlineSoap;

@Service
public class AddressList {
    private static AddressList al;
    
    private  List<String> list;

	    private AddressList() {}

	    public static AddressList getAllList() {
	        if (al == null) {
	        	al = new AddressList();
	        	List<String> allAdd = al.getAllAdd();
	        	al.setList(allAdd);
	        }
	        return al;
	    }
	    
	    public List<String> getList() {
			return list;
		}

		public void setList(List<String> list) {
			this.list = list;
		}

		public List<String> getAllAdd(){
			List<String> name = new ArrayList<>();
			
	    	DomesticAirline da = new DomesticAirline();
			DomesticAirlineSoap soap = da.getDomesticAirlineSoap12();
			Object any = soap.getDomesticCity().getAny();
			Element e = (Element) any;
			
			Node airline1 = e.getChildNodes().item(0);
			AirLine airline= JAXB.unmarshal(new DOMSource(airline1), AirLine.class);
			List<Address> addresses = airline.getAddresses();
			
			for (Address address : addresses) {
				String cnCityName = address.getCnCityName();
				name.add(cnCityName);
			}
			
	    	return name;
	    }
	   
	    
	}

