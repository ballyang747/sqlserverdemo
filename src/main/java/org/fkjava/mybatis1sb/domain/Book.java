package org.fkjava.mybatis1sb.domain;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String image;
	private String author;
	private Double price;
	private String remark;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Book(String name, String image, String author, Double price) {
		super();
		this.name = name;
		this.image = image;
		this.author = author;
		this.price = price;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", image=" + image + ", author=" + author + ", price=" + price
				+ "]";
	}
	
	
	
	

}