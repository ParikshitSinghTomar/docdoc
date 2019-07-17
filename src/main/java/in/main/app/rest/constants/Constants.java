package in.main.app.rest.constants;

import java.util.HashMap;

import org.omg.PortableInterceptor.SUCCESSFUL;

//1xx: Information
//2xx: Successful
//3xx: Redirection
//4xx: Client Error
//5xx: Server Error
public class Constants {

	public static final int UNIV_SUCCESS = 200;

	public interface SuccessResponseCode {
		int USER_REGISTRATION_SUCCESSFULLY_DONE = 201;
		int USER_LOGIN_SUCCESSFULLY_DONE = 202;
		int CLINIC_REGISTRATION_SUCCESSFULLY_DONE = 203;
		int DOCTOR_REGISTRATION_DONE=204;
		int VALID_DOC=205;
	}

	public interface ErrorResponseCode {
		int USER_REGISTRATION_ERROR_JSON_VALIDATION_FAILED = 401;
		int USER_REGISTRATION_ERROR_NOT_ABLE_TO_SAVE = 402;
		int USER_REGISTRATION_ERROR_ALREADY_REGISTERED = 403;
		int USER_LOGIN_ERROR_JSON_VALIDATION_FAILED = 405;
		int USER_LOGIN_ERROR_DOES_NOT_EXITS = 404;
		int CLINIC_REGISTRATION_JSON_VALIDATION_FALIED=406;
		int CLINIC_REGISTRATION_DB_VALIDATION_FALIED=407;
		int DOC_REGISTRATION_JSON_VALIDATION_FAILED=408;
		int DOC_REGISTRATION_FAILED_ALREADY_EXIT=409;
		int DOC_QULIFICATION_CAN_NOT_NULL = 410;
		int DOC_LOGIN_FAILED=411;
	}

	static HashMap<Integer, String> responseMessagMap = new HashMap<>();

	static {
		responseMessagMap.put(SuccessResponseCode.USER_REGISTRATION_SUCCESSFULLY_DONE,
				"Registration successfully done.");
		responseMessagMap.put(ErrorResponseCode.USER_REGISTRATION_ERROR_JSON_VALIDATION_FAILED,
				"Please provide all required inputs.");
		responseMessagMap.put(ErrorResponseCode.USER_REGISTRATION_ERROR_NOT_ABLE_TO_SAVE,
				"There are some error in new user registration. Please try after some time.");
		responseMessagMap.put(ErrorResponseCode.USER_REGISTRATION_ERROR_ALREADY_REGISTERED,
				"User is already registered.");
		responseMessagMap.put(ErrorResponseCode.USER_LOGIN_ERROR_JSON_VALIDATION_FAILED,
				"Please provide all required inputs.");
		responseMessagMap.put(ErrorResponseCode.USER_LOGIN_ERROR_DOES_NOT_EXITS,
				"User does not exist. Please check username or password.");
		responseMessagMap.put(SuccessResponseCode.USER_LOGIN_SUCCESSFULLY_DONE, "User found on server.");
		responseMessagMap.put(ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED, "Please provide valid information.");
		responseMessagMap.put(ErrorResponseCode.CLINIC_REGISTRATION_DB_VALIDATION_FALIED, "Sorry, we can not register your clinic. There are some technical glitch.");
		responseMessagMap.put(ErrorResponseCode.DOC_REGISTRATION_JSON_VALIDATION_FAILED, "Please provide valid information.");
		responseMessagMap.put(ErrorResponseCode.DOC_QULIFICATION_CAN_NOT_NULL, "Please provide atleast one qualification.");
		responseMessagMap.put(SuccessResponseCode.DOCTOR_REGISTRATION_DONE,
				"Registration successfully done.");
		responseMessagMap.put(ErrorResponseCode.DOC_REGISTRATION_FAILED_ALREADY_EXIT,
				"Email already linked with other user.");
		responseMessagMap.put(ErrorResponseCode.DOC_LOGIN_FAILED,
				"User doesn't exist with provided credentials");
		responseMessagMap.put(SuccessResponseCode.VALID_DOC,
				"Doctor Login Found");
	}

	public static String getMessage(int code) {
		return responseMessagMap.get(code);
	}
}
