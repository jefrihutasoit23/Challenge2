package challenge2.model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menuItems;
    private Map<String, Integer> itemPrices;

    public Menu() {
        menuItems = new HashMap<>();
        itemPrices = new HashMap<>();
    }

    public void addItem(int id, String name, int price) {
        menuItems.put(id, name);
        itemPrices.put(name, price);
    }

    public Map<Integer, String> getMenuItems() {
        return menuItems;
    }

    public int getPrice(String itemName) {
        return itemPrices.getOrDefault(itemName, 0);
    }
    public Map<String, Integer> getItemPrices() {
        return itemPrices;
    }

}

