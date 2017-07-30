package com.stdiosoft.dao;

import com.stdiosoft.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ExampleDAO {
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session sf = getSession();
		List<User> listUser = (List<User>) sf
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	public void closeSession(Session _session){
		_session.clear();
		_session.close();
	}
}