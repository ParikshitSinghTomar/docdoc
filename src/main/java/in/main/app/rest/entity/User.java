package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;

	@Column(name = "gender")
	private String gender;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "is_mobile_verified")
	private boolean isMobileVerified;

	@Column(name = "auth_token")
	private String authToken;

	@Column(name = "isEmailVerified")
	private boolean isEmailVerified;

	@Column(name = "password")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "device_id")
	private Device device;

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

	public boolean isMobileVerified() {
		return isMobileVerified;
	}

	public void setMobileVerified(boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return this.gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", mobileNo=" + mobileNo + ", isMobileVerified="
				+ isMobileVerified + ", authToken=" + authToken + ", isEmailVerified=" + isEmailVerified + "]";
	}

}
