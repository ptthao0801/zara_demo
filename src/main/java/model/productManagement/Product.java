package model.productManagement;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Manufacturer manufacturer;
    private Warehouse warehouse;
    private String image;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price, Category category, Manufacturer manufacturer, Warehouse warehouse, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.manufacturer = manufacturer;
        this.warehouse = warehouse;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", manufacturer=" + manufacturer +
                ", warehouse=" + warehouse +
                ", image='" + image + '\'' +
                '}';
    }
}
