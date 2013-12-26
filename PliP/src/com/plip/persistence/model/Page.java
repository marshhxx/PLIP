package com.plip.persistence.model;

// Generated Dec 26, 2013 7:09:50 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Page generated by hbm2java
 */
public class Page implements java.io.Serializable {

	private Long idPage;
	private Order order;
	private PageImage pageImage;
	private Integer productQuantity;
	private int pageNumber;
	private Set pageProducts = new HashSet(0);
	private Set trays = new HashSet(0);

	public Page() {
	}

	public Page(Order order, PageImage pageImage, int pageNumber) {
		this.order = order;
		this.pageImage = pageImage;
		this.pageNumber = pageNumber;
	}

	public Page(Order order, PageImage pageImage, Integer productQuantity,
			int pageNumber, Set pageProducts, Set trays) {
		this.order = order;
		this.pageImage = pageImage;
		this.productQuantity = productQuantity;
		this.pageNumber = pageNumber;
		this.pageProducts = pageProducts;
		this.trays = trays;
	}

	public Long getIdPage() {
		return this.idPage;
	}

	public void setIdPage(Long idPage) {
		this.idPage = idPage;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PageImage getPageImage() {
		return this.pageImage;
	}

	public void setPageImage(PageImage pageImage) {
		this.pageImage = pageImage;
	}

	public Integer getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Set getPageProducts() {
		return this.pageProducts;
	}

	public void setPageProducts(Set pageProducts) {
		this.pageProducts = pageProducts;
	}

	public Set getTrays() {
		return this.trays;
	}

	public void setTrays(Set trays) {
		this.trays = trays;
	}

}
