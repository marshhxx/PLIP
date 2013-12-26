package com.plip.persistence.model;

// Generated Dec 26, 2013 7:09:50 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Long idProduct;
	private ProductCategory productCategory;
	private String name;
	private Integer weight;
	private String description;
	private int code;
	private String laboratory;
	private Integer imageNumber;
	private boolean enabled;
	private Set images = new HashSet(0);
	private Set pageProducts = new HashSet(0);
	private Set trayStatuses = new HashSet(0);

	public Product() {
	}

	public Product(ProductCategory productCategory, String name,
			String description, int code, String laboratory, boolean enabled) {
		this.productCategory = productCategory;
		this.name = name;
		this.description = description;
		this.code = code;
		this.laboratory = laboratory;
		this.enabled = enabled;
	}

	public Product(ProductCategory productCategory, String name,
			Integer weight, String description, int code, String laboratory,
			Integer imageNumber, boolean enabled, Set images, Set pageProducts,
			Set trayStatuses) {
		this.productCategory = productCategory;
		this.name = name;
		this.weight = weight;
		this.description = description;
		this.code = code;
		this.laboratory = laboratory;
		this.imageNumber = imageNumber;
		this.enabled = enabled;
		this.images = images;
		this.pageProducts = pageProducts;
		this.trayStatuses = trayStatuses;
	}

	public Long getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}

	public Integer getImageNumber() {
		return this.imageNumber;
	}

	public void setImageNumber(Integer imageNumber) {
		this.imageNumber = imageNumber;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set getImages() {
		return this.images;
	}

	public void setImages(Set images) {
		this.images = images;
	}

	public Set getPageProducts() {
		return this.pageProducts;
	}

	public void setPageProducts(Set pageProducts) {
		this.pageProducts = pageProducts;
	}

	public Set getTrayStatuses() {
		return this.trayStatuses;
	}

	public void setTrayStatuses(Set trayStatuses) {
		this.trayStatuses = trayStatuses;
	}

}
