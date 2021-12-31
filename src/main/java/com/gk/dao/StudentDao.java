package com.gk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gk.config.Config;
import com.gk.model.Student;


@Component
public class StudentDao {
	@Autowired
	private Config jdbcTemplate;

	public List<Student> getdata() {
		String sql = "select*from student";
		List<Student> stlist = jdbcTemplate.getJdbcTemplate().query(sql, (rs, rowNum) -> {
			Student c = new Student();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setAddress(rs.getString(3));
			return c;
		});
		return stlist;
	}

	public void saveData(Student st) {
		jdbcTemplate.getJdbcTemplate().update("insert into student(id,name,address) value(?,?,?)", st.getId(),
				st.getName(), st.getAddress());
	}

	public void deleteData(int id) {
		String sql = "delete from student where id=?";
		jdbcTemplate.getJdbcTemplate().update(sql, id);

	}

	public void updateData(Student st) {
		jdbcTemplate.getJdbcTemplate().update("update student set name = ? , address=? where id = ?", st.getName(),
				st.getAddress(), st.getId());

	}

}
