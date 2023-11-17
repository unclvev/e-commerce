/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import controller.*;
import dao.DAO;
import dao.DAOCategory;
import dao.DAOProduct;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;
import model.Category;

/**
 *
 * @author viet2
 */
@WebServlet(name = "CatgoryControl", urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<Product> list= dao.getAllProducts();
        List<Category> listc = dao.getAllCategory();
        
        String go = request.getParameter("go");
        if("category-checkbox".equals(go)){
      
            if(request.getParameter("0") == null){
                String sql = "select * from products where cateID = -1";
                for(Category category : listc){
                    String selected = request.getParameter(Integer.toString(category.getCid()));
                    if(selected != null){
                        sql = sql + " or cateID = " + category.getCid();
                        category.setChecked(true);
                    }
                }
                System.out.println(sql);
            
                list = new DAOProduct().getProductBySQL(sql);
            }
            
            
            
        }
        
        response.setContentType("text/html;charset=UTF-8");

        
        
        
        Cookie[] arr=request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o:arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                }
            }
        }
        Cart cart=new Cart(txt, list);
        List<Item> listItem=cart.getItems();
        int n;
        if(listItem!=null){
            n=listItem.size();
        }else{
            n=0;
            }
        request.setAttribute("size", n);
        request.setAttribute("data", list);
        request.setAttribute("listC", listc);
        
        
        request.getRequestDispatcher("category.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
