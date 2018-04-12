package Mocks;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RestaurantTester {

    Restaurant restaurant;
    MenuItemService menuItemService;


    public static void main(String[] args){
        RestaurantTester tester = new RestaurantTester();
        tester.setUp();
        System.out.println(tester.testOrder()?"pass":"fail");
    }

    public void setUp(){
        //Create a restaurant object which is to be tested
        restaurant = new Restaurant();

        //Create the mock object of stock service
        menuItemService = mock(MenuItemService.class);

        //set the foodService to the restaurant
        restaurant.setMenuItemService(menuItemService);
    }

    public boolean testOrder(){

        //Creates a list of foods to be added to the restaurant
        List<MenuItem> items = new ArrayList<MenuItem>();
        Food pizza = new Food("1","IntelPizza", 5);
        Food goulash = new Food("2","AmazonGoulash",10);
        Drinks coke = new Drinks("3","MicrosoftCoke",2);

        items.add(pizza);
        items.add(goulash);
        items.add(coke);

        //add foods to the restaurant
        restaurant.setItems(items);

        //mock the behavior of food and drinks to return the value of various foods
        when(menuItemService.getPrice(pizza)).thenReturn(100.00);
        when(menuItemService.getPrice(goulash)).thenReturn(75.00);
        when(menuItemService.getPrice(coke)).thenReturn(15.00);

        double totalPrice = restaurant.getOrderPrice();
        return totalPrice == 1280.0;
    }
}