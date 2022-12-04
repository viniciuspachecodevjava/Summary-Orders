package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter client data: ");
		System.out.println("");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		System.out.println("");

		System.out.println("Enter order data: ");
		System.out.println("Status: "
				+ "\n" + "	PENDING_PAYMENT \r\n"
				+ "	PROCESSING \r\n"
				+ "	SHIPPED \r\n"
				+ "	DELIVERED");
		System.out.println("Type exactly like the options above:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);

		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.println("");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			Double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			OrderItem orderitem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderitem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		sc.close();
	}
}
