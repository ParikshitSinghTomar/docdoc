package in.main.app.rest.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.main.app.rest.dao.IDoctorDao;
import in.main.app.rest.entity.Doctor;
import in.main.app.rest.entity.DoctorExprience;
import in.main.app.rest.entity.DoctorQulification;
import in.main.app.rest.entity.User;
import in.main.app.rest.requet.model.DoctorLoginRequest;
import in.main.app.util.DocLogger;

@Repository
@org.springframework.transaction.annotation.Transactional
public class DoctorDaoImpl implements IDoctorDao {

	final static String className = DoctorDaoImpl.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Doctor saveAndMerge(Doctor doctor) {
		logD("saveAndMerge(Doctor doctor)-->" + doctor.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			Integer id = (Integer) session.save(doctor);
			doctor.setId(id);
			return doctor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public DoctorQulification saveAndMergeDocQulification(DoctorQulification docQulification) {
		logD("saveAndMergeDocQulification(DocQulification docQulification)-->" + docQulification.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			Integer id = (Integer) session.save(docQulification);
			docQulification.setId(id);
			return docQulification;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public DoctorExprience saveAndMergeDocExperience(DoctorExprience docExperience) {
		logD("saveAndMergeDocExperience(DocExperience docExperience)-->" + docExperience.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			Integer id = (Integer) session.save(docExperience);
			docExperience.setId(id);
			return docExperience;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public boolean isDocAlreadyExist(String email) {
		logD("isDocAlreadyExist(String email)-->" + email);
		Session session = sessionFactory.getCurrentSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
			Root<Doctor> root = criteria.from(Doctor.class);
			criteria.select(root);
//			Projection projections=Projections.projectionList()
//				      .add(Projections.property("_id"), "_id");
//		

			Predicate userPredicate = builder.and(builder.equal(root.get("email"), email));

			criteria.where(userPredicate);
			List<Doctor> doctorList = session.createQuery(criteria).getResultList();

			logD("doc list size: " + doctorList.size());
			if (doctorList != null && doctorList.size() > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Doctor isValidDoctor(DoctorLoginRequest doctorLoginRequest) {
		logD("isValidDoctor(DoctorLoginRequest doctorLoginRequest)" + doctorLoginRequest.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
			Root<Doctor> root = criteria.from(Doctor.class);
			criteria.select(root);
			Predicate userPredicate = builder.and(
					builder.equal(root.get("email"), doctorLoginRequest.getEmail())
//					, builder.equal(root.get("primaryPhoneNo"), doctorLoginRequest.getMobileNo())
					,builder.equal(root.get("password"), doctorLoginRequest.getPassword())
					);

			criteria.where(userPredicate);
			List<Doctor> doctorList = session.createQuery(criteria).getResultList();

			logD("doc list size: " + doctorList.size());
			if (doctorList != null && doctorList.size() > 0) {
				return doctorList.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
