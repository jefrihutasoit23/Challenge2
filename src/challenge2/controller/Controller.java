package challenge2.controller;

import challenge2.model.Menu;
import challenge2.model.Order;
import challenge2.model.Receipt;
import challenge2.util.CustomException;
import challenge2.view.ConsoleView;

import java.util.Map;
import java.util.Scanner;

public class Controller {
    private Menu menu;
    private Order order;
    private Map<Integer, String> menuItems;
    private Map<String, Integer> itemPrices;
    private boolean exit = false;

    public Controller(Menu menu, Order order) {
        this.menu = menu;
        this.order = order;
        this.menuItems = menu.getMenuItems();
        this.itemPrices = menu.getItemPrices();
    }

    public void startOrder() throws CustomException {
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            ConsoleView.displayMenu(menuItems, itemPrices);

            if (!order.getItems().isEmpty()) {
                ConsoleView.displayPaymentOption();
            }
            ConsoleView.displayQuitApp();
            if (!order.getItems().isEmpty()) {
                ConsoleView.displayOrders(order.getItems());
            }

            ConsoleView.displayBasicPrompt();

            try {
                int choice = scanner.nextInt();

                if (choice == 0) {
                    exit = true;
                } else if (choice == 99) {
                    confirmAndPay();
                } else if (menuItems.containsKey(choice)) {
                    String selectedMenu = menuItems.get(choice);
                    int price = itemPrices.get(selectedMenu);
                    ConsoleView.displayOrderPrompt(selectedMenu, price);
                    ConsoleView.displayQuantityPrompt();
                    int qty = scanner.nextInt();

                    if (qty > 0) {
                        addOrder(selectedMenu, qty);
                    } else if (qty < 0) {
                        throw new CustomException("Jumlah pesanan harus lebih dari 0.");
                    }
                } else {
                    throw new CustomException("Pilihan tidak valid, pilih menu yang tersedia.");
                }
            } catch (java.util.InputMismatchException e) {
                ConsoleView.getMessage("Tipe masukan hanya boleh angka");
                scanner.nextLine();
            } catch (CustomException e) {
                ConsoleView.getMessage(e.getMessage());
            }
        }

        scanner.close();
    }

    private void addOrder(String menuItem, int qty) {
        if (order.getItems().containsKey(menuItem)) {
            int currentQty = order.getItems().get(menuItem);
            order.getItems().put(menuItem, currentQty + qty);
        } else {
            order.getItems().put(menuItem, qty);
        }
    }

    private void confirmAndPay() throws CustomException {
        Scanner scanner = new Scanner(System.in);
        int total = order.getTotalCost(menu);
        ConsoleView.displayReceipt(order.getItems(), itemPrices, total);

        ConsoleView.displayPaymentOptions();
        try {
            int choice = scanner.nextInt();

            if (choice == 1) {
                Receipt.generateReceipt(order, menu, total);
                ConsoleView.displayOrderSummary(order.getItems(), itemPrices, total);
                order.clearOrder();
                exit = true;
            } else if (choice == 0) {
                exit = true;
            } else if (choice == 2) {
                ConsoleView.displayContinueOrderPrompt();
                ConsoleView.displayBasicPrompt();
                int anotherChoice = scanner.nextInt();
                if (anotherChoice == 2) {
                    order.clearOrder();
                    ConsoleView.displayStartOrderMessage();
                } else if (anotherChoice == 1) {
                    ConsoleView.displayContinueOrderMessage();
                } else if (anotherChoice == 0) {
                    exit = true;
                }
            } else {
                throw new CustomException("Pilihan tidak valid, pilih menu yang tersedia.");
            }
        } catch (java.util.InputMismatchException e) {
            ConsoleView.getMessage("Tipe masukan hanya boleh angka");
            scanner.nextLine();
        } catch (CustomException e) {
            ConsoleView.getMessage(e.getMessage());
        }
    }
}
