package by.epam.tr.lesson14.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.controller.command.CommandName;
import by.epam.tr.lesson14.controller.command.impl.AddProduct;
import by.epam.tr.lesson14.controller.command.impl.AddRent;
import by.epam.tr.lesson14.controller.command.impl.CloseRent;
import by.epam.tr.lesson14.controller.command.impl.DeleteProduct;
import by.epam.tr.lesson14.controller.command.impl.FindProducts;
import by.epam.tr.lesson14.controller.command.impl.FindRents;
import by.epam.tr.lesson14.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() {
		repository.put(CommandName.ADD_PRODUCT, new AddProduct());
		repository.put(CommandName.DELETE_PRODUCT, new DeleteProduct());
		repository.put(CommandName.ADD_RENT, new AddRent());
		repository.put(CommandName.CLOSE_RENT, new CloseRent());
		repository.put(CommandName.FIND_PRODUCTS, new FindProducts());
		repository.put(CommandName.FIND_RENTS, new FindRents());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name) {
		CommandName commandName =null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}
		catch(IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
			Logger logger = Logger.getGlobal();
			logger.log(Level.SEVERE, command.execute(null), e);
		}
		
		return command;
	}
}
