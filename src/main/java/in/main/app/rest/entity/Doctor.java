package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	@Column(name = "firstname")
	private String firstName;
	
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name = "primary_phone_no")
	private String primaryPhoneNo;
	
	@Column(name = "secondory_phone_no")
	private String secondryPhoneNo;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "device_id")
	private Device device;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimaryPhoneNo() {
		return primaryPhoneNo;
	}

	public void setPrimaryPhoneNo(String primaryPhoneNo) {
		this.primaryPhoneNo = primaryPhoneNo;
	}

	public String getSecondryPhoneNo() {
		return secondryPhoneNo;
	}

	public void setSecondryPhoneNo(String secondryPhoneNo) {
		this.secondryPhoneNo = secondryPhoneNo;
	}

	public Address getAddress_id() {
		return address;
	}

	public void setAddress_id(Address address) {
		this.address = address;
	}

	public Device getDevice_id() {
		return device;
	}

	public void setDevice_id(Device device) {
		this.device = device;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", primaryPhoneNo=" + primaryPhoneNo + ", secondryPhoneNo=" + secondryPhoneNo + ", address_id="
				+ address + ", device=" + device + "]";
	}
	
	
	
	
	
}
