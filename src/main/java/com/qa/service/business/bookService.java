package com.qa.service.business;

public interface bookService {
	
	String getAllBook();

	String createBook(String books);

	String updateBook(Long id, String booksToUpdate);

	String deleteBook(Long id);

}
