package mypackage;
import java.util.*;
import mypackage.lineOrder;
public class invoiceApp {
	
	public static void main(String[] args)
	{
		Date d = new Date();
		Scanner keyboard = new Scanner(System.in);
		String book_author, book_title, book_description,yesno,done="n",customer_name;
		int quantinstock, i=0,invoicenumb;
		int noofcopies[] = new int[50];
		double pricepercopy, totalprice, sum=0,tax=0,taxsum=0;
		boolean istaxable;
		lineOrder b[] = new lineOrder[50];
		System.out.println("Enter the Invoice number");
		invoicenumb = keyboard.nextInt();
		System.out.println("Enter customer Name");
		keyboard.nextLine();
		customer_name=keyboard.nextLine();
		keyboard.nextLine();
		
		do
		{
			System.out.println("Name of Author");
			book_author = keyboard.nextLine();
			System.out.println("Book Title");
			book_title = keyboard.nextLine();
			System.out.println("Genre");
			book_description = keyboard.nextLine();
			System.out.println("Is this purchase taxable ? [yes/no]");
			yesno=keyboard.nextLine();
			keyboard.nextLine();
				if(yesno.equals("yes"))
					istaxable =true;
				else 
					istaxable = false;
		
			System.out.println("Total Number of copies available");
			quantinstock = keyboard.nextInt();
			System.out.println("Price per copy of book");
			pricepercopy=keyboard.nextDouble();
			b[i]= new lineOrder (book_author, book_title,book_description,quantinstock,pricepercopy,invoicenumb,istaxable);
			System.out.println("How many copies do you want to buy?");
			noofcopies[i] = keyboard.nextInt();
			totalprice = b[i].getTotalPrice(noofcopies[i]);
			tax=b[i].getTax(noofcopies[i]);
			sum= sum+totalprice;
			taxsum=taxsum+tax;
			i++;
			keyboard.nextLine();
			System.out.println("are you done ? [y/n]");
			done=keyboard.nextLine();
			
			}	while(done.equals("n"));
		
		
		System.out.println("\nInvoice number\t"+invoicenumb);
		System.out.println("\nCustomer Name\t"+ customer_name + "\tDate:\t"+d );
		System.out.println("Author\t\tTitle\t\tGenre\t\tPrice\t\tQuantity\t\tTotal\t\tTax\n");
		for(int j = 0; j< i ; j++)
		{
			System.out.println(b[j].getAuthor()+"\t\t"+b[j].getTitle()+"\t\t"+b[j].getDescription()+"\t\t"+b[j].getPrice()+"\t\t"+noofcopies[j]+"\t\t"+b[j].getTotalPrice(noofcopies[j])+"\t\t"+b[j].getTax(noofcopies[j]));
			
		}
		System.out.println("\nSubTotal:\t"+ sum + "\nTax      :\t"+taxsum+"\nTotal Amount:\t"+ (sum+taxsum));
		
		
	}

}
