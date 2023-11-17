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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author viet2
 */
public class DAOCategory extends DBContext{
    
    /*
    c_id INT PRIMARY KEY,
    c_name NVARCHAR(255),
    pid INT
    */
    
    public static void main(String[] args) {
        List<Category> list = new DAOCategory().getAllCategory();
        for(Category category : list){
            System.out.println(category);
        }
    }
    
    private static final String GET_ALL_CATEGORY = "SELECT * FROM dbo.Categories";
    
    public List<Category> getAllCategory(){
        ArrayList<Category> list = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_ALL_CATEGORY)){
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Category(rs.getInt("c_id"), rs.getString("c_name")));
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
}
