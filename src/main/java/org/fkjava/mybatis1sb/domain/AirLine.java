package org.fkjava.mybatis1sb.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Airline1")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirLine {

	@XmlElement(name = "Address")
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Address {
		public String getEnCityName() {
			return enCityName;
		}
		public void setEnCityName(String enCityName) {
			this.enCityName = enCityName;
		}
		public String getCnCityName() {
			return cnCityName;
		}
		public void setCnCityName(String cnCityName) {
			this.cnCityName = cnCityName;
		}
		public String getAbbreviation() {
			return abbreviation;
		}
		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		private String enCityName;
		private String cnCityName;
		@XmlElement(name = "Abbreviation")
		private String abbreviation;
	}
}
