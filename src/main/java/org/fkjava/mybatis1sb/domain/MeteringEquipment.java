package org.fkjava.mybatis1sb.domain;

import java.util.Date;

import org.fkjava.mybatis1sb.util.DataTimeJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MeteringEquipment {
	
	
	public Integer id;
	public Integer number;
	public String name;
	public String type;
	public Integer quantity;
	public String area;
	public String checktype;
	@JsonSerialize(using=DataTimeJsonSerializer.class)
	public Date checktime;
	@JsonSerialize(using=DataTimeJsonSerializer.class)
	public Date tochecktime;
	@JsonSerialize(using=DataTimeJsonSerializer.class)
	public Date tousetime;
	public String remark;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getChecktype() {
		return checktype;
	}
	public void setChecktype(String checktype) {
		this.checktype = checktype;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public Date getTochecktime() {
		return tochecktime;
	}
	public void setTochecktime(Date tochecktime) {
		this.tochecktime = tochecktime;
	}
	public Date getTousetime() {
		return tousetime;
	}
	public void setTousetime(Date tousetime) {
		this.tousetime = tousetime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "MeteringEquipment [id=" + id + ", number=" + number + ", name=" + name + ", type=" + type
				+ ", quantity=" + quantity + ", area=" + area + ", checktype=" + checktype + ", checktime=" + checktime
				+ ", tochecktime=" + tochecktime + ", tousetime=" + tousetime + ", remark=" + remark + "]";
	}
	
	
	
	
	
	
	
	
	

}
