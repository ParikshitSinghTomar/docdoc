package in.main.app.rest.requet.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DocExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	@Column(name = "orgranization_name")
	private String orgranization_name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name ="currntly_working")
	private String currntly_working;
	
	@Column(name ="start_date")
	private String start_date;
	
	@Column(name ="end_date")
	private String end_date;
	
	
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
	public String getCurrntly_working() {
		return currntly_working;
	}
	public void setCurrntly_working(String currntly_working) {
		this.currntly_working = currntly_working;
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
	@Override
	public String toString() {
		return "DocExperience [id=" + id + ", orgranization_name=" + orgranization_name + ", city=" + city + ", state="
				+ state + ", currntly_working=" + currntly_working + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}
	
	
	
	
}
