package challenge2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Receipt {
    public static void generateReceipt(Order order, Menu menu, int total) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt"))) {
            writer.write("------------------------");
            writer.newLine();
            writer.write("BinarFud");
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
            writer.newLine();
            writer.write("Terimakasih sudah memesan");
            writer.newLine();
            writer.write("di BinarFud");
            writer.newLine();
            writer.newLine();

            Map<String, Integer> ordersHistory = order.getItems();
            Map<String, Integer> prices = menu.getItemPrices();

            writer.write("Menu                  Qty     Subtotal");
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();

            for (String orderedItem : ordersHistory.keySet()) {
                int qty = ordersHistory.get(orderedItem);
                int price = prices.get(orderedItem);
                int subtotal = qty * price;
                writer.write(String.format("%-20s   %2d   %,12d", orderedItem, qty, subtotal));
                writer.newLine();
            }

            writer.write("---------------------------------------+");
            writer.newLine();
            writer.write(String.format("Total           \t\t\t %,12d%n", total));
            writer.newLine();
            writer.newLine();
            writer.write("Pembayaran : BinarCash");
            writer.newLine();
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
            writer.write("Simpan struk ini sebagai");
            writer.newLine();
            writer.write("bukti pembayaran");
            writer.newLine();
            writer.write("------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
