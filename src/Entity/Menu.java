package Entity;

import Behavior.MenuInterface;
import Utils.MenuMessages;

public class Menu implements MenuInterface {
    @Override
    public void displayMenu() {
        System.out.println(MenuMessages.MAIN_MENU_MESSAGE);

    }

    @Override
    public void exit() {

    }
}
