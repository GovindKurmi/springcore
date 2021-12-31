package com.gk.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gk.config.Config;
import com.gk.model.Student;
import com.gk.service.StudentService;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Config.class);
		StudentService service = context.getBean(StudentService.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number 1 to 4" + "\n 1. Fetch" + "\n 2. Save" + "\n 3. Delete" + "\n 4. Update");
		int flag = sc.nextInt();
		if (flag == 1) {
			System.out.println("Fetch data Successfully");
			List<Student> st = service.getData();
			st.stream().forEach(s -> System.out.println(s));
		} else if (flag == 2) {
			System.out.println("save data Successfully");
			Student st = new Student();
			st.setId(4);
			st.setName("manak");
			st.setAddress("bhopal");
			service.savedata(st);
		} else if (flag == 3) {
			System.out.println("Delete data Successfully");

			int id = 4;
			service.deletedata(id);
		} else if (flag == 4) {
			System.out.println("Update data Successfully");

			Student st = new Student();
			st.setId(4);
			st.setName("ranesh");
			st.setAddress("bhopal");
			service.updateData(st);
		}
	}
}
