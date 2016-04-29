package demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Type(type = "org.hibernate.spatial.GeometryType")
    private Geometry geom;

    public Customer(long id, String firstName, String lastName, Geometry geom) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.geom = geom;
    }

    // default constructor required by JPA and not otherwise used
    protected Customer() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Geometry getGeom() {
	return geom;
    }

    public void setGeom(Geometry geom) {
	this.geom = geom;
    }

    @Override
    public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", geom=" + geom + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((geom == null) ? 0 : geom.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Customer other = (Customer) obj;
	if (firstName == null) {
	    if (other.firstName != null)
		return false;
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (geom == null) {
	    if (other.geom != null)
		return false;
	} else if (!geom.equals(other.geom))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (lastName == null) {
	    if (other.lastName != null)
		return false;
	} else if (!lastName.equals(other.lastName))
	    return false;
	return true;
    }

    public Customer(Long id, String firstName, String lastName, Geometry geom) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.geom = geom;
    }

}