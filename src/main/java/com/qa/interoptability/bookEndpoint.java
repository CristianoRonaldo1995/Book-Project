package com.qa.interoptability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.business.bookService;

@Path("/account")
public class bookEndpoint {

	@Inject
	private bookService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllBook();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.createBook(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return service.updateBook(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteBook(id);

	}

	public void setService(bookService service) {
		this.service = service;
	}
}
