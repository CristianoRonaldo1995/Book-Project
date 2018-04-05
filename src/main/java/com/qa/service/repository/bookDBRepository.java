package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.book;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)

public class bookDBRepository implements bookRepository {
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllBook() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT a FROM book a");
		Collection<book> books = (Collection<book>) query.getResultList(); 
		return util.getJSONForObject(books);
	}
	
	
	@Override
	@Transactional(REQUIRED)
	public String createBook(String books) {
		// TODO Auto-generated method stub
		book abook= util.getObjectForJSON(books, book.class);
		manager.persist(abook);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateBook(Long id, String booksToUpdate) {
		// TODO Auto-generated method stub
		book updatedBook = util.getObjectForJSON(booksToUpdate, book.class);
		book bookFromDB = findBook(id);
		if (booksToUpdate != null) {
			bookFromDB = updatedBook;
			manager.merge(bookFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteBook(Long id) {
		// TODO Auto-generated method stub
		book bookInDB = findBook(id);
		if (bookInDB != null) {
			manager.remove(bookInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private book findBook(Long id) {
		return manager.find(book.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
