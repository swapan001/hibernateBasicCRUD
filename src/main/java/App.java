import com.entity.Student;
import com.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLOutput;
import java.util.Scanner;

public class App {

    static StudentService studentService=new StudentService();
    private static void crudOperation(){


        final Scanner sc=new Scanner(System.in);

        boolean bool=true;
        while(bool){
            System.out.println("\n\t\tpress 1 for Insert\n\t\tpress 2 for update name by id\n\t\tpress 3 for find by name\n\t\tpress 4 for find by id\n\t\tpress 5 for findAll\n\t\tpress 6 for delete by id\n\t\tpress 0 for Exit");
            System.out.print("\nEnter your option: ");
            int option=sc.nextInt();
            switch (option) {
                case 1 -> {
                    studentService.insert();
                }
                // Insert operation
                case 2 -> {
                    studentService.updateNameById();
                }
                // Update by id operation
                case 3 -> {
                    studentService.findByName();
                }
                // Find by name operation
                case 4 -> {
                    studentService.findById();

                }
                // Find by id operation
                case 5 -> {
                    studentService.findAll();
                }
                // Find all Student Data
                case 6 -> {
                    studentService.deleteById();
                }
                // Delete by id operation
                case 0 -> {
                    // Exit operation
                    System.out.println("Thank-you for using our Applications ):");
                    bool = false;
                }
                default -> System.out.println("Please select a correct option!");
            }
        }

    }
    public static void main(String[] args) {
            crudOperation();
    }
}
