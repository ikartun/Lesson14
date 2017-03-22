package by.epam.tr.lesson14.controller.command.impl;

import by.epam.tr.lesson14.controller.command.Command;

public class WrongRequest implements Command{
	@Override
	public String execute(String request) {
		String response = "Wrong request!";
		
		return response;
	}
}
