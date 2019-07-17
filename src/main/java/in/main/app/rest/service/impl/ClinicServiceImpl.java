package in.main.app.rest.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.app.rest.constants.Constants;
import in.main.app.rest.constants.Constants.ErrorResponseCode;
import in.main.app.rest.dao.IClinicDao;
import in.main.app.rest.entity.Clinic;
import in.main.app.rest.entity.ClinicAddress;
import in.main.app.rest.entity.ClinicPhotos;
import in.main.app.rest.requet.model.ClinicRegistrationRequest;
import in.main.app.rest.response.model.BaseResponse;
import in.main.app.rest.service.IClinicService;
import in.main.app.util.DocLogger;

@Service
public class ClinicServiceImpl implements IClinicService {

	final static String className = ClinicServiceImpl.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}
	
	@Autowired
	IClinicDao clinicDao;

	@Override
	@Transactional
	public BaseResponse registerClinic(ClinicRegistrationRequest clinicRegistrationRequest) {
		logD(clinicRegistrationRequest.toString());
		BaseResponse baseResponse = new BaseResponse();

		ArrayList<String> errors = validateClinicRegistrationRequest(clinicRegistrationRequest);
		logD(errors.toString());
		if (errors.size() != 0) {
			String errorString = errors.toString();
			baseResponse.setData(errorString);
			baseResponse.setCode(Constants.ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED));
			baseResponse.setStatus(false);
		}

		ClinicAddress clinicAddress = createValidAddressEntity(clinicRegistrationRequest.getClinic_address());
		if (clinicAddress != null) {
			clinicAddress = clinicDao.registerClinicAddress(clinicAddress);
		} else {
			baseResponse.setData("Error in saving Clinic Address");
			baseResponse.setCode(Constants.ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED));
			baseResponse.setStatus(false);
			return baseResponse;
		}
		ClinicPhotos clinicPhotos = createValidPhotoEntity(clinicRegistrationRequest.getClinic_photos());
		if (clinicPhotos != null) {
			clinicPhotos = clinicDao.registerClinicPhotos(clinicPhotos);
		} else {
			baseResponse.setData("Error in saving Clinic Photos");
			baseResponse.setCode(Constants.ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED));
			baseResponse.setStatus(false);
			return baseResponse;
		}
		Clinic clinic = new Clinic();
		clinic.setClinic_name(clinicRegistrationRequest.getClinic_name());
		clinic.setClinic_owner(clinicRegistrationRequest.getClinic_owner());
		clinic.setClinicAddress(clinicAddress);
		clinic.setClinicPhotos(clinicPhotos);

		clinic = clinicDao.registerClinic(clinic);

		if (clinic == null) {
			baseResponse.setData("Error in saving Clinic Address");
			baseResponse.setCode(Constants.ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED);
			baseResponse.setMessage(Constants.getMessage(ErrorResponseCode.CLINIC_REGISTRATION_JSON_VALIDATION_FALIED));
			baseResponse.setStatus(false);
			return baseResponse;
		}

		baseResponse.setCode(Constants.SuccessResponseCode.CLINIC_REGISTRATION_SUCCESSFULLY_DONE);
		baseResponse.setMessage(Constants.getMessage(Constants.SuccessResponseCode.CLINIC_REGISTRATION_SUCCESSFULLY_DONE));
		baseResponse.setStatus(false);
		return baseResponse;
	}

	private ClinicAddress createValidAddressEntity(in.main.app.rest.requet.model.ClinicAddress clinicAddress) {
		try {
			ClinicAddress clinicAddEntity = new ClinicAddress();
			clinicAddEntity.setLine1(clinicAddress.getLine1());
			clinicAddEntity.setLine2(clinicAddress.getLine2());
			clinicAddEntity.setPincode(clinicAddress.getPincode());
			clinicAddEntity.setCity(clinicAddress.getCity());
			clinicAddEntity.setState(clinicAddress.getState());
			clinicAddEntity.setLocation(clinicAddress.getLocation().toString());
			return clinicAddEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ClinicPhotos createValidPhotoEntity(in.main.app.rest.requet.model.ClinicPhotos photos) {

		try {
			ClinicPhotos clinicPhotos = new ClinicPhotos();
			clinicPhotos.setBanner(photos.getBanner());
			clinicPhotos.setPhotos(photos.getPhotos().toString());
			return clinicPhotos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<String> validateClinicRegistrationRequest(
			ClinicRegistrationRequest clinicRegistrationRequest) {

		ArrayList<String> errors = new ArrayList<>();

		return errors;

	}

}
