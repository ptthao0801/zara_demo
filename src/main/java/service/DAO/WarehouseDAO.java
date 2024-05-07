package service.DAO;

import model.productManagement.Category;
import model.productManagement.Manufacturer;
import model.productManagement.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static service.DAO.ProductDAO.getConnection;

public class WarehouseDAO {
    public static Warehouse getWarehouseById(int id){
        Warehouse warehouse = null;
        String query = "SELECT * FROM Warehouses c where WarehouseID = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                warehouse = new Warehouse();
                warehouse.setId(rs.getInt("WarehouseID"));
                warehouse.setName(rs.getString("Name"));
                warehouse.setLocation(rs.getString("Location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(warehouse);
        return warehouse;
    }
    public static List<Warehouse> getAllWarehouses(){
        List<Warehouse> warehouses = new ArrayList<>();
        String query = "SELECT * FROM Warehouses;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setId(rs.getInt("WarehouseID"));
                warehouse.setName(rs.getString("Name"));
                warehouse.setLocation(rs.getString("Location"));
                warehouses.add(warehouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Warehouse warehouse:warehouses){
            System.out.println(warehouse);
        }
        return warehouses;
    }
}
