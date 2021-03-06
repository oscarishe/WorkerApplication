package net.codejava.Service;

import java.util.List;

import net.codejava.Model.Product;
import net.codejava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return repo.findAll();
	}
	public float totalPrice() {
		List<Product> product = repo.findAll();
		float sum =0;
		for(int i=0;i<product.size();i++)
			sum = sum + product.get(i).getPrice();
		return sum;
	}
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
