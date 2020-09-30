package by.company.library.dao.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;
import java.io.FileReader;

import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean registerUser(User user) throws DAOException {
		boolean respond;
		String str = "id=" + user.getId() + "name=" + user.getName() + ", surname=" + user.getSurname()
				+ ",login=" + user.getLogin() + ", password=" + user.getPassword() + ", age=" + user.getAge();
		FileWriter writer = null;

		try {
			writer = new FileWriter("User.txt", true);
			writer.write(str + "\n");
			respond=true;
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return respond;

	}

	@Override
	public boolean logination(String login, int password) throws DAOException {
		boolean respond=false;
		FileReader reader = null;
		Scanner sc = null;
		try {
			reader = new FileReader("User.txt");
			sc = new Scanner(reader);
			if (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains(login)) {
					String str_password=String.valueOf(password);
					if ((line.contains(str_password))) {
						respond = true;
					}
				} else
					respond = false;
			}
		} catch (Exception e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				reader.close();
				sc.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return respond;
	}
}
