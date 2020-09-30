package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class AddNewBook implements Command{
	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String author = mas[2];
			int id=Integer.valueOf(mas[3]);
			

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookservice = serviceFactory.getLibraryService();

		
		Book book = new Book(id, name, author);
		boolean res = bookservice.addNewBook(book);
			if (res) {
				response = "The book was added";
			} else {
				response = "The book wasn't added";
			}
		} catch (ServiceException |ArrayIndexOutOfBoundsException e) {
			response = "Error duiring add.";
		}

		return response;
	}	
}
