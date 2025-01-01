package com.lms;
import java.util.Scanner;

public class Library {
public static void main(String[] args) {
	BookOperation Oper=new BookOperation();
	Scanner sc=new Scanner(System.in);
	Oper.addBook();
	while(true) {
		System.out.println("1->Search the book");
		System.out.println("2->View all books");
		System.out.println("3->Sorted by author");
		System.out.println("4->User to register");
		System.out.println("5->Issue the books");
		System.out.println("6->Return process to return the book");
		System.out.println("7->View issue books");
		System.out.println("8->Count the no. of books to be issued");
		System.out.println("9->Ascending Order");
		System.out.println("10->Exit the process");
		System.out.println("Enter the choice");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:System.out.println("Enter the book id to search the book");
		Oper.searchBookById(sc.nextInt());break;
		case 2:Oper.viewBook();break;
		case 3:Oper.sortedByAuthor();break;
		case 4:System.out.println("Enter the user id");
		int userId=sc.nextInt();
		System.out.println("Enter the user name");
		String userName=sc.next();
		Oper.registerUser(userId, userName);
		Oper.listUser();break;
		case 5:System.out.println("enter the number of books to be issued");
		int issueBooks=sc.nextInt();
		Oper.issuedBook(issueBooks);break;
		case 6:System.out.println("Enter the user id to return the book");
		int rUserId=sc.nextInt();
		System.out.println("Enter the book id to return the book");
		int rBookId=sc.nextInt();
		Oper.returnBook(rUserId, rBookId);break;
		case 7:Oper.viewIssueBook();break;
		case 8:	Oper.count();break;
		case 9:Oper.ascendingOrder();break;
		case 10:System.out.println("Exit");
		}
	}

}
}
