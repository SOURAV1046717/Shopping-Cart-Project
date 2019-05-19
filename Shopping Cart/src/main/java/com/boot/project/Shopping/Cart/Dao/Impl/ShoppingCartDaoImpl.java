package com.boot.project.Shopping.Cart.Dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.project.Shopping.Cart.Dao.ShoppingCartDao;
import com.boot.project.Shopping.Cart.Entity.Cart;
import com.boot.project.Shopping.Cart.Entity.Product;

@Transactional
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	private static final Logger log = LoggerFactory.getLogger(ShoppingCartDao.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Product getProduct(int productId) {
		log.info("ShoppingCartDaoImpl Product getProduct Starts");
		Query<Product> query = null;
		try {
			String sql = "Select e from " + Product.class.getName() + " e Where e.productId =:productId ";
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery(sql, Product.class);
			query.setParameter("productId", productId);
		} catch (HibernateException e) {
			log.error("ShoppingartDaoImpl Product getProduct{}", e);
		}
		return (Product) query.getSingleResult();
	}

	@Override
	public Cart getCart(int cartNo) {
		log.info("ShoppingCartDaoImpl Product getCart Starts");
		Query<Cart> query = null;
		try {
			String sql = "Select e from " + Cart.class.getName() + " e Where e.cartNo =:cartNo ";
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery(sql, Cart.class);
			query.setParameter("cartNo", cartNo);
		} catch (HibernateException e) {
			log.error("ShoppingartDaoImpl Cart getCart{}", e);
		}
		return (Cart) query.getSingleResult();
	}

	@Override
	public boolean deleteproduct(List<Integer> productIds) {
		log.info("ShoppingCartDaoImpl Product deleteCart Starts");
		boolean flag = false;
		Transaction transaction;
		Session session = null;
		try {

			String sql = "Select e from " + Cart.class.getName() + " e Where e.cartNo =:cartNo ";
			session = sessionFactory.getCurrentSession();
			transaction = session.getTransaction();
			for (int pVal : productIds) {
				Product product = session.get(Product.class, pVal);
				session.delete(product);
				transaction.commit();
				flag = true;
			}

		} catch (HibernateException e) {
			log.error("ShoppingartDaoImpl Cart getCart{}", e);
		} finally {
			session.close();
		}
		return flag;
	}

}
