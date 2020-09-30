package by.company.library.service;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.service.exception.ServiceException;

public interface UserService {
	boolean logination(String login, int password) throws ServiceException;
	boolean registration(User user) throws ServiceException;
	
}
