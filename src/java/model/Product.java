/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenan
 */
public class Product {

    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String allProducts() throws ClassNotFoundException {
        StringBuilder all_products = new StringBuilder();
//List<Product> productsList = new ArrayList<Product>();
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
            Statement st = conn.createStatement();
//            st.executeQuery("select * from products");
            st.executeQuery("select product_id, name, price from products");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                all_products.append(rs.getString("product_id"));
                all_products.append("  ");
                all_products.append(rs.getString("name"));
                all_products.append(" , ");
                all_products.append(rs.getString("price"));
                all_products.append("\n");
            }
        } catch (SQLException ex) {
            all_products.append(ex.getMessage());
        }
        return all_products.toString();
    }

    public void insertProduct() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
            if (name != null && !(name.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("insert into products (name, price) values ('" + name + "','" + price + "')");
            }
        }
    }
    
//        public void deleteProduct() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
//            if (name != null && !(name.isEmpty())) {
//                Statement st = conn.createStatement();
//                st.execute("insert into products (name, price) values ('" + name + "','" + price + "')");
//            }
//        }
//    }
    
}
