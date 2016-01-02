import java.util.Scanner;   // Needed for Scanner class
import java.io.*;           // Needed for the File and IOException
/*
 This project will allow you to, "Enter the customers information,
 calculate the customers total bill and quit . It will also do this in 4 different
 methods" 
 (Thomas Martinez COSC-1436 PP2)
 
 */

public class Martinez_PP2 
{
	
	private static Scanner keyboard;
	private static Scanner keyboard1;

	public static void main(String[]args) throws IOException
	{
		
		int number;  // Number input from the user
		
		keyboard = new Scanner(System.in);
		
		// Get the user to chose an option from the main menu
		System.out.println("1. Enter customer information");
		System.out.println("2. Price Lookup");
		System.out.println("3. Display Total Bill");
		System.out.println("4. Quit");
		
		// Records the number input from the user
		number = keyboard.nextInt();   
		
		// This allows the user to select an option from the main menu
		while (number !=4)
		{
			if(number <1 || number>3)                   // Only lets the user choose the options that doesn't
														// allow it to quite the program 
			{ 
				System.out.println("Invalid number");   // Gives a warning to select the right number
				main(null);                             // Allows us to go back to the main menu
			}
			if(number >=1 && number <=3)
			{
				switch (number)                         // Switch method allows us to choose a case
				{
				case 1:
				{
					customerInformation();              // Attaches the method to the case
					main(null);
					while (number !=4)
						if(number <1 || number >3)
						{ 
							System.out.println("Invalid number");
							main(null);
						}
				}
				break;                                  // Stops it from continuing to the next case
				
				case 2:
				{
					priceLookup();                      // Attaches the method to the case
					main(null);
					while (number !=4)
						if(number <1 || number >3)
						{ 
							System.out.println("Invalid number");
							main(null);
						}
				}
				break;
				
				case 3:
				{
					displayTotalBill();                  // Attaches the method to the case
					main(null);
					while (number !=4)
						if(number <1 || number >3)
						{ 
							System.out.println("Invalid number");
							main(null);
						}
				}
				break;
				
				}}}
		}
	
	
		public static void customerInformation() throws IOException
		{
		
		// By pressing 1 this will tell the user to enter the customers information
			String name;         // the name entered by the user
			String address;      // the address entered by the user
			String email;        // the email entered by the user
			
			keyboard1 = new Scanner (System.in);
			
			// Get the user to put in the name
			System.out.println("1. Enter name");
			name = keyboard1.nextLine();
			
			// Get the user to put in the address
			System.out.println("2. Enter address");
			address = keyboard1.nextLine();
			
			// Get the user to put in the email address
			System.out.println("3. Enter email address");
			email = keyboard1.nextLine();
			
			// Display  the information back to the user
			System.out.println("Name: " + name +"");
		    
			System.out.println("Address: " + address +"");
			
			System.out.println("Email: " + email +" has been added to the customer list");
			
			// Open the file.
			PrintWriter outputFile = new PrintWriter("CustomerInformation.txt");
			
			// Write the name of the customer to the file.
			outputFile.println(name);
			
			// Write the address to the file
			outputFile.println(address);
			
			// Write the email to the file
			outputFile.println(email);
			
			// Close the file.
			outputFile.close();
			
			
		
		}
		
		public static void priceLookup() throws IOException
		{
			// Open the file named PriceOfProduct.txt
			File myFile = new File ("PriceOfProduct.txt");
			Scanner inputFile = new Scanner(myFile);
							
				// Read the what is in the file
				while (inputFile.hasNext())
				{
				// Read the beginning of the file
				String PriceOfProduct = inputFile.nextLine();	
				
				// Display the last of the file
				System.out.println(PriceOfProduct);
				}
				// Close the File.
				inputFile.close();
				
			
		}
			
		public static void displayTotalBill() throws IOException
		{
			
		// By pressing 3 this will display the total bill
			String name1;            // the name of the customer entered by the user
			String product;          // the product being used
			double quantity;         // the quantity that is being bought
			double price;            // the price of the product
			double tax = .08;        // the flat rate tax
			double TotalCost = 0;        // the total cost of the quantity * price of product
			double TaxCost;          // the tax cost of the total cost
			double TotalCostOverall; // the total cost of quantity * the price * the tax
			String answer;
			char character;
		    // Create Scanner for number 3 inputs
			Scanner keyboard3 = new Scanner(System.in);
			
			// Get the user to put in name
			System.out.println("The customers name?");
			name1 = keyboard3.nextLine();
			
			// Get the user to put in the product being purchased and 
			// gives an option to add more product
			                                              
			System.out.println("Product being purchased?");       
			product = keyboard3.nextLine();
			
			System.out.println("Quantity of the product?");
			quantity = keyboard3.nextInt();
			
			System.out.println("Price of the product?");
			price = keyboard3.nextInt();
			
			// Open the file.
			PrintWriter outputFile = new PrintWriter("PriceOfProduct.txt");
			
			// Write the product to the file.
			outputFile.println(product);
						
			// Write the price to the file.
			outputFile.println(price);
						
			// Close the file.
			outputFile.close();
			
			// Calculate the Total Cost
			TotalCost = quantity * price;
			
			// Calculate the Tax Cost
			TaxCost =  TotalCost * tax;
			
			// Calculate the Total Cost of the whole purchase including tax
			TotalCostOverall = TotalCost + TaxCost;	

			// Open the file named CustomersInformation 
			File myFile = new File ("CustomerInformation.txt");
			Scanner inputFile = new Scanner(myFile);
			
			// Read the what is in the file
			while (inputFile.hasNext())
			{
			// Read the beginning of the file
			String CustomerInformation = inputFile.nextLine();
				
			// Display the last input of the file
			System.out.println(CustomerInformation);
			}
			
			// Close the File.
			inputFile.close();
			
			// Display the information back to the user
			System.out.println(""+ "\r\r" + "Product Purchased" 
			+ "\t" + "Quantity" + "\t" + "Total Cost"
			+ "\r" + product + "\t\t\t" + "   " + quantity + "\t\t" + "  $" + TotalCost +""
			+ "\r" + "Tax(@ 8%):" + "\t\t\t\t" + "  $" + TaxCost + ""
			+ "\r" + "Total Cost:" + "\t\t\t\t" + "  $" + TotalCostOverall + "");
			
			
		}
		
		}
