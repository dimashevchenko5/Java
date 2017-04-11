package com.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created
 * by Дима on 28.03.2017.
 */
public class Main {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException {
    DBProcessor db = new DBProcessor();
    Connection conn = db.getConnection(url,username,password);
    String query = "select * from business.products";
    Statement statement = conn.createStatement();
    ResultSet resSet =  statement.executeQuery(query);

    while (resSet.next()){
        int id;
        String name;
        double price;
        int shopid;
       id =  resSet.getInt("product_id");
       name =  resSet.getString("product_name");
       price =  resSet.getDouble("price");
       shopid =  resSet.getInt("shop_id");
       Product product = new Product(id , name , price , shopid);
       System.out.println(product);
    }

    statement.close();
    conn.close();
    }
}

