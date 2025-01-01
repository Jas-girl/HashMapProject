package com.lms;

import java.util.Comparator;

public class NameComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}
