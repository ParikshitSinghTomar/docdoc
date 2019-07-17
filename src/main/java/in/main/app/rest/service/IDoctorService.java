package in.main.app.rest.service;

import in.main.app.rest.requet.model.DoctorLoginRequest;
import in.main.app.rest.requet.model.DoctorRegistration;
import in.main.app.rest.response.model.BaseResponse;

public interface IDoctorService {
	
	public BaseResponse registerDoctor(DoctorRegistration doctorRegistration);
	

	public BaseResponse loginDoctor(DoctorLoginRequest doctorLoginRequest);

}
