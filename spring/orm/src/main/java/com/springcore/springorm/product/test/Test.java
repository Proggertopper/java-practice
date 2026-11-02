package com.springcore.springorm.product.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.springorm.product.dao.ProductDao;
import com.springcore.springorm.product.entity.Product;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springorm/product/test/config.xml");
		ProductDao productDao =(ProductDao) context.getBean("productDao");
//        Product product = new Product();
//        product.setId(1);
//        product.setDesc("it is awesome");
//        product.setName("Iphone");
//        product.setPrice(800);;
        
//        productDao.delete(product);
//        productDao.create(product);
//        productDao.update(product);
		
		Product product = productDao.find(1);
		List<Product> products = productDao.findAll();
		System.out.println(products);
	}

}
