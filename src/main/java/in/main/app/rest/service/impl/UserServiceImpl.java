package in.main.app.rest.service.impl;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.main.app.json.validator.UserJsonValidator;
import in.main.app.rest.constants.Constants;
import in.main.app.rest.dao.IUserDao;
import in.main.app.rest.entity.User;
import in.main.app.rest.requet.model.UserLoginRequest;
import in.main.app.rest.requet.model.UserRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IUserService;
import in.main.app.util.DocLogger;

@Service
public class UserServiceImpl implements IUserService {

	final static String className = UserServiceImpl.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public BaseResponse doUserRegistration(UserRegistrationRequest userRegistrationRequest) {

		logD("doUserRegistration[----------------------" + userRegistrationRequest.toString()
				+ "----------------------]");
		BaseResponse baseRespose = new BaseResponse();
		String errorMsg = validateUserRegistrationRequest(userRegistrationRequest);
		if (errorMsg != null) {
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_JSON_VALIDATION_FAILED);
			baseRespose.setMessage(
					Constants.getMessage(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_JSON_VALIDATION_FAILED));
			baseRespose.setData(errorMsg);
			return baseRespose;
		}
		// if above if condition return true it means validation done successfully
		logD("Pass all validation succesfully");
		if (!validateUserIsUnique(userRegistrationRequest)) {
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_ALREADY_REGISTERED);
			baseRespose.setMessage(
					Constants.getMessage(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_ALREADY_REGISTERED));
			baseRespose.setData(errorMsg);
			return baseRespose;
		}
		User user = new User();
		try {

			user.setFirstName(userRegistrationRequest.getFirstName());
			user.setLastName(userRegistrationRequest.getLastName());
			user.setEmail(userRegistrationRequest.getEmail());
			user.setGender(userRegistrationRequest.getGender());
			user.setMobileNo(userRegistrationRequest.getMobileNo());
			user.setUserName(userRegistrationRequest.getUserName());
			user.setPassword(userRegistrationRequest.getPassword());
			user = userDao.saveUser(user);
			logD("Succesfully saved user");
		} catch (Exception e) {
			e.printStackTrace();
			logD("Error: " + e.getMessage());
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_NOT_ABLE_TO_SAVE);
			baseRespose.setMessage(e.getMessage());
			return baseRespose;
		}
		if (user == null) {
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_NOT_ABLE_TO_SAVE);
			baseRespose.setMessage(
					Constants.getMessage(Constants.ErrorResponseCode.USER_REGISTRATION_ERROR_NOT_ABLE_TO_SAVE));
			return baseRespose;
		}
		logD("Success Response");
		baseRespose.setStatus(true);
		baseRespose.setCode(Constants.SuccessResponseCode.USER_REGISTRATION_SUCCESSFULLY_DONE);
		baseRespose.setMessage(Constants.getMessage(Constants.SuccessResponseCode.USER_REGISTRATION_SUCCESSFULLY_DONE));
		return baseRespose;
	}

	@Override
	public BaseResponse doUserLogin(UserLoginRequest userLoginRequest) {
		logD("doUserRegistration[----------------------" + userLoginRequest.toString() + "----------------------]");
		BaseResponse baseRespose = new BaseResponse();
		String errorMsg = validateUserLoginRequest(userLoginRequest);
		if (errorMsg != null) {
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_LOGIN_ERROR_JSON_VALIDATION_FAILED);
			baseRespose.setMessage(
					Constants.getMessage(Constants.ErrorResponseCode.USER_LOGIN_ERROR_JSON_VALIDATION_FAILED));
			baseRespose.setData(errorMsg);
			return baseRespose;
		}

		logD("Pass all validation succesfully");
		User user = validateUserExit(userLoginRequest);
		if (user == null) {
			baseRespose.setStatus(false);
			baseRespose.setCode(Constants.ErrorResponseCode.USER_LOGIN_ERROR_DOES_NOT_EXITS);
			baseRespose.setMessage(Constants.getMessage(Constants.ErrorResponseCode.USER_LOGIN_ERROR_DOES_NOT_EXITS));
			errorMsg = "Please provide valid username and password.";
			baseRespose.setData(errorMsg);
			return baseRespose;
		}

		baseRespose.setStatus(true);
		baseRespose.setCode(Constants.SuccessResponseCode.USER_LOGIN_SUCCESSFULLY_DONE);
		baseRespose.setMessage(Constants.getMessage(Constants.SuccessResponseCode.USER_LOGIN_SUCCESSFULLY_DONE));
		user.setPassword("");
		baseRespose.setData(user);
		return baseRespose;

	}

	private User validateUserExit(UserLoginRequest userLoginRequest) {
		try {
			User user = userDao.getUser(userLoginRequest.getUserName(), userLoginRequest.getEmail(),
					userLoginRequest.getMobileNo(), userLoginRequest.getPassword());
			//logD("user: " + user != null ? user.toString() : "user object is null");
			if (user!=null&&user.getId() > 0) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String validateUserLoginRequest(UserLoginRequest userLoginRequest) {
		String errorMsg = null;
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if ((userLoginRequest.getUserName() == null || userLoginRequest.getUserName().length() < 5)
				&& (userLoginRequest.getEmail() == null || pattern.matcher(userLoginRequest.getEmail()).matches())
				&& (userLoginRequest.getMobileNo() == null || userLoginRequest.getMobileNo().length() < 10)
				&& (userLoginRequest.getPassword() == null || userLoginRequest.getPassword().length() < 6)) {
			errorMsg = "Please enter valid username/password";
		}
		return errorMsg;
	}

	private boolean validateUserIsUnique(UserRegistrationRequest userRegistrationRequest) {
		try {
			User user = userDao.getUser(userRegistrationRequest.getEmail(), userRegistrationRequest.getMobileNo());
//			logD("user: " + user != null ? user.toString() : "user object is null");
			if (user!=null&&user.getId() > 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static String validateUserRegistrationRequest(UserRegistrationRequest request) {

		logD("validateUserRegistration---> " + request.toString());
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String errorMsg = null;
		if (request.getFirstName() == null || request.getFirstName().length() < 5) {
			errorMsg = "First Name empty";

		} else if (request.getLastName() == null || request.getLastName().length() < 5) {
			errorMsg = "Last Name empty";

		} else if (request.getEmail() == null || request.getEmail().length() < 5) {
			errorMsg = "Not valid mail";

		} else if (pattern.matcher(request.getEmail()).matches()) {
			errorMsg = "Not a valid mail.";

		} else if (request.getUserName() == null || request.getUserName().length() < 5) {
			errorMsg = "username empty";

		} else if (request.getMobileNo() == null || request.getMobileNo().length() < 10) {
			errorMsg = "Mobile No Empty";
		} else if (request.getGender() == null || request.getGender().length() < 4) {
			errorMsg = "Gender Empty";
		} else if (request.getAddress() == null) {
			errorMsg = "Address Empty";
		} else if (request.getAddress().getLine1() == null || request.getAddress().getLine1().trim().length() == 0) {
			errorMsg = "Address Line1 Empty";
		} else if (request.getAddress().getCity() == null || request.getAddress().getCity().trim().length() == 0) {
			errorMsg = "Address City Empty";
		} else if (request.getAddress().getState() == null || request.getAddress().getState().trim().length() == 0) {
			errorMsg = "Address State Empty";
		} else if (request.getAddress().getPinCode() == null
				|| request.getAddress().getPinCode().trim().length() == 0) {
			errorMsg = "Address Pincode Empty";
		} else if (request.getAddress().getCountry() == null
				|| request.getAddress().getCountry().trim().length() == 0) {
			errorMsg = "Address country Empty";
		} else if (request.getAddress().getLocation() == null) {
			errorMsg = "Address Location Empty";
		} else if (request.getDeviceDetails() == null) {
			errorMsg = "Address device details Empty";
		} else {
			errorMsg = null;
		}
		logD(errorMsg);
		return errorMsg;
	}

}
