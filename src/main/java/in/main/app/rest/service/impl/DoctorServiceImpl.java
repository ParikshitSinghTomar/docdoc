package in.main.app.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.app.rest.constants.Constants;
import in.main.app.rest.constants.Constants.ErrorResponseCode;
import in.main.app.rest.constants.Constants.SuccessResponseCode;
import in.main.app.rest.dao.IDoctorDao;
import in.main.app.rest.dao.IUserDao;
import in.main.app.rest.entity.Doctor;
import in.main.app.rest.entity.DoctorExprience;
import in.main.app.rest.entity.DoctorQulification;
import in.main.app.rest.requet.model.DocExperience;
import in.main.app.rest.requet.model.DocQulification;
import in.main.app.rest.requet.model.DoctorLoginRequest;
import in.main.app.rest.requet.model.DoctorRegistration;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService{

	
	@Autowired
	IDoctorDao doctorDao;
	
	@Autowired
	IUserDao userDao;
	
	@Override
	public BaseResponse registerDoctor(DoctorRegistration doctorRegistration) {
		
		BaseResponse baseResponse=new BaseResponse();
		baseResponse.setCode(ErrorResponseCode.DOC_REGISTRATION_JSON_VALIDATION_FAILED);
		baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.DOC_REGISTRATION_JSON_VALIDATION_FAILED));
		baseResponse.setStatus(false);
		if(doctorRegistration==null) {
			return baseResponse;
		}
		
		StringBuilder errors =validateDoctorBasicInfo(doctorRegistration);
		if(errors!=null) {
			baseResponse.setData(errors.toString());
			return baseResponse;
		}
		
		if(doctorDao.isDocAlreadyExist(doctorRegistration.getEmail())) {
			baseResponse.setCode(ErrorResponseCode.DOC_REGISTRATION_FAILED_ALREADY_EXIT);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.DOC_REGISTRATION_FAILED_ALREADY_EXIT));
			return baseResponse;
		}
		
		Doctor doctor=new Doctor();
		doctor.setEmail(doctorRegistration.getEmail());
		doctor.setFirstName(doctorRegistration.getFirst_name());
		doctor.setLastName(doctorRegistration.getLast_name());
		doctor.setPrimaryPhoneNo(doctorRegistration.getPrimary_phone_no());
		doctor.setSecondryPhoneNo(doctorRegistration.getSecondory_phone_no());	
		doctor=doctorDao.saveAndMerge(doctor);
		if(doctor==null) {
			baseResponse.setMessage("Not able to save doctor in Database.");
			return baseResponse;
		}
			
		/*
		 * Doctor should have atleast one qualification
		 */
		List<DocQulification> docQulifications=doctorRegistration.getQualifications();
		if(docQulifications==null||docQulifications.size()==0) {
			baseResponse.setMessage(Constants.getMessage(Constants.ErrorResponseCode.DOC_QULIFICATION_CAN_NOT_NULL));
			baseResponse.setCode(Constants.ErrorResponseCode.DOC_QULIFICATION_CAN_NOT_NULL);
			return baseResponse;
		}
		
		for(DocQulification docQulification:docQulifications) {
			DoctorQulification doctorQulification=new DoctorQulification();
			doctorQulification.setDoctor_id(doctor.getId());
			doctorQulification.setCity(docQulification.getCity());
			doctorQulification.setInstitute(docQulification.getInstitute());
			doctorQulification.setName_of_degree(docQulification.getName());
			doctorQulification.setPassing_year(docQulification.getPassing_year());
			
			doctorDao.saveAndMergeDocQulification(doctorQulification);
		}
		
		List<DocExperience> docExperiences=doctorRegistration.getExpriences();
		for(DocExperience docExperience:docExperiences) {
			DoctorExprience doctorExprience=new DoctorExprience();
			doctorExprience.setDoctor_id(doctor.getId());
			doctorExprience.setCity(docExperience.getCity());
			doctorExprience.setCurrent_working(1);
			doctorExprience.setEnd_date(docExperience.getEnd_date());
			doctorExprience.setStart_date(docExperience.getStart_date());
			doctorExprience.setOrgranization_name(docExperience.getOrgranization_name());
			doctorExprience.setState(docExperience.getState());
			doctorExprience=doctorDao.saveAndMergeDocExperience(doctorExprience);
		}
		
		baseResponse.setStatus(true);
		baseResponse.setCode(Constants.SuccessResponseCode.DOCTOR_REGISTRATION_DONE);
		baseResponse.setMessage(Constants.getMessage(Constants.SuccessResponseCode.DOCTOR_REGISTRATION_DONE));		
		return baseResponse;
		
	}
	
	private static StringBuilder validateDoctorBasicInfo(DoctorRegistration doctorRegistration) {
		return null;
	}

	@Override
	public BaseResponse loginDoctor(DoctorLoginRequest doctorLoginRequest) {
		BaseResponse baseResponse=new BaseResponse();
		baseResponse.setCode(ErrorResponseCode.DOC_REGISTRATION_JSON_VALIDATION_FAILED);
		baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.DOC_REGISTRATION_JSON_VALIDATION_FAILED));
		baseResponse.setStatus(false);
		if(doctorLoginRequest==null) {
			return baseResponse;
		}
		String errors=validateDocLoginRequest(doctorLoginRequest);
		if(errors!=null) {
			baseResponse.setData(errors);
			return baseResponse;
		}
		
		Doctor doctor=doctorDao.isValidDoctor(doctorLoginRequest);
		if(doctor==null) {
			baseResponse.setCode(ErrorResponseCode.DOC_LOGIN_FAILED);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.DOC_LOGIN_FAILED));
		}
		baseResponse.setData(doctor);
		baseResponse.setStatus(true);
		baseResponse.setMessage(Constants.getMessage(SuccessResponseCode.VALID_DOC));
		baseResponse.setCode(SuccessResponseCode.VALID_DOC);
		return baseResponse;
	}
	
	private static String validateDocLoginRequest(DoctorLoginRequest doctorLoginRequest) {
		
		return null;
	}

}
