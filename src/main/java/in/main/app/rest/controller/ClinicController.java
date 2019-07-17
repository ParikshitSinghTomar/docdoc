package in.main.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.app.rest.requet.model.ClinicRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IClinicService;
import in.main.app.util.DocLogger;

@RestController
@RequestMapping("/user")
public class ClinicController {


	final static String className = ClinicController.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}
	
	@Autowired
	IClinicService clinicService;
	
	@PostMapping(path="/api/v1/clinic_registration")
	public BaseResponse registerClinic(@RequestHeader(name="app_v",required=true)String headerAppV
			,@RequestHeader(name="auth_token",required=true)String headerIMEICode,@RequestBody ClinicRegistrationRequest clinicRegistrationRequest) {
		
		logD(clinicRegistrationRequest.toString());
		
		BaseResponse baseResponse=clinicService.registerClinic(clinicRegistrationRequest);
	
		return baseResponse;
	}
}
