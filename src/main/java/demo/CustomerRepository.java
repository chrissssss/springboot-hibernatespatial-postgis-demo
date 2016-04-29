package demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vividsolutions.jts.geom.Geometry;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query("select c from Customer c where within(c.geom, ?1) = true")
    List<Customer> findWithin(Geometry filter);
}