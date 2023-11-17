/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.statitics;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author viet2
 */
@WebServlet(name = "chartServlet", urlPatterns = {"/chartp"})
public class chartServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet chartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet chartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        // Lấy dữ liệu từ DAO hoặc cơ sở dữ liệu
        List<Product> products = dao.getProductsBySoldQuantity();

        // Tạo chuỗi JSON chứa dữ liệu biểu đồ
        String chartData = generateChartData(products);

        // Ghi chuỗi JSON vào response
        out.println(chartData);
    }

    private String generateChartData(List<Product> products) {
        // Logic để tạo chuỗi JSON dựa trên dữ liệu sản phẩm
        // Ví dụ:
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"labels\": [");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append("\"").append(product.getName()).append("\"");
            if (i < products.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("], \"datasets\": [{");
        sb.append("\"label\": \"Sold Quantity\",");
        sb.append("\"data\": [");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append(product.getSoldQuantity());
            if (i < products.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("],");
        sb.append("\"backgroundColor\": \"rgba(235, 22, 22, .7)\"");
        sb.append("}]}");

        return sb.toString();
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
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
