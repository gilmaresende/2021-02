package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n\n=== TEST 2: seller findByDepartment ===");

		Department dp = new Department(2, "");
		List<Seller> list = sellerDao.findByDePartment(dp);

		for (Seller s : list) {
			System.out.println(s);

		}
		
		System.out.println("\n\n=== TEST 3: seller findAll ===");
		
		List<Seller> list2 = sellerDao.findAll();
		for (Seller s : list2) {
			System.out.println(s);
		}
		
		/*System.out.println("\n\n=== TEST 4: seller insert ===");
		Seller s = new Seller(null,"Greg","greg@gmail.com", new Date(), 4000.0, dp);
		sellerDao.insert(s);
		System.out.println(s);*/
		
		System.out.println("\n\n=== TEST 5: seller insert ===");
		seller =  sellerDao.findById(1);
		seller.setName("Martha Wainer");
		sellerDao.update(seller);
		System.out.println("Update Complete");
	}
}
