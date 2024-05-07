package service.DAO;

import model.productManagement.Category;
import model.productManagement.Manufacturer;
import model.productManagement.Product;
import model.productManagement.Warehouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/zara";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "12345678_ABC";
    ProductDAO productDAO = new ProductDAO();
    static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found!");
        }
        return connection;
    }
    public static Product getProductById(int id){
        Product product = null;
        String query = "SELECT * FROM Products where ProductID = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("ProductID"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getBigDecimal("Price"));
                int categoryID = rs.getInt("CategoryID");
                Category category = CategoryDAO.getCategoryById(categoryID);
                product.setCategory(category);
                int manufacturerID = rs.getInt("ManufacturerID");
                Manufacturer manufacturer = ManufacturerDAO.getManufacturerById(manufacturerID);
                product.setManufacturer(manufacturer);
                int warehouseID = rs.getInt("WarehouseID");
                Warehouse warehouse = WarehouseDAO.getWarehouseById(warehouseID);
                product.setWarehouse(warehouse);
                product.setImage(rs.getString("Image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(product);
        return product;
    }

    public static List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Products;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("ProductID"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getBigDecimal("Price"));
                int categoryID = rs.getInt("CategoryID");
                Category category = CategoryDAO.getCategoryById(categoryID);
                product.setCategory(category);
                int manufacturerID = rs.getInt("ManufacturerID");
                Manufacturer manufacturer = ManufacturerDAO.getManufacturerById(manufacturerID);
                product.setManufacturer(manufacturer);
                int warehouseID = rs.getInt("WarehouseID");
                Warehouse warehouse = WarehouseDAO.getWarehouseById(warehouseID);
                product.setWarehouse(warehouse);
                product.setImage(rs.getString("Image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Product product:products){
            System.out.println(product);
        }
        return products;
    }

    public static void main(String[] args) {
        ProductDAO.getAllProducts();
    }
}

