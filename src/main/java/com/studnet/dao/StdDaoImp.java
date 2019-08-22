package com.studnet.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StdDaoImp implements StdDao {
	@Autowired
	SessionFactory sessionFactory;
	Student student;
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  

	public int insertStd(Student std) {
		Session session = sessionFactory.openSession();

		Transaction trnx = session.beginTransaction();

		int primary = (Integer) session.save(std);

		System.out.println("primary = " + primary);

		trnx.commit();

		session.close(); 

		return primary;
	}

	public int modifyStd(Student student) {
		// TODO Auto-generated method stub
		/*
		 * HttpServletRequest request = null;
		 * 
		 * Session session = sessionFactory.openSession(); Transaction trnx =
		 * session.beginTransaction(); int id=Integer.parseInt(test.get("id"));
		 * System.out.println(id); Query query =
		 * session.createQuery("update dbtesting.STUDENT s set"+" NAME =:name"
		 * +"Branch=:branch"+"PHONENO=:phoneNo"+"ADDRESS=:address" + " where ID = :id");
		 * query.setParameter("branch", test.get("branch")); query.setParameter("name",
		 * test.get("name")); query.setParameter("address", test.get("address"));
		 * query.setParameter("phoneNo", test.get("phoneNO")); int result =
		 * query.executeUpdate(); return result;
		 */
		Session session = null;
		session = sessionFactory.openSession();

		Transaction trnx = session.beginTransaction();
	 
	 
		session.update(student);
		session.flush();
		trnx.commit();
		
		 
		session.close();
		 
		return 0;
	}

	public Student search(int std_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		//Transaction trnx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", std_id));

		Student student = (Student) criteria.uniqueResult();
		return student;
	}
	 public int delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("enterd");
		Session session = sessionFactory.openSession();

		Transaction trnx = session.beginTransaction();
		String sql = "Delete from dbtesting.Student where id=:id";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("id", id);
		int flg = query.executeUpdate();
		trnx.commit();
		return flg;
	}

	@SuppressWarnings("unchecked")
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		List<Student> list = new ArrayList();

		Query query = session.createQuery("from Student");

		list = query.list();

		session.close();

		return list;
	}

	public Student getObject(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		session = sessionFactory.openSession();
		
		Student student =   (Student) session.get(Student.class, id);
		
		return student;
	}





}
