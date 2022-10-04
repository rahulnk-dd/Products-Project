package com.products.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
	private String productName;
	private String productType;    
	private String quantity;    
    private Integer sellingPrice;
    private Integer cost;
 
    public ProductEntity() {
    }
 
    public ProductEntity(Integer productId, String productName, String productType, String quantity,
			Integer sellingPrice, Integer cost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.cost = cost;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", quantity=" + quantity + ", sellingPrice=" + sellingPrice + ", cost=" + cost + "]";
	}
    
    
}