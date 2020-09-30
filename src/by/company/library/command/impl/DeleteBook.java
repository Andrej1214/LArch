package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class DeleteBook implements Command {
	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
		int id=Integer.valueOf(mas[1]);
		String name = mas[2];
		String author = mas[3];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UpdateLibraryService bookservice = serviceFactory.getLibraryService();

	
			Book book = new Book(id, name, author);
			boolean res = bookservice.deleteBook(book);
			if (res) {
				response = "The book was deleted";
			} else {
				response = "The book wasn't deleted";
			}
		} catch (ServiceException |ArrayIndexOutOfBoundsException e) {
			response = "Error duiring procedure.";
		}

		return response;
	}

	
	
}
