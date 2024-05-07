package service;

import model.productManagement.Manufacturer;
import service.DAO.ManufacturerDAO;

import java.util.List;

public class ManufacturerService {
    private ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
    public List<Manufacturer> showAll(){
        return ManufacturerDAO.getAllManufacturers();
    }
}
