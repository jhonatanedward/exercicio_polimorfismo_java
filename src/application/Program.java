package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");

		int numberOfProducts = sc.nextInt();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> listProducts = new ArrayList<Product>();

		for (int i = 1; i <= numberOfProducts; i++) {
			
			System.out.printf("Product #%d data: %n", i);
			
			System.out.print("Common, used or imported (c/u/i)? ");
			
			String type = sc.next();
			
			Product auxProduct = null;
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			switch (type) {
				case "c":
					auxProduct = new Product(name, price);
					break;
				case "i":
					System.out.print("Customs fee: ");
					Double customsFee = sc.nextDouble();
					auxProduct = new ImportedProduct(name, price, customsFee);
					break;
				case "u":
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					String dateFormated = sc.next();
					Date dateImported = sdf.parse(dateFormated);
					auxProduct = new UsedProduct(name, price, dateImported);
					break;
				default:
					break;
			}
			
			listProducts.add(auxProduct);
		}
		System.out.println();
		System.out.println("PRICES TAGS: ");
		for(Product product : listProducts) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
