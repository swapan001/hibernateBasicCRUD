package com.repository;

import com.entity.Student;

import javax.persistence.*;
import java.util.List;

public class StudentRepository {
// It is for DataBase Related Logics
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernateBasicCRUD");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();


    public void insert(Student student){
        et.begin();
        em.persist(student);
        et.commit();
    }

    public boolean updateNameById(String sId,String sName){
        Student student=findById(sId);
        if(student!=null){
            student.setsName(sName);
            et.begin();
            em.merge(student);
            et.commit();
            return true;
        }
        return false;
    }

    public Student findById(String sId){

        return em.find(Student.class,sId);
    }
    public List<Student> findByName(String sName){
        String findByName="Select s from Student s where LOWER(s.sname) = LOWER(:sname)";
        TypedQuery<Student> query=em.createQuery(findByName,Student.class);
        query.setParameter("sname",sName);
        return query.getResultList();
    }


    public List<Student> findAll(){
        String findAll="Select s from Student s";
        TypedQuery<Student> query=em.createQuery(findAll,Student.class);
        return query.getResultList();
    }

    public boolean deleteById(String sId){
        Student student=findById(sId);
        if(student != null){
            et.begin();
            em.remove(student);
            et.commit();
            return true;
        }

        return false;
    }









}
