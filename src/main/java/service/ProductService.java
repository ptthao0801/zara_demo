package service;

import model.productManagement.Product;
import service.DAO.ProductDAO;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();
    public List<Product> showAll(){
        return ProductDAO.getAllProducts();
    }
}
