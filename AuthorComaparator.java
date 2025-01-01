package com.lms;

import java.util.Comparator;

public class AuthorComaparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.author.compareTo(o2.author);
	}

}
