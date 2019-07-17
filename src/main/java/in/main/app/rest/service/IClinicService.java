package in.main.app.rest.service;

import in.main.app.rest.requet.model.ClinicRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;

public interface IClinicService {

	BaseResponse registerClinic(ClinicRegistrationRequest clinicRegistrationRequest);
}
