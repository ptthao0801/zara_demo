package service.DAO;

import model.productManagement.Category;
import model.productManagement.Manufacturer;
import model.productManagement.Product;
import model.productManagement.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static service.DAO.ProductDAO.getConnection;

public class CategoryDAO {
    public static Category getCategoryById(int id){
        Category category = null;
        String query = "SELECT c.CategoryID, c.Name FROM Categories c where CategoryID = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("CategoryID"));
                category.setName(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(category);
        return category;
    }
    public static List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Categories;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("CategoryID"));
                category.setName(rs.getString("Name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Category category:categories){
            System.out.println(category);
        }
        return categories;
    }
}


