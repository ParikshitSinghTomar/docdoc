package in.main.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.app.rest.requet.model.UserLoginRequest;
import in.main.app.rest.requet.model.UserRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IUserService;
import in.main.app.rest.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello, I am user.";
	}
	
	@PostMapping(path="/api/v1/registration")
	public BaseResponse userRegistration(@RequestHeader(name="app_v",required=true)String headerAppV
			,@RequestHeader(name="device_code",required=true)String headerIMEICode,@RequestBody UserRegistrationRequest userRegistrationRequst) {
		
		BaseResponse baseResponse=userService.doUserRegistration(userRegistrationRequst);
	
		return baseResponse;
	} 
	
	@PostMapping(path="/api/v1/login")
	public BaseResponse userLogin(@RequestHeader(name="app_v",required=true)String headerAppV
			,@RequestHeader(name="auth_token",required=true)String headerIMEICode,@RequestBody UserLoginRequest userLoginRequest) {
		
		BaseResponse baseResponse=userService.doUserLogin(userLoginRequest);
	
		return baseResponse;
	} 
	
	
	
	
}
