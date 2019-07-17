package in.main.app.rest.requet.model;

import java.util.ArrayList;

public class ClinicPhotos {

	
	private String banner;
	private ArrayList<String> photos;
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public ArrayList<String> getPhotos() {
		return photos;
	}
	public void setPhotos(ArrayList<String> photos) {
		this.photos = photos;
	}
	@Override
	public String toString() {
		return "ClinicPhotos [banner=" + banner + ", photos=" + photos + "]";
	}
	
	
}
