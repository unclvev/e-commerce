/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Product;
import model.Account;
import model.Cart;
import model.Category;
import model.Item;
import model.Order;

/**
 *
 * @author viet2
 */
public class DAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Products";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Product getLast() {
        String sql = "SELECT TOP 1 * FROM dbo.Products\n"
                + "ORDER BY id DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (Exception e) {
        }
        System.out.println("3");
        return null;
    }

    public List<Product> get10new() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM dbo.Products\n"
                + "ORDER BY id DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getAllProductsByCateID(String id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE cateID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Product getAllProductsByID(String id) {

        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Category getAllCategoryByID(String id) {

        String sql = "SELECT * FROM dbo.Categories\n"
                + "WHERE c_id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Product> searchByName(String search) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE [name] LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> searchByColor(String color) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE [color] LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + color + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

//    public List<Product> searchByPrice(String minPrice, String maxPrice) {
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT id, name, image, price, title, description, cateID, quantity\n"
//                + "FROM Products\n"
//                + "WHERE price BETWEEN ? AND ?;";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, minPrice);
//            st.setString(2, maxPrice);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("image"),
//                        rs.getDouble("price"),
//                        rs.getString("title"),
//                        rs.getString("description"),
//                        rs.getDouble("cateID"),
//                        rs.getInt("quantity")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    public Account login(String user, String pass) {
        String sql = "SELECT * FROM dbo.Account\n"
                + "WHERE [user] = ? AND pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("1");
                System.out.println(rs.getInt(5));
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getDouble(6));

            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Account checkAccExit(String user) {
        String sql = "SELECT * FROM dbo.Account \n"
                + "WHERE [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getDouble(6));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void signup(String user, String pass) {
        String sql = "INSERT INTO dbo.Account VALUES\n"
                + "(?, ?,0,0,null)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Product> getAllProductsBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE sell_ID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String sql = "DELETE FROM dbo.Products\n"
                + "WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addProduct(String name, String image, String price, String title, String description, String category, int sid) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([name]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[title]\n"
                + "           ,[description]\n"
                + "           ,[cateID]\n"
                + "           ,[sell_ID]\n"
                + "           ,[quantity]\n"
                + "           ,[color])\n"
                + "     VALUES(\n"
                + "           ?,?,?,?,?,?,?,null,null)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setString(6, category);
            st.setInt(7, sid);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void editProducts(String name, String image, String price, String title, String description, String category, String pid) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[cateID] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setString(6, category);
            st.setString(7, pid);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Product getAllProductsById(int id) {

        String sql = "SELECT * FROM dbo.Products\n"
                + "WHERE id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void addOrder(Account a, Cart cart) {
        LocalDate curDate = LocalDate.now(); // Lấy ngày hiện tại
        String date = curDate.toString(); // Chuyển đổi ngày thành chuỗi

        try {
            // Thêm bản ghi vào bảng "order"
            String sql = "INSERT INTO [order] ([date], cid, totalmoney) VALUES (?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setInt(2, a.getId());
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();

            // Lấy ID của bản ghi vừa thêm vào bảng "order"
            String sql1 = "select top 1 id from [order] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();

            // Thêm các bản ghi vào bảng "orderline"
            if (rs.next()) {
                int oid = rs.getInt("id"); // Lấy ID của bản ghi vừa thêm
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into [orderline] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getPrice());
                    st2.executeUpdate();
                }
            }

            // Cập nhật số lượng sản phẩm trong bảng "product"
            String sql3 = "update product set quantity = quantity - ? where id = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity()); // Thiết lập giá trị cho tham số 1 (số lượng)
                st3.setInt(2, i.getProduct().getId()); // Thiết lập giá trị cho tham số 2 (ID sản phẩm)
                st3.executeUpdate(); // Thực thi câu lệnh UPDATE
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int changePass(String newPass, int id) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "SET [pass] = ?\n"
                + "WHERE [uID] = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPass);
            st.setInt(2, id);
            st.executeUpdate();
            return 1;
        } catch (SQLException e) {
        }
        return 0;
    }

    public List<Category> getCategoriesWithProductCount() {
        List<Category> categories = new ArrayList<>();

        try {
            String query = "SELECT c.c_id, c.c_name, COUNT(p.id) AS product_count "
                    + "FROM Categories c "
                    + "LEFT JOIN Products p ON c.c_id = p.cateID "
                    + "GROUP BY c.c_id, c.c_name";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int categoryId = resultSet.getInt("c_id");
                String categoryName = resultSet.getString("c_name");
                int productCount = resultSet.getInt("product_count");

                Category category = new Category(categoryId, categoryName, productCount);
                categories.add(category);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categories;
    }

    public double getTotalAmountForLastThreeDays() {
        String sql = "SELECT SUM(totalmoney) AS TotalAmount "
                + "FROM [dbo].[Order] "
                + "WHERE [date] >= DATEADD(DAY, -3, GETDATE())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public double getTotalAmountForLastOneMonth() {
        String sql = "SELECT SUM(totalmoney) AS TotalAmount\n"
                + "FROM [dbo].[Order]\n"
                + "WHERE [date] >= DATEADD(MONTH, -1, GETDATE())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public double getTotalAmountForLastOneWeek() {
        String sql = "SELECT SUM(totalmoney) AS TotalAmount\n"
                + "FROM [dbo].[Order]\n"
                + "WHERE [date] >= DATEADD(WEEK, -1, GETDATE())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public double getTotalAmountForLastOneYear() {
        String sql = "SELECT SUM(totalmoney) AS TotalAmount\n"
                + "FROM [dbo].[Order]\n"
                + "WHERE [date] >= DATEADD(YEAR, -1, GETDATE())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public List<Product> getProductsBySoldQuantity() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT P.id, P.name, COUNT(OL.pid) AS SoldQuantity "
                + "FROM Products P "
                + "JOIN OrderLine OL ON P.id = OL.pid "
                + "GROUP BY P.id, P.name "
                + "ORDER BY SoldQuantity DESC";

        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                int soldQuantity = resultSet.getInt("SoldQuantity");

                Product product = new Product();
                product.setId(productId);
                product.setName(productName);
                product.setSoldQuantity(soldQuantity);

                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.[Order]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getProductsByPriceAndBrand(double minPrice, double maxPrice, List<Integer> brandIds) {
        List<Product> productList = new ArrayList<>();

        // Tạo câu truy vấn SQL để lấy danh sách sản phẩm theo giá và thương hiệu
        String sql = "SELECT id, name, image, price, title, description, amount, quantity, soldQuantity FROM Products WHERE price >= ? AND (price <= ? OR ? = '')";
        if (!brandIds.isEmpty()) {
            sql += " AND brandId IN (" + String.join(",", Collections.nCopies(brandIds.size(), "?")) + ")";
        }

        // Tạo danh sách tham số cho câu truy vấn SQL
        List<Object> params = new ArrayList<>();
        params.add(minPrice);
        params.add(maxPrice);
        params.add("");

        // Thêm các tham số brandId vào danh sách tham số
        params.addAll(brandIds);

        // Thực hiện truy vấn và xử lý kết quả
        try ( Connection conn = connection;  PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Thiết lập các tham số vào câu truy vấn SQL
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            // Thực hiện truy vấn SQL và lấy kết quả
            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Đọc dữ liệu từ ResultSet và tạo đối tượng Product
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setImage(rs.getString("image"));
                    product.setPrice(rs.getDouble("price"));
                    product.setTitle(rs.getString("title"));
                    product.setDescription(rs.getString("description"));
                    product.setAmount(rs.getDouble("amount"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setSoldQuantity(rs.getInt("soldQuantity"));

                    // Thêm sản phẩm vào danh sách
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Trả về danh sách sản phẩm
        return productList;
    }

    public List<Product> getProductsByPrice(int from, int to) {
        String sql = "SELECT * FROM Products WHERE price BETWEEN ? AND ?";
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, from);
            statement.setInt(2, to);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                int quantity = rs.getInt("quantity");
                int soldQuantity = rs.getInt("soldQuantity");

                Product product = new Product(id, name, image, price, title, description, amount, quantity, soldQuantity);
                productList.add(product);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public List<Product> searchByKey(String key) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE name LIKE ? OR description LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + key + "%");
            statement.setString(2, "%" + key + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getDouble("price"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                productList.add(product);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> listp = dao.getAllProducts();
        List<Order> list = dao.getAllOrder();
        for (Order product : list) {
            System.out.println(product);
        }

    }
}
