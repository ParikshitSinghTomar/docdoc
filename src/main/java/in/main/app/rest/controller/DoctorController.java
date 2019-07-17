package in.main.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.app.rest.requet.model.DoctorLoginRequest;
import in.main.app.rest.requet.model.DoctorRegistration;
import in.main.app.rest.requet.model.UserLoginRequest;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IDoctorService;
import in.main.app.util.DocLogger;

@RestController
@RequestMapping("/doc")
public class DoctorController {


	final static String className = DoctorController.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}
	
	@Autowired
	IDoctorService docService;
	
	@PostMapping(path="/api/v1/doc_registration")
	public BaseResponse registerDoc(@RequestHeader(name="app_v",required=true)String headerAppV
			,@RequestHeader(name="device_code",required=true)String headerIMEICode,@RequestBody DoctorRegistration doctorRegistrationRequest) {
		
		logD(doctorRegistrationRequest.toString());
		
		BaseResponse baseResponse=docService.registerDoctor(doctorRegistrationRequest);
	
		return baseResponse;
	}

	@PostMapping(path="/api/v1/login")
	public BaseResponse loginDoc(@RequestHeader(name="app_v",required=true)String headerAppV
			,@RequestHeader(name="auth_token",required=true)String headerIMEICode,@RequestBody DoctorLoginRequest docLoginRequest) {
		
		logD(docLoginRequest.toString());

		BaseResponse baseResponse=docService.loginDoctor(docLoginRequest);
	
		return baseResponse;
	}
}
