package by.epam.tr.lesson14.controller.command;


public interface Command {
	char paramDelimiter = ';';
	char paramValueDelimiter = ':';
	String paramPattern = "([^" + paramDelimiter + "]*)";
	String objectDelimiter = "//";
	String commandParam = "command";
	String productIdParam = "productId";
	String productNameParam = "productName";
	String productPrisePerDayParam = "productPrisePerDay";
	String productAmountParam = "productAmount";
	String rentIdParam = "rentId";
	String rentDateFromParam = "rentDateFrom";
	String rentDateToParam = "rentDateTo";
	
	String execute(String request);
}