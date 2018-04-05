package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.service.repository.bookRepository;

public class bookServiceImpl implements bookService{
	
	private static final Logger LOGGER = Logger.getLogger(bookService.class);
	
	@Inject
	private bookRepository repo;
	
	@Override
	public String getAllBook() {
		// TODO Auto-generated method stub
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllBook();
	}

	@Override
	public String createBook(String account) {
		return repo.createBook(account);
	}

	@Override
	public String updateBook(Long id, String account) {
		return repo.updateBook(id, account);
	}

	@Override
	public String deleteBook(Long id) {
		return repo.deleteBook(id);

	}

	public void setRepo(bookRepository repo) {
		this.repo = repo;
	}
	

}
