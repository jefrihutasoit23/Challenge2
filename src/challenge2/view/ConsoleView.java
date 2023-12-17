package challenge2.view;

import java.util.Map;

public class ConsoleView {
    public static void displayMenu(Map<Integer, String> menuItems, Map<String, Integer> itemPrices) {
        System.out.println("------------------------");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("------------------------");
        System.out.println("Silahkan pilih makanan:");

        for (int key : menuItems.keySet()) {
            System.out.printf("%d. %-20s | %,12d%n", key, menuItems.get(key), itemPrices.get(menuItems.get(key)));
        }
    }

    public static void displayOrders(Map<String, Integer> orders) {
        System.out.println("----- PESANAN ANDA -----");

        for (String orderedItem : orders.keySet()) {
            int qty = orders.get(orderedItem);
            System.out.printf("%-20s %3d%n", orderedItem, qty);
        }
    }

    public static void displayPaymentOption() {
        System.out.println("99. Pesan dan Bayar");
    }
    public static void displayQuitApp() {
        System.out.println("0. Keluar Aplikasi");
    }

    public static void displayBasicPrompt(){
        System.out.print("=> ");
    }

    public static void displayOrderPrompt(String selectedMenu, int price) {
        System.out.println("------------------------");
        System.out.println("Berapa Pesanan Anda");
        System.out.println("------------------------");
        System.out.println(selectedMenu + " | " + price);
        System.out.println("(input 0 untuk kembali)");
    }

    public static void displayQuantityPrompt() {
        System.out.print("qty => ");
    }

    public static void displayReceipt(Map<String, Integer> ordersHistory, Map<String, Integer> prices, int total) {
        System.out.println("------------------------");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("------------------------");
        System.out.println("Menu                  Qty     Subtotal");
        System.out.println("----------------------------------------");

        for (String orderedItem : ordersHistory.keySet()) {
            int qty = ordersHistory.get(orderedItem);
            int price = prices.get(orderedItem);
            int subtotal = qty * price;
            System.out.printf("%-20s   %2d   %,12d%n", orderedItem, qty, subtotal);
        }

        System.out.println("---------------------------------------+");
        System.out.printf("Total           \t\t\t %,12d%n", total);
    }


    public static void displayPaymentOptions() {
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        displayBasicPrompt();
    }

    public static void displayContinueOrderPrompt() {
        System.out.println("Apakah ingin lanjutkan pesanan?");
        System.out.println("1. Ya, lanjutkan pesanan saya");
        System.out.println("2. Tidak, hapus pesanan saya dan mulai dari awal");
        System.out.println("0. Keluar aplikasi");
    }

    public static void displayContinueOrderMessage() {
        System.out.println("Silahkan lanjutkan pesanan");
    }

    public static void displayStartOrderMessage() {
        System.out.println("Silahkan pesan kembali");
    }

    public static void displayOrderSummary(Map<String, Integer> ordersHistory, Map<String, Integer> prices, int total) {
        System.out.println("Struk pembayaran telah disimpan di 'receipt.txt'.");
        System.out.println("Terimakasih sudah memesan di BinarFud");
        System.out.println();
        System.out.println("Berikut pesanan anda");
        System.out.println("----------------------------------------");
        System.out.println("Menu                  Qty     Subtotal");
        System.out.println("----------------------------------------");
        for (String orderedItem : ordersHistory.keySet()) {
            int qty = ordersHistory.get(orderedItem);
            int price = prices.get(orderedItem);
            int subtotal = qty * price;
            System.out.printf("%-20s   %2d   %,12d%n", orderedItem, qty, subtotal);
        }
        System.out.println("---------------------------------------+");
        System.out.printf("Total           \t\t\t %,12d%n", total);
        System.out.println();
        System.out.println("Pembayaran menggunakan Binar Cash");
    }

    public static void getMessage(String message){
        System.out.println("-- ERROR --");
        System.out.println("|| " +message+ " ||");
    }
}
