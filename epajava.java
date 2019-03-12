//Loading the required packages
import java.util.*;
import java.lang.*;
public class Account
{
	//Adding data members to a class
	int acc_no;
	String acc_type;
	double acc_bal;
	String accholder_name;
	//Adding static/non-static variables
	static String acc_branch;
	static double annual_interestrate;
	//Adding a static block
	//Initialising static memberswith desired values
	static
	{
		acc_branch="Vijayawada";
		annual_interestrate=4.5;
	}
	//Adding constructors to a class
	//no argument constructor
	public Account()
	{
		acc_no=0;
		acc_type="Unknown";
		acc_bal=500.00;
        accholder_name="Unknown";
	}
	//Parameterised constructor
	//constructor overloading
	public Account(int acc_no,String acc_type,double acc_bal,String accholder_name)
	{
		this();//invoking a current class constructor
		this.acc_no=acc_no;
		this.acc_type=acc_type;
		this.acc_bal=acc_bal;
		this.accholder_name=accholder_name;
	}
	//Adding method to a class
	//Adding withdraw method to a class
	public void withDraw(double amount)
	{
		double minBalance=500.00;
		if(acc_bal-amount>minBalance)
		{
			System.out.println("Amount has been withdrawn succesfully");
			acc_bal=acc_bal-amount;
			double balance=getBalance();
			System.out.println("Account balance after withdrawl is :"+balance);
		}
		else
			System.out.println("Insufficient balance!Withdraw is not possible");
	}
	//Adding a deposit method to a class
	public void Deposit(double amount)
	{
		acc_bal=acc_bal+amount;
		double balance=getBalance();
		System.out.println("Account balance after deposit is:"+balance);
	}
	public void addInterest()
	{
		acc_bal=acc_bal+acc_bal*getMonthlyInterestrate();
		double balance=getBalance();
		System.out.println("Account balance after adding interest is:"+balance);
	}
	public double getMonthlyInterestrate()
	{
		return (annual_interestrate/100)/12;
	}
	public double getBalance()
	{
		return acc_bal;
	}
	public String getDate()
	{
		Date d=new Date();
		String date=d.toString();
		System.out.println("Account created on:"+date);
		return date;
	}
	//Adding a display method to display account details
	public void show()
	{
		System.out.println("***Account details***");
		System.out.println("Account number:"+acc_no);
		System.out.println("Account Type:"+acc_type);
		System.out.println("Account holdername:"+accholder_name);
		System.out.println("Account Balance:"+acc_bal);
		System.out.println("Account Branch:"+acc_branch);
		System.out.println("Account created on:"+getDate());
	}
}
	class AccountTest
	{
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			int choice;
			double amount;
			//Creating an object
			Account a1=null;
			do
			{
				System.out.println("***Menu***");
				System.out.println("1.Create");
				System.out.println("2.Withdraw");
				System.out.println("3.Deposit");
				System.out.println("4.Add Interest");
				System.out.println("5.Details");
				System.out.println("6.Account Balance");
				System.out.println("7.exit");
				System.out.println("Enter your choice");
				choice=sc.nextInt();
				switch(choice)
				{
					case 1:
					System.out.println("enter account number");
					int num=sc.nextInt();
					System.out.println("Enter account holdername:");
					String name=sc.next();
					System.out.println("Enter account type:");
					String type=sc.next();
					System.out.println("Enter Account Blance");
					double balance=sc.nextDouble();
					a1=new Account(num,type,balance,name);
					System.out.println("Account has been created succesfully");
					break;
					case 2:
					System.out.println("Enter amount to withdraw:");
					amount=sc.nextDouble();
					a1.withDraw(amount);
					break;
					case 3:
					System.out.println("Enter amount to deposit:");
					amount=sc.nextDouble();
					a1.Deposit(amount);
					break;
					case 4:
					a1.addInterest();
					break;
					case 5:
					a1.show();
					break;
					case 6:
					double bal=a1.getBalance();
					System.out.println("Account balance:"+bal);
					break;
					case 7:
					System.exit(0);
					break;
				}
			}while(choice!=7);
		}
	}