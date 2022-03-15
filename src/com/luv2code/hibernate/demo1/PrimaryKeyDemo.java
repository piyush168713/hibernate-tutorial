// code is totally same as CreateStudentDemo class
// File 2

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create 3 student objects
            System.out.println("Create 3 student objects...");
            Student tempStudent1 = new Student("Piyush", "Kumar", "piyush@luv2code.com");
            Student tempStudent2 = new Student("Shivanshu", "Sharma", "shiv@luv2code.com");
            Student tempStudent3 = new Student("Ashish", "Ranjan", "ashish@luv2code.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student Object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally{
            factory.close();
        }
    }
}
