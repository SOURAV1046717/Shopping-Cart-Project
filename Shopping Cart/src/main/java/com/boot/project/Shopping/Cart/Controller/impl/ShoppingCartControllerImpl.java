package com.boot.project.Shopping.Cart.Controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.project.Shopping.Cart.Controller.ShoppingCartController;
import com.boot.project.Shopping.Cart.Dto.CartDto;
import com.boot.project.Shopping.Cart.Dto.CartResponse;
import com.boot.project.Shopping.Cart.Dto.ProductDto;
import com.boot.project.Shopping.Cart.Service.ShoppingCartService;

@RestController
public class ShoppingCartControllerImpl implements ShoppingCartController {
	private static final Logger log = LoggerFactory.getLogger(ShoppingCartControllerImpl.class);

	@Autowired
	ShoppingCartService shoppingcartService;

	@Override
	public ProductDto getProductInfo(@PathVariable("productId") int productId) {
		log.info("Product Dto getPrductInfo() starts");
		ProductDto productDto = null;
		productDto = shoppingcartService.getProductDetails(productId);
		return productDto;
	}

	@Override
	public ResponseEntity<CartResponse> deleteProduct(@RequestBody List<Integer> productId) {
		log.info("Product Dto deletePrductInfo() start");
		CartResponse cartResponse = shoppingcartService.deleteProduct(productId);
		if (cartResponse.isSuccess() == true) {
			return new ResponseEntity<CartResponse>(cartResponse, HttpStatus.OK);

		}
		return new ResponseEntity<CartResponse>(cartResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	public CartDto getCartInfo(@PathVariable("cartNo") int cartNo) {
		log.info("Product Dto getCartInfo() starts");
		CartDto cartDto = null;
		cartDto = shoppingcartService.getCartDetails(cartNo);
		return cartDto;
	}

}
