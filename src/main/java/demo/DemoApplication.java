package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
    }

    private Geometry wktToGeometry(String wktPoint) {
	WKTReader fromText = new WKTReader();
	Geometry geom = null;
	try {
	    geom = fromText.read(wktPoint);
	} catch (ParseException e) {
	    throw new RuntimeException("Not a WKT string:" + wktPoint);
	}
	return geom;
    }

    @Override
    public void run(String... args) throws Exception {

	repository.save(new Customer(null, "Jack", "Bauer", null));
	repository.save(new Customer(null, "Chloe", "O'Brian", null));
	repository.save(new Customer(null, "Kim", "Bauer", null));
	repository.save(new Customer(null, "David", "Palmer", null));
	repository.save(new Customer(null, "Michelle", "Dessler", null));

	repository.save(new Customer(null, "Roger", "Rabbit", wktToGeometry("POINT(-105 40)")));

	// fetch all customers
	System.out.println("Customers found with findAll():");
	System.out.println("-------------------------------");
	repository.findAll().forEach(System.out::println);
	System.out.println();

	// // fetch an individual customer by ID
	Customer customer = repository.findOne(1L);
	System.out.println("Customer found with findOne(1L):");
	System.out.println("--------------------------------");
	System.out.println(customer);
	System.out.println();

	// fetch customers by last name
	System.out.println("Customer found with findByLastName('Bauer'):");
	System.out.println("--------------------------------------------");
	repository.findByLastName("Bauer").forEach(System.out::println);

	System.out.println("Customers found within POLYGON((-107 39, -102 39, -102 41, -107 41, -107 39)):");
	System.out.println("--------------------------------");
	repository.findWithin(wktToGeometry("POLYGON((-107 39, -102 39, -102 41, -107 41, -107 39))"))
		.forEach(System.out::println);
    }
}
