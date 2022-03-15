// code is totally same as CreateStudentDemo class
// File 4

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
                               // we use Student class i.e. "from Student"

            // display the students
            /*for (Student tempStudent: theStudents){
                System.out.println(tempStudent);
            }*/
            theStudents.forEach(System.out::println);


            // query students: lastName='Ranjan'
            theStudents = session.createQuery("from Student s where s.lastName='Ranjan'").getResultList();

            // display the students
            System.out.println("\n\nStudent who have last name of Ranjan:");
            theStudents.forEach(System.out::println);        // another mtd to print output


            // query students: lastName='Sharma' OR firstName='Shivanshu'
            theStudents = session.createQuery("from Student s where" + " s.lastName='Sharma' OR s.firstName='Shivanshu'").getResultList();

            // display the students
            System.out.println("\n\nStudent who have last name of Sharma and first name of Shivanshu:");
            theStudents.forEach(System.out::println);


            // query students where email LIKE '%@luv2code.com'
            theStudents = session.createQuery("from Student s where" + " s.email LIKE '%luv2code.com'").getResultList();

            // display the students
            System.out.println("\n\nStuents who email ends with luv2code.com:");
            theStudents.forEach(System.out::println);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally{
            factory.close();
        }
    }
}
