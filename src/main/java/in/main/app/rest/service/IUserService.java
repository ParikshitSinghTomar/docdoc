package in.main.app.rest.service;

import in.main.app.rest.requet.model.UserLoginRequest;
import in.main.app.rest.requet.model.UserRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;

public interface IUserService {
	
	BaseResponse doUserRegistration(UserRegistrationRequest userRegistrationRequest);

	BaseResponse doUserLogin(UserLoginRequest userLoginRequest);

}
