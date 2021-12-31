package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.StudentDao;
import com.gk.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public List<Student> getData() {
		return studentDao.getdata();
	}

	public void savedata(Student st) {

		studentDao.saveData(st);
	}

	public void deletedata(int id) {
		studentDao.deleteData(id);

	}

	public void updateData(Student st) {
		studentDao.updateData(st);

	}

}
