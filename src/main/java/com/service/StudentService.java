package com.service;

import com.entity.Student;
import com.repository.StudentRepository;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class StudentService {
    private final StudentRepository studentRepository=new StudentRepository();
    private final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public void insert(){
        Student student=new Student();
//        System.out.println("--------Insertion Operation---------");
        System.out.print("\t\tEnter new  id: ");
        student.setsId(Integer.parseInt(br.readLine()));
        System.out.print("\n\t\tEnter name: ");
        student.setsName(br.readLine());
        System.out.print("\n\t\tEnter email: ");
        student.setsEmail(br.readLine());
        System.out.print("\n\t\tEnter gender type M for 'Male' and F for 'female' : ");
        student.setsGender(br.readLine().charAt(0));
        System.out.print("\n\t\tEnter class: ");
        student.setsClass(Integer.parseInt(br.readLine()));
        studentRepository.insert(student);
        System.out.println("-----------data inserted successfully-------------");
    }

    @SneakyThrows
    public void updateNameById(){
        System.out.print("Enter your id : ");
        String sId=br.readLine();
        System.out.print("Enter the name to be updated: ");
        String sName=br.readLine();
        if(studentRepository.updateNameById(sId,sName)){
            System.out.println("\t\t\t\tUpdation done ):");
        }
    }
    @SneakyThrows
    public void findById(){
        System.out.print("Enter the id: ");
        System.out.println("\n"+studentRepository.findById(br.readLine()));
    }

    @SneakyThrows
    public void findByName(){
        System.out.print("Enter the name : ");
        List<Student> studentList=studentRepository.findByName(br.readLine());
        studentList.forEach(System.out::println);
    }

    public void findAll(){
        List<Student> studentList=studentRepository.findAll();
        studentList.forEach(System.out::println);
    }

    @SneakyThrows
    public void deleteById(){
        System.out.print("Enter the id : ");
        if(studentRepository.deleteById(br.readLine())){
            System.out.println("----- Successfully deleted -----");
        }else{
            System.out.println("Id not found !");
        }

    }
}
