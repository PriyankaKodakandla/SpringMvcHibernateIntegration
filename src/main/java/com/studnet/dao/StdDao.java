package com.studnet.dao;

import java.util.List;
import com.student.model.Student;



public interface StdDao {
	public int insertStd(Student std);
	public int modifyStd(Student std);
	public Student search(int std_id);
	public int delete(int id); 
	public Student getObject(int id);
	public List<Student> listAll();
	
}
