package com.boot.project.Shopping.Cart.Dto;

import lombok.Data;

@Data
public class ProductDto {
	private int productId;
	private String productName;
	private String productCategory;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDto [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append("]");
		return builder.toString();
	}

}
