package com.lms;

public class Book {
int id;
String name;
String author;
boolean isIssued;

public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(int id, String name, String author) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
	this.isIssued = false;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public boolean isIssued() {
	return isIssued;
}
public void setIssued(boolean isIssued) {
	this.isIssued = isIssued;
}
@Override
public String toString() {
	return "Book [Bookid=" + id + ", name=" + name + ", author=" + author + ", isIssued=" + isIssued + "]";
}

}
