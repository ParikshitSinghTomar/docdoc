package in.main.app.rest.requet.model;

public class DeviceDetails {

	private String imei1;
	private String imei2;
	private String osVersion;
	private String deviceModel;
	private String deviceManufacturer;
	private String simCompany;
	private Location locationRequest;
	private String ipAddress;
	
	
	public String getImei1() {
		return imei1;
	}
	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}
	public String getImei2() {
		return imei2;
	}
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}
	public void setDeviceManufacturer(String deviceManufacturer) {
		this.deviceManufacturer = deviceManufacturer;
	}
	public String getSimCompany() {
		return simCompany;
	}
	public void setSimCompany(String simCompany) {
		this.simCompany = simCompany;
	}
	public Location getLocationRequest() {
		return locationRequest;
	}
	public void setLocationRequest(Location locationRequest) {
		this.locationRequest = locationRequest;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Override
	public String toString() {
		return "DeviceDetails [imei1=" + imei1 + ", imei2=" + imei2 + ", osVersion=" + osVersion + ", deviceModel="
				+ deviceModel + ", deviceManufacturer=" + deviceManufacturer + ", simCompany=" + simCompany
				+ ", locationRequest=" + locationRequest + ", ipAddress=" + ipAddress + "]";
	}
	
	
	
}
