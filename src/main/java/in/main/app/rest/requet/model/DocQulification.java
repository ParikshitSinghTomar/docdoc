package in.main.app.rest.requet.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DocQulification {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	private String name;
	private String passing_year;
	private String institute;
	private String city;
	private int currntly_working;
	private String start_date;
	private String end_date;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	public int getCurrntly_working() {
		return currntly_working;
	}
	public void setCurrntly_working(int currntly_working) {
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
		return "DocQulification [name=" + name + ", passing_year=" + passing_year + ", institute=" + institute
				+ ", city=" + city + ", currntly_working=" + currntly_working + ", start_date=" + start_date
				+ ", end_date=" + end_date +  "]";
	}
	
	
	
}
