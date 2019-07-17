package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doc_experience")
public class DoctorExprience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	@Column(name = "orgranization_name")
	private String orgranization_name;
	
	
	@Column(name = "start_date")
	private String start_date;
	
	@Column(name = "end_date")
	private String end_date;
	
	@Column(name = "current_working")
	private int current_working;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "doctor_id")
	private int doctor_id;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrgranization_name() {
		return orgranization_name;
	}

	public void setOrgranization_name(String orgranization_name) {
		this.orgranization_name = orgranization_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getCurrent_working() {
		return current_working;
	}

	public void setCurrent_working(int current_working) {
		this.current_working = current_working;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "DoctorExprience [id=" + id + ", orgranization_name=" + orgranization_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", current_working=" + current_working + ", city=" + city + ", state="
				+ state + ", doctor_id=" + doctor_id + "]";
	}

	
	
	
}
