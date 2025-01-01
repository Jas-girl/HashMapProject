package com.lms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookOperation {
	Book book = new Book();
	User user = new User();
	ArrayList<Book> listBook = new ArrayList<Book>();
	ArrayList<User> listUser = new ArrayList<User>();
	ArrayList<Book> issueBook = new ArrayList<Book>();
	HashMap<Integer, ArrayList<Book>> issue = new HashMap<Integer, ArrayList<Book>>();
	Scanner sc = new Scanner(System.in);

	void addBook() {
	    listBook.add(new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
	    listBook.add(new Book(3, "The Lord of the Rings", "J.R.R. Tolkien"));
	    listBook.add(new Book(5, "To Kill a Mockingbird", "Harper Lee"));
	    listBook.add(new Book(2, "1984", "George Orwell"));
	    listBook.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
	    listBook.add(new Book(6, "The Great Gatsby", "F. Scott Fitzgerald"));
	    listBook.add(new Book(7, "Moby Dick", "Herman Melville"));
	    listBook.add(new Book(8, "War and Peace", "Leo Tolstoy"));
	    listBook.add(new Book(9, "The Catcher in the Rye", "J.D. Salinger"));
	    listBook.add(new Book(10, "The Hobbit", "J.R.R. Tolkien"));
	    listBook.add(new Book(11, "Brave New World", "Aldous Huxley"));
	    listBook.add(new Book(12, "Animal Farm", "George Orwell"));
	    listBook.add(new Book(13, "Little Women", "Louisa May Alcott"));
	    listBook.add(new Book(14, "The Alchemist", "Paulo Coelho"));
	    listBook.add(new Book(15, "Crime and Punishment", "Fyodor Dostoevsky"));
	    listBook.add(new Book(16, "The Chronicles of Narnia", "C.S. Lewis"));
	    listBook.add(new Book(17, "Jane Eyre", "Charlotte Brontë"));
	    listBook.add(new Book(18, "Wuthering Heights", "Emily Brontë"));
	    listBook.add(new Book(19, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle"));
	    listBook.add(new Book(20, "A Tale of Two Cities", "Charles Dickens"));
	}

    void searchBookById(int id) {
    	boolean found=false;
    	for (Book book : listBook) {
			if(book.id==id) {
				System.out.println("Book is found");
				found=true;
				break;
			}
		}
    	if(!found) {
    		System.out.println("Book's id "+ id+ " is not found");
    	}
    }
	void viewBook() {
		for (Book book : listBook) {
			System.out.println(book);
		}
	}
    void sortedByAuthor() {
    	System.out.println("Books are sorted by author");
    	listBook.sort(new AuthorComaparator());
    	viewBook();
    }
    
	void registerUser(int userId, String userName) {
		listUser.add(new User(userId, userName));
	}

	void listUser() {
		for (User user : listUser) {
			System.out.println(user);
		}
	}

	void issuedBook(int noOfBooks) {

		for (int i = 0; i < noOfBooks; i++) {
			System.out.println("Enter the book id to be issued");
			int bid = sc.nextInt();
			boolean bf = false;
			for (Book book : listBook) {
				if (book.getId() == bid) {
					book.isIssued = true;
					issueBook.add(book);
					bf = true;
					break;
				}
			}

			if (bf == false) {
				System.out.println(bid + "book id is not found");
			}
		}
		System.out.println("Enter the userId that needs these books");
		int uid = sc.nextInt();
		boolean userFound = false;
		for (User u : listUser) {
			if (u.getUserId() == uid) {
				userFound = true;
				break;
			}
		}
		if (userFound == true) {
			System.out.println("mapping with user and books that are issued");
			issue.put(uid, issueBook);
			System.out.println("Userid:" + issue);
		} else {
			System.out.println("user has to register first");
		}

	}

	void returnBook(int userid, int bookid) {
		
		if (issue.isEmpty()) {
			System.out.println("First issue the book");
		}
		
		Book returnBook = new Book();
		for (Book book : listBook) {
			if (book.getId() == bookid) {
				returnBook = book;
				break;
			}
		}
		if (issue.containsKey(userid)) {
			for (Entry<Integer, ArrayList<Book>> books : issue.entrySet()) {
				if (books.getValue().contains(returnBook)) {
					books.getValue().remove(returnBook);
					System.out.println("Book is returned");
				}
			}
		} else {
			System.out.println("user is not issued that books");
		}

	}

	void viewIssueBook() {
		if (issueBook.isEmpty()) {
			return;
		}
		if (issue.isEmpty()) {
			System.out.println("No user has issued the books");
		} else {
			System.out.println(issue);
		}

	}
    void count() {
    	if(!issue.containsKey(null)) {
    		if(!issueBook.isEmpty()) {
        		System.out.println("Count no of books are issued by the user");
        		System.out.println(issueBook.size());
        	}
    	}
    	
    }
	void ascendingOrder() {
        if(!issue.isEmpty()) {
        	for (Entry<Integer, ArrayList<Book>> book : issue.entrySet()) {
    			System.out.println("User's id:");
    			System.out.println(book.getKey());
    		}
    		if (!issue.containsKey(null)) {
    			System.out.println("list of books in acending order that are issued");
    			issueBook.sort(new NameComparator());
    			System.out.println(issueBook);
    		}
        }
		
	}
}
