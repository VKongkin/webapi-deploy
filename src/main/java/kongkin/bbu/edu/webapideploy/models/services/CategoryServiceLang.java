package kongkin.bbu.edu.webapideploy.models.services;


import kongkin.bbu.edu.webapideploy.models.Category;
import kongkin.bbu.edu.webapideploy.models.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceLang {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceLang.class);
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(String lang) {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> {
            if ("kh".equalsIgnoreCase(lang)) {
                category.setName(category.getNameKH());
            }
            return category;
        }).collect(Collectors.toList());
    }
}
