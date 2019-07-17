package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	private String imei1;
	private String imei2;
	private String deviceModel;
	private String osVersion;
	private String deviceManufacturer;
	private String simCompany;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Device [id=" + id + ", imei1=" + imei1 + ", imei2=" + imei2 + ", deviceModel=" + deviceModel
				+ ", osVersion=" + osVersion + ", deviceManufacturer=" + deviceManufacturer + ", simCompany="
				+ simCompany + ", location=" + location + "]";
	}
	
}
