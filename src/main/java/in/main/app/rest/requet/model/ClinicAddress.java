package in.main.app.rest.requet.model;

public class ClinicAddress {


	private String line1;
	private String line2;
	private String city;
	private String pincode;
	private String state;
	private Location location;
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "ClinicAddress [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", location=" + location + "]";
	}
	
	
	
}
