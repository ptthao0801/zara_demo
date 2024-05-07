package service;

import model.productManagement.Category;
import model.productManagement.Product;
import service.DAO.CategoryDAO;
import service.DAO.ProductDAO;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    public List<Category> showAll(){
        return CategoryDAO.getAllCategories();
    }
}
