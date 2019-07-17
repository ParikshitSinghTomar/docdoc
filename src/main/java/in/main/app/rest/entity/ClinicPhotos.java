package in.main.app.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinic_photos")
public class ClinicPhotos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	int id;
	
	
	@Column(name="clinic_id")
	private String clinic_id;
	
	@Column(name = "banner")
	private String banner;
	
	@Column(name="photos")
	private String photos;
	
	
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	@Override
	public String toString() {
		return "ClinicPhotos [banner=" + banner + ", photos=" + photos + "]";
	}
	
	
	
}
