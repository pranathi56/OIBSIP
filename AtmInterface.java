package test;

import java.util.*;
class BankAccount{
	String name;
	String username;
	String password;
	String accountnumber;
	float balance=100000f;
	int transactions=0;
	String transactionHistory="";
	 public void register() {
		 Scanner scn=new Scanner(System.in);
		 System.out.println("Enter name:");
		 this.name=scn.nextLine();
		 System.out.println("Enter username:");
		 this.username=scn.nextLine();
		 System.out.println("Enter password:");
		 this.password=scn.nextLine();
		 System.out.println("Enter account number:");
		 this.accountnumber=scn.nextLine();
		 System.out.println("Your details are registered.Now you can try to login.");
		 
		 
		 
	 }
	 public boolean login() {
		 boolean islogin=false;
		 Scanner sc=new Scanner(System.in);
		 while(!islogin) {
			 System.out.println("Enter username:");
			 String Username=sc.nextLine();
			 if(Username.equals(username)) {
				 while(!islogin) {
					 System.out.println("Enter password:");
					 String Password=sc.nextLine();
					 if(Password.equals(password)) {
						 System.out.println("Login was successful");
						 islogin=true;
					 }
					 else {
						 System.out.println("The password is not correct");
						 
					 }
				 }
			 }
			 else {
				 System.out.println("Username is not available");
			 }
		 }
		 return islogin;
		 
	 }
	 public void withdraw() {
		 System.out.println("Enter amount you want to withdraw:");
		 Scanner sc=new Scanner(System.in);
		 float amount=sc.nextFloat();
		 try {
			 if(balance>=amount) {
				 transactions++;
				 balance-=amount;
				 System.out.println("Withdrawl of money was successful");
				 String str="\n"+"Rs."+amount+" was withdrawed";
				 transactionHistory=transactionHistory.concat(str);
			 }
			 else {
				 System.out.println("No sufficient balance available");
			 }
		 }
		 catch(Exception e) {
	 }
}
	 public void deposit() {
		 System.out.println("Enter deposit amount:");
		 Scanner sc=new Scanner(System.in);
		 float amount=sc.nextFloat();
		 try {
			 if(amount<=100000f) {
				 transactions++;
				 balance+=amount;
				 System.out.println("Amount is deposited");
				 String str="\n"+"Rs."+amount+" was deposited";
				 transactionHistory=transactionHistory.concat(str);
			 }
			 else {
				 System.out.println("Sorry.The amount cannot be deposited");
			 }
		 }
		 catch(Exception e) {
			 
		 }
		 
	 }
	 public void transfer() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter name of the receiver:");
		 String receiver=sc.nextLine();
		 System.out.println("Enter transfer amount:");
		 float amount=sc.nextFloat();
		 try {
			 if(balance>=amount) {
				 if(amount<=50000f) {
					 transactions++;
					 balance-=amount;
					 System.out.println("Amount transferred to"+receiver);
					 String str="\n"+"Rs."+amount+" transferred to "+receiver+"\n";
					 transactionHistory=transactionHistory.concat(str);
				 }
				 else {
					 System.out.println("Sorry....Try again");
					 
				 }
			 }
			 else {
				 System.out.println("There is no sufficient balance");
			 }
		 }
		 catch(Exception e) {
			 
		 }
	 }
	 public void checkbalance() {
		 System.out.println("Rs."+balance);
	 }
	 public void transHistory() {
		 if(transactions==0) {
			 System.out.println("No transactions are made");
		 }
		 else {
			 System.out.println("\n"+transactionHistory+"\n");
		 }
	 }
}
public class AtmInterface{
	public static int input(int limit) {
		int i=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				i=sc.nextInt();
				flag=true;
				if(flag&&i>limit||i<1) {
					System.out.println("Choose a number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter a value");
				flag=false;
			}
		}
		return i;
	}
	public static void main(String args[]) {
		System.out.println("Welcome to ATM");
		System.out.println("1.Register \n2.Exit");
		System.out.println("Enter your choice:");
		int choice=input(2);
		if(choice==1) {
			BankAccount b=new BankAccount();
			b.register();
			while(true) {
				System.out.println("1.Login \n2.Exit");
				System.out.println("Enter your choice:");
				int ch=input(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("Welcome "+b.name);
						boolean isfinished=false;
						while(!isfinished) {
							System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.CheckBalance \n5.TransactionHistory \n6.Exit");
							System.out.println("Enter your choice:");
							int c=input(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkbalance();
								break;
							case 5:
								b.transHistory();
								break;
							case 6:
								isfinished=true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
			
		}
	}
}
