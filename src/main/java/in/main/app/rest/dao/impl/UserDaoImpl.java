package in.main.app.rest.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.main.app.rest.dao.IUserDao;
import in.main.app.rest.entity.User;
import in.main.app.rest.service.impl.UserServiceImpl;
import in.main.app.util.DocLogger;

@Repository
@org.springframework.transaction.annotation.Transactional
public class UserDaoImpl implements IUserDao {

	final static String className = UserServiceImpl.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public User saveUser(User user) {
		logD("saveUser(User user)-->" + user.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			Integer id=(Integer) session.save(user);
			user.setId(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		logD("getUserList()");
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
//			currentSession.beginTransaction();
			// create a query ... sort by last name
			Query theQuery = currentSession.createSQLQuery("from User order by first_name");

			// execute query and get result list
			List<User> users = theQuery.list();

			// return the results
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	@Transactional
	public User getUser(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
//			currentSession.beginTransaction();
			// now retrieve/read from database using the primary key
			User theUser = (User) currentSession.get(User.class, id);
			return theUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public User getUser(String email, String mobileNo) {
		logD("getUser(" + email + "," + mobileNo + "");
		Session session = sessionFactory.getCurrentSession();
		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			criteria.select(root);
			Predicate userPredicate = builder.and(builder.equal(root.get("email"), email)
			    ,builder.equal( root.get("mobileNo"),mobileNo )
			);
			criteria.where(userPredicate);
//			session.beginTransaction();
			List<User> userList = session.createQuery(criteria).getResultList();

			logD("user list size: " + userList.size());
			if (userList == null || userList.size() == 0) {
				return null;
			}

			return userList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// delete object with primary key
			Query theQuery = currentSession.createQuery("delete from User where id=:_id");
			theQuery.setParameter("_id", id);

			theQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	@Transactional
	public User getUser(String username, String email, String mobileNo, String password) {
		logD("getUser(" + username + "," + email + "," + mobileNo + "," + password + ")");
		Session session = sessionFactory.getCurrentSession();
		try {
//			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			criteria.select(root); 
			//below are field names not column names
			Predicate userPredicate = builder.and(builder.equal(root.get("email"), email),
					builder.equal(root.get("mobileNo"), mobileNo), builder.equal(root.get("userName"), username),
					builder.equal(root.get("password"), password));
			criteria.where(userPredicate);
			
			List<User> userList = session.createQuery(criteria).getResultList();
			logD("user list size: " + userList.size());
			if (userList == null || userList.size() == 0) {
				return null;
			}

			return userList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}
