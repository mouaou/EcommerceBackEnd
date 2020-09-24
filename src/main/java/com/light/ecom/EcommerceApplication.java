package com.light.ecom;

import com.light.ecom.dao.CategoryRepository;
import com.light.ecom.dao.ProductRepository;
import com.light.ecom.entities.Category;
import com.light.ecom.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRep;
	@Autowired
	private CategoryRepository catRep;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Computers",null,null);
		Category cat2 = new Category(null,"Phones",null,null);
		Category cat3 = new Category(null,"Printers",null,null);
		catRep.save(cat1);
		catRep.save(cat2);
		catRep.save(cat3);
		Random rnd = new Random();
		int i;
		for(i=0;i<10;i++){
			catRep.findAll().forEach(c->{
						Product p = new Product();
						p.setName(RandomString.make(18));
						p.setCurrentPrice(100+rnd.nextInt(10000));
						p.setAvailable(rnd.nextBoolean());
						p.setPromotion(rnd.nextBoolean());
						p.setSelected(rnd.nextBoolean());
						p.setCategory(c);
						productRep.save(p);

					}

			);
		}


	}
}
