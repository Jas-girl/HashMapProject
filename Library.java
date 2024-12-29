package com.lms;
import java.util.Scanner;

public class Library {
public static void main(String[] args) {
	BookOperation Oper=new BookOperation();
	Scanner sc=new Scanner(System.in);
	
		Oper.addBook();
	Oper.viewBook();
	
	System.out.println("Enter the user id");
	int userId=sc.nextInt();
	System.out.println("Enter the user name");
	String userName=sc.next();
	Oper.registerUser(userId, userName);
	Oper.listUser();
	
	System.out.println("enter the books to be issued");
	int issueBooks=sc.nextInt();
	Oper.issuedBook(issueBooks);
	
	
	System.out.println("Enter the user id to return the book");
	int rUserId=sc.nextInt();
	System.out.println("Enter the book id to return the book");
	int rBookId=sc.nextInt();
	Oper.returnBook(rUserId, rBookId);
	
	Oper.viewIssueBook();

}
}
