/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author viet2
 */
public class DAOProduct extends DBContext{
    
    public ArrayList<Product> getProductBySQL(String sql){
        
         ArrayList<Product> products = new ArrayList<>();
        
         try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
            
            return products;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
