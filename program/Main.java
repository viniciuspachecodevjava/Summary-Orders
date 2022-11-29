package program;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter client data: ");
		System.out.println("");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = (Date) fmt.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		System.out.println("");

		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
	}

}
