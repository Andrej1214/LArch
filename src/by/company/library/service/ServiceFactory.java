package by.company.library.service;


import by.company.library.service.impl.BookServiceImpl;
import by.company.library.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UpdateLibraryService updateLiraryService = new BookServiceImpl();
	private final UserService userService = new UserServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public UpdateLibraryService getLibraryService() {
		return updateLiraryService;
	}

}
