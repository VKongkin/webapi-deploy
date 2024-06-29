package kongkin.bbu.edu.webapideploy.models.services;


import kongkin.bbu.edu.webapideploy.exceptions.AppException;
import kongkin.bbu.edu.webapideploy.models.Product;
import kongkin.bbu.edu.webapideploy.models.ProductUnit;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws AppException;
    void create(Product req) throws AppException;

    Product getById(Integer id) throws AppException;
    void update(Product req) throws AppException;
    void delete(Product req) throws AppException;
    List<ProductUnit> getProductUnitsByProductId(Integer id) throws AppException;
}
