package kongkin.bbu.edu.webapideploy.models.repositories;

import kongkin.bbu.edu.webapideploy.models.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {
    List<ProductUnit> findAllByProductId(Integer id);
}
