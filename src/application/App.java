package application;
import menu.MainMenu;
import interfaces.IMenu;
import user.Bank;


public class App {
    private static Bank bank= Bank.getInstance();

	public static void main(String[] args) {
		IMenu mainMenu = new MainMenu(bank);
        mainMenu.executeMenu();
    }
}
