package development;

import com.company.Configs;
import com.company.Const;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBHandler extends Configs {
    Connection con = null;
    PreparedStatement pst = null;

    public ArrayList<String> getAllRecipe(String name, int amount, String priem, String product) throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT nameRecipe, product1, (kol_vo1*"+ amount + "), product2, (kol_vo2*"+ amount + ") , product3, (kol_vo3*"+ amount + "), product4, (kol_vo4*"+ amount + "), step1, step2, step3, step4 FROM itproger.recipe WHERE nameRecipe = '" + name + "'AND priem = '" + priem + "' AND (product1 = '" + product + "' OR product2 = '" + product + "' OR product3 = '" + product + "' OR product4 = '" + product + "')";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
        pst = con.prepareStatement(query);
        resSet = pst.executeQuery();
        ArrayList<String> recipes = new ArrayList<>();
        while (resSet.next()) {
            recipes.add(resSet.getString("nameRecipe"));
            recipes.add(resSet.getString("product1"));
            recipes.add(resSet.getString("(kol_vo1*"+ amount + ")"));
            recipes.add(resSet.getString("product2"));
            recipes.add(resSet.getString("(kol_vo2*"+ amount + ")"));
            recipes.add(resSet.getString("product3"));
            recipes.add(resSet.getString("(kol_vo3*"+ amount + ")"));
            recipes.add(resSet.getString("product4"));
            recipes.add(resSet.getString("(kol_vo4*"+ amount + ")"));
            recipes.add(resSet.getString("step1"));
            recipes.add(resSet.getString("step2"));
            recipes.add(resSet.getString("step3"));
            recipes.add(resSet.getString("step4"));
        }
        return recipes;

    }
    public ArrayList<String> getAllRecipeWithoutAllergy(String allergy, String priem, String product) throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT * FROM recipe WHERE (product1 != '" + allergy + "' AND product2 != '" + allergy + "' AND product3 != '" + allergy + "' AND product4 != '" + allergy + "') AND  priem = '" + priem + "' AND (product1 = '" + product + "' OR product2 = '" + product + "' OR product3 = '" + product + "' OR product4 = '" + product + "')";
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
    public ArrayList<String> getAllRecipeWithPribors(String name, String priem, String product) throws SQLException, ClassNotFoundException {

        ResultSet resSet;
        String query = "SELECT * FROM itproger.recipe WHERE (pribor1 IN(SELECT pribor FROM itproger.pribors) AND pribor2 IN(SELECT pribor FROM itproger.pribors) ) AND nameRecipe ='" +name +"' AND priem='" + priem + "' AND (product1 = '" + product + "' OR product2 = '" + product + "' OR product3 = '" + product + "' OR product4 = '" + product + "')";
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
    public void signUpPribor(int id, String pribor) {
        try {
            String query = "INSERT INTO itproger.pribors (idpribors, pribor)" +
                    "VALUES(?, ?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itproger", "root", "vikaget11");
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, pribor);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ADDITION SUCCESSFULLY");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }


}
