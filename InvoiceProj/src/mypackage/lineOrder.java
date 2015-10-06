package mypackage;

public class lineOrder {

	private String author, title, description;
	private int quantity,invoice_number;
	private double price;
	private boolean isInStock,taxable; 
	/*variable declaration*/
	public lineOrder( String aut, String tit, String descript, int stk, double cost, int invoiceno, boolean istaxable)
	{
	setAuthor(aut);
	setTitle(tit);
	setDescription(descript);
	invoice_number=invoiceno;
	quantity =stk;
	price =cost;
	taxable=istaxable;
	
	if (stk > 0)
		isInStock = true;
	else 
		isInStock = false;
	}
	public lineOrder()
	{
	setAuthor("");
	setTitle("");
	setDescription("");
	taxable = false;
	quantity = 0;
	price = 0;
	isInStock = false;
	invoice_number = 0 ;
	}
	
	
	public double getTotalPrice (int reqQuantity)
	{
		double subtotal=0;
		
			if(this.isInStock == true)
			{ 
				if(reqQuantity<=this.quantity)
				subtotal = reqQuantity * this.price;
				else
				subtotal = 0;
			}
				
		
			else
				subtotal = 0;	
	
			
		return subtotal;
	}
	

	public double getTax (int reqQuantity)
	{
		double subtotal=0,tax =0, taxrate = 1;
		if(this.isInStock)
		{	
			if(this.taxable==true&&reqQuantity<=this.quantity)
				{
				subtotal = reqQuantity * this.price;
				tax=taxrate*subtotal;
				
				}
			else
				tax =0;
				}
		
		return tax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int p) {
		this.price=p;
	}	
	
	
		
	}
