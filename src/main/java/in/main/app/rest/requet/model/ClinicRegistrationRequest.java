package in.main.app.rest.requet.model;

public class ClinicRegistrationRequest {

	
	private String clinic_name;
	private String clinic_owner;
	private ClinicAddress clinic_address;
	private ClinicPhotos clinic_photos;
	
	
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	public String getClinic_owner() {
		return clinic_owner;
	}
	public void setClinic_owner(String clinic_owner) {
		this.clinic_owner = clinic_owner;
	}
	
	public ClinicAddress getClinic_address() {
		return clinic_address;
	}
	public void setClinic_address(ClinicAddress clinic_address) {
		this.clinic_address = clinic_address;
	}
	public ClinicPhotos getClinic_photos() {
		return clinic_photos;
	}
	public void setClinic_photos(ClinicPhotos clinic_photos) {
		this.clinic_photos = clinic_photos;
	}
	@Override
	public String toString() {
		return "ClinicRegistrationRequest [clinic_name=" + clinic_name + ", clinic_owner=" + clinic_owner
				+ ", clinic_address=" + clinic_address + ", clinic_photos=" + clinic_photos + "]";
	}
	
	
	
	
}
