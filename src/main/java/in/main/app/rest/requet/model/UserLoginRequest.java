package in.main.app.rest.requet.model;

public class UserLoginRequest {

	private String userName;
	private String email;
	private String mobileNo;
	private DeviceDetails deviceDetails;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public DeviceDetails getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(DeviceDetails deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginRequest [userName=" + userName + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", deviceDetails=" + deviceDetails + ", password=" + password + "]";
	}

}
