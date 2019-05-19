/**
 * 
 */
package com.boot.project.Shopping.Cart.Service;

import java.util.List;

import com.boot.project.Shopping.Cart.Dto.CartDto;
import com.boot.project.Shopping.Cart.Dto.CartResponse;
import com.boot.project.Shopping.Cart.Dto.ProductDto;

/**
 * @author M1046717
 *
 */
public interface ShoppingCartService {
	ProductDto getProductDetails(int productId);

	CartDto getCartDetails(int cartNo);

	CartResponse deleteProduct(List<Integer> productId);
}
