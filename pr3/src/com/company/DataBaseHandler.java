package com.company;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseHandler extends Configs {
    Connection con = null;
    PreparedStatement pst = null;

    public void signUpUser(int id, String firstName, String lastName, String userName, String password, String location) {
        try {
            String query = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_ID + "," + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ","
                    + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + ")" +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, userName);
            pst.setString(5, password);
            pst.setString(6, location);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTER SUCCESSFULLY");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }


    public ResultSet getUser(String username, String password) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
            pst = con.prepareStatement(select);
            pst.setString(1, username);
            pst.setString(2, password);
            resSet = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return resSet;
    }

    public ArrayList<String> getRecipes(String priemVvod, String productVvod) throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT * FROM recipe WHERE priem = '" + priemVvod + "' AND (product1 = '" + productVvod + "' OR product2 = '" + productVvod + "' OR product3 = '" + productVvod + "' OR product4 = '" + productVvod + "')";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> recipes = new ArrayList<>();
        while (resSet.next()) {
            recipes.add(resSet.getString("nameRecipe"));
           }
return recipes;

    }
    public ArrayList<String> getAllRecipes() throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT * FROM recipe";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> recipes = new ArrayList<>();
        while (resSet.next()) {
            recipes.add(resSet.getString("nameRecipe"));
        }
        return recipes;

    }
    public ArrayList<String> getAllRecipe(String name, String priem, String product) throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT * FROM recipe WHERE nameRecipe = '" + name + "' AND priem = '" + priem + "' AND (product1 = '" + product + "' OR product2 = '" + product + "' OR product3 = '" + product + "' OR product4 = '" + product + "')";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> recipes = new ArrayList<>();
        while (resSet.next()) {
            recipes.add(resSet.getString("nameRecipe"));
            recipes.add(resSet.getString("product1"));
            recipes.add(resSet.getString("kol_vo1"));
            recipes.add(resSet.getString("product2"));
            recipes.add(resSet.getString("kol_vo2"));
            recipes.add(resSet.getString("product3"));
            recipes.add(resSet.getString("kol_vo3"));
            recipes.add(resSet.getString("product4"));
            recipes.add(resSet.getString("kol_vo4"));
            recipes.add(resSet.getString("step1"));
            recipes.add(resSet.getString("step2"));
            recipes.add(resSet.getString("step3"));
            recipes.add(resSet.getString("step4"));
        }
        return recipes;


    }
    public void addProduct(int id, String product){
        try {
            String query = "INSERT INTO products ( id ,  products) VALUES (?, ?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, product);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Покупка успешно завершена");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public ArrayList<String> getProduct() throws SQLException, ClassNotFoundException{
        ResultSet resSet;
        String query = "SELECT * FROM products";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> products = new ArrayList<>();
        while (resSet.next()) {
            products.add(resSet.getString("products"));
        }
        return products;
    }
    public ArrayList<String> seeMissingProducts() throws SQLException, ClassNotFoundException{
        ResultSet resSet;
        String query = "SELECT * FROM products";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> products = new ArrayList<>();
        while (resSet.next()) {
            products.add(resSet.getString("products"));
        }
        return products;
    }


}






