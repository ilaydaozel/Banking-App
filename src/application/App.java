package application;

import java.util.Scanner;

import helpers.HelperIO;
import menu.BankMenu;
import menu.ClientMenu;
import menu.MainMenu;
import user.Bank;
import user.Client;
import helpers.*;

public class App {
    private static Bank bank= Bank.getInstance();

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu(bank);
        mainMenu.performMainMenu();
    }
}
