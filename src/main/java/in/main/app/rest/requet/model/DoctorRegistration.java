package in.main.app.rest.requet.model;

import java.util.List;

public class DoctorRegistration {
	
	private String first_name;
	private String last_name;
	private String email;
	private String primary_phone_no;
	private String secondory_phone_no;
	private DeviceDetails device_details;
	private Address address;
	
	private List<DocQulification> qualifications;
	
	private List<DocExperience> expriences;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimary_phone_no() {
		return primary_phone_no;
	}

	public void setPrimary_phone_no(String primary_phone_no) {
		this.primary_phone_no = primary_phone_no;
	}

	public String getSecondory_phone_no() {
		return secondory_phone_no;
	}

	public void setSecondory_phone_no(String secondory_phone_no) {
		this.secondory_phone_no = secondory_phone_no;
	}

	public DeviceDetails getDevice_details() {
		return device_details;
	}

	public void setDevice_details(DeviceDetails device_details) {
		this.device_details = device_details;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<DocQulification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<DocQulification> qualifications) {
		this.qualifications = qualifications;
	}

	public List<DocExperience> getExpriences() {
		return expriences;
	}

	public void setExpriences(List<DocExperience> expriences) {
		this.expriences = expriences;
	}

	@Override
	public String toString() {
		return "DoctorRegistration [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", primary_phone_no=" + primary_phone_no + ", secondory_phone_no=" + secondory_phone_no
				+ ", device_details=" + device_details + ", address=" + address + ", qualifications=" + qualifications
				+ ", expriences=" + expriences + "]";
	}

	


	
	

}
