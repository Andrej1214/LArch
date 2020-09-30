package by.company.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.company.library.command.Command;
import by.company.library.command.impl.AddNewBook;
import by.company.library.command.impl.Logination;
import by.company.library.command.impl.Registration;
import by.company.library.command.impl.DeleteBook;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
		commands.put("DELETE_BOOK", new DeleteBook());
	}

	Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}

}
