package mypackage;
import java.text.NumberFormat;
import java.util.*;

import mypackage.lineOrder2;

public class invoiceApp2 {

	public static void main(String[] args)
	{
		Date d = new Date();
		Scanner keyboard = new Scanner(System.in);
		String book_author, book_title, book_description,yesno,done="n",customer_name;
		int quantinstock, i=0,invoicenumb;
		int noofcopies[] = new int[50];
		double pricepercopy, totalprice, sum=0,tax=0,taxsum=0;
		boolean istaxable;
		lineOrder2 b[] = new lineOrder2[50];
		System.out.println("Enter the Invoice number");
		invoicenumb = keyboard.nextInt();
		System.out.println("Enter customer Name");
		keyboard.nextLine();
		customer_name=keyboard.nextLine();
		keyboard.nextLine();
		
		do
		{
			System.out.println("Item Description");
			book_author = keyboard.nextLine();
			/*System.out.println("Book Title");
			book_title = keyboard.nextLine();
			System.out.println("Genre");
			book_description = keyboard.nextLine();*/
			System.out.println("Is this purchase taxable ? [yes/no]");
			yesno=keyboard.nextLine();
			keyboard.nextLine();
				if(yesno.equals("yes"))
					istaxable =true;
				else 
					istaxable = false;
		
			System.out.println("quantity?");
			noofcopies[i] = keyboard.nextInt();
			quantinstock = 5000;
			System.out.println("Price ?\n");
			pricepercopy=keyboard.nextDouble();
			b[i]= new lineOrder2(book_author,quantinstock,pricepercopy,invoicenumb,istaxable);
			/*System.out.println("How many copies do you want to buy?");
			noofcopies[i] = keyboard.nextInt();*/
			totalprice = b[i].getTotalPrice(noofcopies[i]);
			tax=b[i].getTax(noofcopies[i]);
			sum= sum+totalprice;
			taxsum=taxsum+tax;
			i++;
			keyboard.nextLine();
			System.out.println("are you done ? [y/n]");
			done=keyboard.nextLine();
			
			}	while(done.equals("n"));
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("\nInvoice number\t"+invoicenumb);
		System.out.println("\nCustomer Name\t"+ customer_name + "\tDate:\t"+d );
		System.out.println("Author\tPrice\tQty\tTotal\t\tTax\n");
		for(int j = 0; j< i ; j++)
		{
			System.out.printf("\n"+b[j].getAuthor()+"\t"+/*b[j].getTitle()+"\t\t"+b[j].getDescription()+*/ currency.format(b[j].getPrice()) +"\t"+noofcopies[j]+"\t"+ currency.format(b[j].getTotalPrice(noofcopies[j])) +"\t\t"+ currency.format(b[j].getTax(noofcopies[j])));
			
		}
		System.out.println("\nSubTotal:\t"+ currency.format(sum) + "\nTax      :\t"+currency.format(taxsum)+"\nTotal Amount:\t"+ currency.format((sum+taxsum)));
		
		
	}

}
