package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clinic")
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	@Column(name = "clinic_name")
	private String clinic_name;
	
	
	@Column(name = "clinic_owner")
	private String clinic_owner;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_address_id")
	private ClinicAddress clinicAddress;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_photos_id")
	private ClinicPhotos clinicPhotos;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public ClinicAddress getClinicAddress() {
		return clinicAddress;
	}


	public void setClinicAddress(ClinicAddress clinicAddress) {
		this.clinicAddress = clinicAddress;
	}


	public ClinicPhotos getClinicPhotos() {
		return clinicPhotos;
	}


	public void setClinicPhotos(ClinicPhotos clinicPhotos) {
		this.clinicPhotos = clinicPhotos;
	}


	@Override
	public String toString() {
		return "Clinic [id=" + id + ", clinic_name=" + clinic_name + ", clinic_owner=" + clinic_owner
				+ ", clinicAddress=" + clinicAddress + ", clinicPhotos=" + clinicPhotos + "]";
	}
}
