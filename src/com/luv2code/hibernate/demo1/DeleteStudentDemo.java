// code is totally same as UpdateStudentDemo class
// File 6


package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 2;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key.    i.e. primary key -> tempStudent.getID()
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            // delete the student
            // System.out.println("Deleting student: " + myStudent);
            // session.delete(myStudent);

            // delete student id=2
            System.out.println("Delete student id=2:");
            session.createQuery("delete from Student where id=7").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally{
            factory.close();
        }
    }
}
