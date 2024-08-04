package io.github.lorensfs;

import io.github.lorensfs.objects.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OctoberEatsUI extends JFrame {
    private JTabbedPane tabbedPane1;
    private JButton clientsButton;
    private JButton restaurantsButton;
    private JTextField emailFieldLogin;
    private JPasswordField passwordFieldLogin;
    private JButton logInButton;
    private JButton backHomeButton;
    private JTextField passwordFieldRegister;
    private JTextField emailFieldRegister;
    private JTextField addressFieldRegister;
    private JTextField nameFieldRegister;
    private JButton registerButton;
    private JList restaurantList;
    private JList menuList;
    private JButton searchButton;
    private JList orderList;
    private JButton makeOrderButton;
    private JButton checkOrdersButton;
    private JButton goBackButton;
    private JTextField searchFieldRestaurant;
    private JButton addItemButton;
    private JButton checkMenuOfRestaurantButton;
    private JList ordersFromUser;
    private JButton backToRestaurantsButton;
    private JList orderListRestaurant;
    private JList restaurantsList;
    private JButton changeOrderStateDToButton;
    private JButton fetchOrdersButton;
    private JButton changeOrderStateCanToButton;
    private JButton changeOrderStateCToButton;
    private JButton changeOrderStatePreToButton;
    private JButton backButtonRestaurantPannel;
    private Long userId;
    private Long restaurantId;
    private List<MenuItem> itemMenu = new ArrayList<>();
    private List<OrderItem> order = new ArrayList<>();
    RestApiRequest restApiRequest = new RestApiRequest();

    OctoberEatsUI() {
        setContentPane(tabbedPane1);
        setTitle("October Eats");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        tabbedPane1.setSelectedIndex(0); // Init at home

        // Section Home:
        clientsButton.addActionListener(e -> tabbedPane1.setSelectedIndex(1));

        restaurantsButton.addActionListener(e -> {
            tabbedPane1.setSelectedIndex(4);
            restaurantsList.setListData(restApiRequest.listRestaurants().toArray());
        });

        // Section Sign up/in:
        backHomeButton.addActionListener(e -> {
            tabbedPane1.setSelectedIndex(0);
            setUserId(null);
        });

        logInButton.addActionListener(e -> {
            if (restApiRequest.login(emailFieldLogin.getText(), passwordFieldLogin.getText())) {
                setUserId(restApiRequest.getUserId(emailFieldLogin.getText(), passwordFieldLogin.getText()));
                // Clear fields
                emailFieldLogin.setText("");
                passwordFieldLogin.setText("");
                //Change tab to restaurant search
                tabbedPane1.setSelectedIndex(2);
            } else {
                JOptionPane.showMessageDialog(null, "Password or Email Incorrect");
            }
        });

        registerButton.addActionListener(e -> {
            if (restApiRequest.register(new User(nameFieldRegister.getText(), addressFieldRegister.getText(),
                    emailFieldRegister.getText(), passwordFieldRegister.getText()))) {
                JOptionPane.showMessageDialog(null, "Registration done; proceed to log in");
                // Clear fields
                nameFieldRegister.setText("");
                addressFieldRegister.setText("");
                emailFieldRegister.setText("");
                passwordFieldRegister.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Email already in use");
            }
        });

        // Section RestaurantSearch:
        searchButton.addActionListener(e -> {
            menuList.clearSelection();
            restaurantList.clearSelection();
            itemMenu.clear();
            order.clear();
            orderList.setListData(itemMenu.toArray());
            menuList.setListData(itemMenu.toArray());
            restaurantList.setListData((restApiRequest.searchRestaurants(searchFieldRestaurant.getText()).toArray()));
        });


        checkMenuOfRestaurantButton.addActionListener(e -> {
            Restaurant restaurant = (Restaurant) restaurantList.getSelectedValue();
            setRestaurantId(restaurant.getRestaurantId());
            menuList.setListData(restApiRequest.getRestaurantMenu(getRestaurantId()).toArray());
        });

        addItemButton.addActionListener(e -> {
            itemMenu.add((MenuItem) menuList.getSelectedValue());
            orderList.setListData(itemMenu.toArray());
            order.add(new OrderItem(new MenuItem(((MenuItem) menuList.getSelectedValue()).getItemId())));
        });

        makeOrderButton.addActionListener(e -> {
            if(!order.isEmpty()) {
                restApiRequest.placeOrder(order, getUserId(), getRestaurantId());
                JOptionPane.showMessageDialog(null,"Order has been sent to the restaurant");
            }else{
                JOptionPane.showMessageDialog(null,"Select items first");
            }
            menuList.clearSelection();
            restaurantList.clearSelection();
            itemMenu.clear();
            order.clear();
            orderList.setListData(itemMenu.toArray());
            menuList.setListData(itemMenu.toArray());
        });

        checkOrdersButton.addActionListener(e -> {
            menuList.clearSelection();
            restaurantList.clearSelection();
            itemMenu.clear();
            order.clear();
            orderList.setListData(itemMenu.toArray());
            menuList.setListData(itemMenu.toArray());
            tabbedPane1.setSelectedIndex(3);
            ordersFromUser.setListData(restApiRequest.getOrdersById(getUserId()).toArray());
        });

        goBackButton.addActionListener(e -> {
            tabbedPane1.setSelectedIndex(1);
            menuList.clearSelection();
            restaurantList.clearSelection();
            itemMenu.clear();
            order.clear();
            orderList.setListData(itemMenu.toArray());
            menuList.setListData(itemMenu.toArray());
            setRestaurantId(null);
            setUserId(null);
        });

        // Section Orders:
        backToRestaurantsButton.addActionListener(e -> tabbedPane1.setSelectedIndex(2));

        // Section Restaurant Manager:
        backButtonRestaurantPannel.addActionListener(e -> {
            tabbedPane1.setSelectedIndex(0);
            setRestaurantId(null);
        });

        fetchOrdersButton.addActionListener(e -> {
            Restaurant restaurant = (Restaurant) restaurantsList.getSelectedValue();
            orderListRestaurant.setListData(restApiRequest.getOrdersOfRestaurant(restaurant.getRestaurantId()).toArray());
        });

        changeOrderStateCanToButton.addActionListener(e -> {
            OrderModel order = (OrderModel) orderListRestaurant.getSelectedValue();
            Restaurant restaurant = (Restaurant) restaurantsList.getSelectedValue();
            restApiRequest.rejectOrder(order.getOrderId());
            orderListRestaurant.setListData(restApiRequest.getOrdersOfRestaurant(restaurant.getRestaurantId()).toArray());
        });

        changeOrderStateCToButton.addActionListener(e -> {
            OrderModel order = (OrderModel) orderListRestaurant.getSelectedValue();
            Restaurant restaurant = (Restaurant) restaurantsList.getSelectedValue();
            restApiRequest.acceptOrder(order.getOrderId());
            orderListRestaurant.setListData(restApiRequest.getOrdersOfRestaurant(restaurant.getRestaurantId()).toArray());
        });

        changeOrderStatePreToButton.addActionListener(e -> {
            OrderModel order = (OrderModel) orderListRestaurant.getSelectedValue();
            Restaurant restaurant = (Restaurant) restaurantsList.getSelectedValue();
            restApiRequest.preparingOrder(order.getOrderId());
            orderListRestaurant.setListData(restApiRequest.getOrdersOfRestaurant(restaurant.getRestaurantId()).toArray());
        });

        changeOrderStateDToButton.addActionListener(e -> {
            OrderModel order = (OrderModel) orderListRestaurant.getSelectedValue();
            Restaurant restaurant = (Restaurant) restaurantsList.getSelectedValue();
            restApiRequest.deliveredOrder(order.getOrderId());
            orderListRestaurant.setListData(restApiRequest.getOrdersOfRestaurant(restaurant.getRestaurantId()).toArray());
        });
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<MenuItem> getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(List<MenuItem> itemMenu) {
        this.itemMenu = itemMenu;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItem> order) {
        this.order = order;
    }
}
