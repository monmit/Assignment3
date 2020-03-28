package com.techstack.monica.service;

import com.techstack.monica.dao.StudentDAO;
import com.techstack.monica.domain.Student;

import java.util.List;

public class StudentService {
    StudentDAO studentdao = new StudentDAO();
    InputOutputImpl inputOutputService = new InputOutputImpl();

    public void addStudent() {
        try{
            Student input = inputOutputService.getStudentDetails();
            List<Student> students = studentdao.getStudents();
            boolean rollNumberAlreadyExists = rollNumberAlreadyExists(students, input.getRollNumber());
            if(rollNumberAlreadyExists) {
                System.out.println("Roll number already exists");
            } else {
                studentdao.add(input);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean rollNumberAlreadyExists(List<Student> studentsFromDB, Integer inputRollNumber) {
        for (Student s : studentsFromDB) {
            int rollNumbersFromDB = s.getRollNumber();
            if (inputRollNumber == rollNumbersFromDB){
                return true;
            }
        }

        return false;
    }

    public void addStudent1() {
        try{
            Student input = inputOutputService.getStudentDetails();
            Student studentFromDB = studentdao.getStudentByRollNumber(input.getRollNumber());
            if(studentFromDB == null) {
                studentdao.add(input);
            } else {
                System.out.println("Student with this rollNumber already exists.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent (int rollNumber){
        try {
            studentdao.delete(rollNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
