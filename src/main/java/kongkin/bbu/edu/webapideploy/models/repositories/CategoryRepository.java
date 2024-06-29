package kongkin.bbu.edu.webapideploy.models.repositories;


import kongkin.bbu.edu.webapideploy.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String status);
}
