package by.epam.tr.lesson14.controller;

import by.epam.tr.lesson14.controller.command.Command;
import by.epam.tr.lesson14.util.Util;

public final class Controller {
	private static final Controller instance = new Controller();
	private final CommandProvider provider = new CommandProvider();
	
	private Controller() {		
	}
	
	public static Controller getInstance(){
		return instance;
	}
	
	public String executeTask(String request) {
		String commandName;
		Command executionCommand;
		
		commandName = Util.parseCommand(request);
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;
	}
}
