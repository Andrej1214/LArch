package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;
import by.company.library.command.exception.CommandException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
		int id = Integer.valueOf(mas[1]);
		String name = mas[2];
		String surname = mas[3];
		String login = mas[4];
		int password = Integer.valueOf(mas[5]);
		int age = Integer.valueOf(mas[6]);

		User user = new User(id, name, surname, login, password, age);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();
		
		
			if(userservice.registration(user)) {
				response = "Registration was successfully completed.";
			}
			else
				response = "Registration was not completed.";
		} catch (ServiceException |ArrayIndexOutOfBoundsException e) {
			response = "Error duiring registration.";
		}
		
		return response;
	}

}
