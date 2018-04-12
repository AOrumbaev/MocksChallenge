package Mocks;

import java.awt.*;
import java.util.List;

public class Restaurant {

    private MenuItemService menuItemService;
    private List<MenuItem> items;
    public MenuItemService getMenuItemService() {
        return menuItemService;
    }

    public void setMenuItemService(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public double getOrderPrice(){
        double totalPrice = 0.0;

        for(MenuItem item : items){
            totalPrice += menuItemService.getPrice(item) * item.getAmount();
        }
        return totalPrice;
    }

}
