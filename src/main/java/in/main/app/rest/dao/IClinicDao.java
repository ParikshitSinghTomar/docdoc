package in.main.app.rest.dao;

import in.main.app.rest.entity.Clinic;
import in.main.app.rest.entity.ClinicAddress;
import in.main.app.rest.entity.ClinicPhotos;

public interface IClinicDao {

	ClinicAddress registerClinicAddress(ClinicAddress clinicAddress);
	ClinicPhotos registerClinicPhotos(ClinicPhotos clinicPhotos);
	Clinic registerClinic(Clinic clinic);
	
}
