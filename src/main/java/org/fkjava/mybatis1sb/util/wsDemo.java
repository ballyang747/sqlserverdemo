package org.fkjava.mybatis1sb.util;

import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.transform.dom.DOMSource;

import org.fkjava.mybatis1sb.domain.AirLine;
import org.fkjava.mybatis1sb.domain.AirLine.Address;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import cn.com.webxml.DomesticAirline;
import cn.com.webxml.DomesticAirlineSoap;

public class wsDemo {
	public static void main(String[] args) {
		DomesticAirline da = new DomesticAirline();
		DomesticAirlineSoap soap = da.getDomesticAirlineSoap12();
		Object any = soap.getDomesticCity().getAny();
		Element e = (Element) any;
		
		Node airline1 = e.getChildNodes().item(0);
		AirLine airline= JAXB.unmarshal(new DOMSource(airline1), AirLine.class);
		List<Address> addresses = airline.getAddresses();
		String cnCityName = addresses.get(0).getCnCityName();
		System.out.println(cnCityName);
		
	}
	

}
