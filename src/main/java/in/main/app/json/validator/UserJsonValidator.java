package in.main.app.json.validator;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import in.main.app.rest.requet.model.UserRegistrationRequest;

public class UserJsonValidator {

	final static Logger logger = Logger.getLogger(UserJsonValidator.class);
	public static boolean validateUserRegistrationRequest(UserRegistrationRequest request) {
		
		logger.debug(request.toString());
		String regex = "^(.+)@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		String erroeMsg="Pass all validation successfully";
		if(request.getFirstName()==null||request.getFirstName().length()<5) {
			erroeMsg="First Name empty";
			return false;
		}else if(request.getLastName()==null||request.getLastName().length()<5) {
			erroeMsg="Last Name empty";
			return false;
		}else if(request.getEmail()==null||request.getEmail().length()<5) {
			erroeMsg="Not valid mail";
			return false;
		}else if(pattern.matcher(request.getEmail()).matches()) {
			erroeMsg="Not a valid mail.";
			return false;
		}else if(request.getUserName()==null||request.getUserName().length()<5) {
			erroeMsg="username empty";
			return false;
		}else if(request.getMobileNo()==null||request.getMobileNo().length()<10) {
			erroeMsg="Mobile No Empty";
			return false;
		}else if(request.getGender()==null||request.getGender().length()<5) {
			erroeMsg="Gender Empty";
			return false;
		}else if(request.getAddress()==null) {
			erroeMsg="Address Empty";
			return false;
		}else if(request.getAddress().getLine1()==null||request.getAddress().getLine1().trim().length()==0) {
			erroeMsg="Address Line1 Empty";
			return false;
		}else if(request.getAddress().getCity()==null||request.getAddress().getCity().trim().length()==0) {
			erroeMsg="Address City Empty";
			return false;
		}else if(request.getAddress().getState()==null||request.getAddress().getState().trim().length()==0) {
			erroeMsg="Address State Empty";
			return false;
		}else if(request.getAddress().getPinCode()==null||request.getAddress().getPinCode().trim().length()==0) {
			erroeMsg="Address Pincode Empty";
			return false;
		}else if(request.getAddress().getCountry()==null||request.getAddress().getCountry().trim().length()==0) {
			erroeMsg="Address country Empty";
			return false;
		}else if(request.getAddress().getLocation()==null) {
			erroeMsg="Address Location Empty";
			return false;
		}else if(request.getDeviceDetails()==null) {
			erroeMsg="Address device details Empty";
			return false;
		}
		logger.debug(erroeMsg);
		return true;
	}
	
}

