package kongkin.bbu.edu.webapideploy.models.repositories;

import kongkin.bbu.edu.webapideploy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
