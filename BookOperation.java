package com.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookOperation {
	Book book=new Book();
	User user=new User();
	ArrayList<Book> listBook=new ArrayList<Book>();
	ArrayList<User> listUser=new ArrayList<User>();
	HashMap<Integer,ArrayList<Book>> issue=new HashMap<Integer,ArrayList<Book>>();
	Scanner sc=new Scanner(System.in);
void addBook() {
	 listBook.add(new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
     listBook.add(new Book(2, "The Lord of the Rings", "J.R.R. Tolkien"));
     listBook.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
     listBook.add(new Book(4, "1984", "George Orwell"));
     listBook.add(new Book(5, "Pride and Prejudice", "Jane Austen"));
}
void viewBook() {
	for (Book book : listBook) {
		System.out.println(book);
	}
}
void registerUser(int userId,String userName) {
	listUser.add(new User(userId, userName));
}
void listUser() {
	for (User user : listUser) {
		System.out.println(user);
	}
}
void issuedBook(int noOfBooks) {
	ArrayList<Book> issueBook=new ArrayList<Book>();
	for (int i = 0; i < noOfBooks; i++) {
		System.out.println("Enter the book id");
		int bid=sc.nextInt();
		boolean bf=false;
		for (Book book : listBook) {
			if(book.getId()==bid) {
				book.isIssued=true;
				issueBook.add(book);
				bf=true;
				break;
			}
		}
		
	  if(bf==false) {
		  System.out.println(bid+ "book id is not found");
	  }
	}
	System.out.println("Enter the userId");
	int uid=sc.nextInt();
	boolean userFound=false;
	for (User u : listUser) {
		if(u.getUserId()==uid) {
			userFound=true;
			break;
		}
	}
	if(userFound==true) {
		issue.put(uid, issueBook);
		System.out.println(issue);
	}
	else {
		System.out.println("user has to register first");
	}
	
}
void returnBook(int userId,int bookid) {
	if(issue.isEmpty()) {
		System.out.println("First issue the book");
	}
	Book returnBook=new Book();
	for (Book book : listBook) {
		if(book.getId()==bookid) {
			returnBook=book;
			break;
		}
	}
	if(issue.containsKey(userId)) {
		for (Entry<Integer, ArrayList<Book>> books : issue.entrySet()) {
			if(books.getValue().contains(returnBook)) {
				books.getValue().remove(returnBook);
				System.out.println("Book is returned");
			}
		}
	}
	
}
void viewIssueBook() {
	if(issue.isEmpty()) {
		System.out.println("No user has issued the books");
	}
	else {
		System.out.println(issue);
	}
	
}

}
