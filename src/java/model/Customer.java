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

/**
 *
 * @author Kenan
 */
public class Customer {

    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String allCustomers() throws ClassNotFoundException {
        StringBuilder all_customers = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
            Statement st = conn.createStatement();
            st.executeQuery("select customer_id, first_name, last_name, username, email from customers");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                all_customers.append(rs.getString("customer_id"));
                all_customers.append(" - ");
                all_customers.append(rs.getString("first_name"));
                all_customers.append(" - ");
                all_customers.append(rs.getString("last_name"));
                all_customers.append(" - ");
                all_customers.append(rs.getString("username"));
                all_customers.append(" - ");
                all_customers.append(rs.getString("email"));
                all_customers.append("\n");
            }
        } catch (SQLException ex) {
            all_customers.append(ex.getMessage());
        }
        return all_customers.toString();
    }

    public void insertCustomer() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
            if (first_name != null && !(first_name.isEmpty()) && last_name != null && !(last_name.isEmpty()) && username != null && !(username.isEmpty()) && email != null && !(email.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("insert into customers (first_name, last_name, username, email) values ('" + first_name + "','" + last_name + "','" + username + "','" + email + "')");
            }
        }catch(SQLException ex){
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }
    
        public void deleteCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_store", "root", "");) {
//            if (id != null) {
                Statement st = conn.createStatement();
                st.execute("delete from customers where customer_id = '" + id + "'");
//            }
        }
    }
    

}
