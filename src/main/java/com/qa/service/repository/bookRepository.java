package com.qa.service.repository;

public interface bookRepository {
	
	String getAllBook();

	String createBook(String books);

	String updateBook(Long id, String booksToUpdate);

	String deleteBook(Long id);

}
