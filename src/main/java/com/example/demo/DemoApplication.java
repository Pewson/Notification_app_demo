package com.example.demo;

import com.example.demo.entities.Client;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Manager;
import com.example.demo.entities.UserCreds;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
@EntityScan(basePackages = "com.example.demo.entities")
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(CarInsuranceRepository carInsuranceRepository,
                                        ManagerRepository managerRepository,
                                        EmployeeRepository employeeRepository,
                                        ClientRepository clientRepository,
                                        UserCredsRepository userCredsRepository,
                                        PasswordEncoder encoder) {
        return args -> {
            UserCreds managerCreds = userCredsRepository
                    .save(new UserCreds("manager@Test.com",
                            "manager", encoder.encode("password")));
            UserCreds employeeCreds = userCredsRepository.save(new UserCreds("employee@Test.com", "employee", encoder.encode("password")));
            UserCreds clientCreds = userCredsRepository.save(new UserCreds("client@Test.com", "client", encoder.encode("password")));
            Manager manager = managerRepository.save(new Manager("Manager", "Test", 12312312, "Manager@Test.com",
                    managerCreds, null, null));
            Employee employee = employeeRepository.save(new Employee("Employee", "Test", 2322423, "Employee@Test.com",
                    employeeCreds, manager, null));
            clientRepository.save(new Client("Client", "Test",
                    1234123, "client@Test.com", employeeCreds,
                    "Wypizdow", "Droga do wypizdowa 12", null, employee,
                    manager, clientCreds));
        };
    }

}
