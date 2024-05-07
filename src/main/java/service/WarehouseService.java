package service;

import model.productManagement.Product;
import model.productManagement.Warehouse;
import service.DAO.ProductDAO;
import service.DAO.WarehouseDAO;

import java.util.List;

public class WarehouseService {
    private WarehouseDAO warehouseDAO = new WarehouseDAO();
    public List<Warehouse> showAll(){
        return WarehouseDAO.getAllWarehouses();
    }
}
