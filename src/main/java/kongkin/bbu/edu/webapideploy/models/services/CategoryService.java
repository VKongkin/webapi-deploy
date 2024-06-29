package kongkin.bbu.edu.webapideploy.models.services;


import kongkin.bbu.edu.webapideploy.exceptions.AppException;
import kongkin.bbu.edu.webapideploy.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll() throws AppException;
    Category getById(Integer id) throws AppException;
    void create(Category req) throws AppException;
    void update(Category req) throws AppException;
    void delete(Category req) throws AppException;
    void checkCategoryId(Integer id) throws AppException;


}
