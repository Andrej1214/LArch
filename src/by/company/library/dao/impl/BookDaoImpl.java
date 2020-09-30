package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.company.library.bean.Book;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;

public class BookDaoImpl implements BookDao {

	@Override
	public boolean addBook(Book book) throws DAOException {
		boolean res=false;
		String str ="id=" + "name="+ book.getName() + "autor=" + book.getAutor();
		FileWriter writer = null;
		try {
			writer = new FileWriter("Book.txt", true);
			writer.write(str + "\n");
			res=true;
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return res;
	}

	@Override
	public boolean deleteBook(Book book) throws DAOException {
		boolean res=false;
		String bk = "id=" + book.getId() + "name="+ book.getName() + ", author=" + book.getAutor();

		File sourceFile = new File("Book.txt");
		File outputFile = new File("Temp.txt");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(sourceFile));
			writer = new BufferedWriter(new FileWriter(outputFile));
			while ((line = reader.readLine()) != null) {
				if (!line.equals(bk)) {
					writer.write(line);
					writer.newLine();
				}
			}
			res=true;
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
				sourceFile.delete();
				} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				writer.close();
				outputFile.renameTo(sourceFile);
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
		return res;

	}

}
