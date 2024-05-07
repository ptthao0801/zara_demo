package service.DAO;

import model.productManagement.Category;
import model.productManagement.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static service.DAO.ProductDAO.getConnection;

public class ManufacturerDAO {
    public static Manufacturer getManufacturerById(int id){
        Manufacturer manufacturer = null;
        String query = "SELECT * FROM Manufacturers where ManufacturerID = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setId(rs.getInt("ManufacturerID"));
                manufacturer.setName(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(manufacturer);
        return manufacturer;
    }
    public static List<Manufacturer> getAllManufacturers(){
        List<Manufacturer> manufacturers = new ArrayList<>();
        String query = "SELECT * FROM Manufacturers;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(rs.getInt("ManufacturerID"));
                manufacturer.setName(rs.getString("Name"));
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Manufacturer manufacturer:manufacturers){
            System.out.println(manufacturer);
        }
        return manufacturers;
    }
}
