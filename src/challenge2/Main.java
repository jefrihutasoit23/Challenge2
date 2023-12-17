package challenge2;

import challenge2.controller.Controller;
import challenge2.model.Menu;
import challenge2.model.Order;
import challenge2.util.CustomException;

public class Main {
    public static void main(String[] args) throws CustomException {
        Menu menu = new Menu();
        menu.addItem(1, "Nasi Goreng", 15000);
        menu.addItem(2, "Mie Goreng", 13000);
        menu.addItem(3, "Nasi + Ayam", 18000);
        menu.addItem(4, "Es Teh Manis", 15000);
        menu.addItem(5, "Es Jeruk", 15000);

        Order order = new Order();

        Controller controller = new Controller(menu, order);
        controller.startOrder();
    }
}
