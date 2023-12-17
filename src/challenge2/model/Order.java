package challenge2.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> items;

    public Order() {
        items = new LinkedHashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public int getTotalCost(Menu menu) {
        int total = 0;
        for (String itemName : items.keySet()) {
            total += menu.getPrice(itemName) * items.get(itemName);
        }
        return total;
    }

    public void clearOrder() {
        items.clear();
    }
}

