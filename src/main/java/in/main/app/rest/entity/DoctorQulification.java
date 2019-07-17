package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doc_qulification")
public class DoctorQulification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	@Column(name = "name_of_degree")
	private String name_of_degree;

	@Column(name = "passing_year")
	private String passing_year;
	
	
	@Column(name = "institute")
	private String institute;
	
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "doctor_id")
	private int doctor_id;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName_of_degree() {
		return name_of_degree;
	}


	public void setName_of_degree(String name_of_degree) {
		this.name_of_degree = name_of_degree;
	}


	public String getPassing_year() {
		return passing_year;
	}


	public void setPassing_year(String passing_year) {
		this.passing_year = passing_year;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}


	@Override
	public String toString() {
		return "DoctorQulification [id=" + id + ", name_of_degree=" + name_of_degree + ", passing_year=" + passing_year
				+ ", institute=" + institute + ", city=" + city + ", doctor_id=" + doctor_id + "]";
	}
	
}
