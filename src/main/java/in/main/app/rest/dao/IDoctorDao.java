package in.main.app.rest.dao;

import in.main.app.rest.entity.Doctor;
import in.main.app.rest.entity.DoctorExprience;
import in.main.app.rest.entity.DoctorQulification;
import in.main.app.rest.requet.model.DoctorLoginRequest;

public interface IDoctorDao {
	
	Doctor saveAndMerge(Doctor doctor);
	
	DoctorQulification saveAndMergeDocQulification(DoctorQulification doctorQulification);
	
	DoctorExprience saveAndMergeDocExperience(DoctorExprience doctorExperience);
	
	boolean isDocAlreadyExist(String email);
	
	Doctor isValidDoctor(DoctorLoginRequest doctorLoginRequest);
	
}
