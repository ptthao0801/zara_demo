package controller;

import model.productManagement.Category;
import model.productManagement.Manufacturer;
import model.productManagement.Product;
import model.productManagement.Warehouse;
import service.CategoryService;
import service.ManufacturerService;
import service.ProductService;
import service.WarehouseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    private ManufacturerService manufacturerService = new ManufacturerService();
    private WarehouseService warehouseService = new WarehouseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/create.jsp").forward(req, resp);
                break;
            default:
                returnHomepage(req,resp);
                break;
        }
    }

    private void returnHomepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = this.productService.showAll();
        List<Category> categories = this.categoryService.showAll();
        List<Manufacturer> manufacturers = this.manufacturerService.showAll();
        List<Warehouse> warehouses = this.warehouseService.showAll();

        req.setAttribute("products", products);
        req.setAttribute("categories",categories);
        req.setAttribute("manufacturers",manufacturers);
        req.setAttribute("warehouses",warehouses);

        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(req,resp);
    }


}
