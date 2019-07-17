package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clinic_address")
public class ClinicAddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	
	@Column(name="clinic_id")
	private String clinic_id;
	
	
	@Column(name="line1")
	private String line1;
	

	@Column(name="line2")
	private String line2;
	

	@Column(name="city")
	private String city;
	

	@Column(name="pincode")
	private String pincode;
	

	@Column(name="state")
	private String state;
	

	@Column(name="location")
	private String location;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClinic_id() {
		return clinic_id;
	}


	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}


	public String getLine1() {
		return line1;
	}


	public void setLine1(String line1) {
		this.line1 = line1;
	}


	public String getLine2() {
		return line2;
	}


	public void setLine2(String line2) {
		this.line2 = line2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
