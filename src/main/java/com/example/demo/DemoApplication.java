package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import com.example.demo.viewModels.CarDescriptionModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
                                        CarInsuranceCollectiveRepository carInsuranceCollectiveRepository) {
        return args -> {
            UserCreds managerCreds = userCredsRepository
                    .save(new UserCreds("manager", "password"));
            UserCreds employeeCreds = userCredsRepository.save(new UserCreds("employee", "password"));
            UserCreds clientCreds = userCredsRepository.save(new UserCreds("client", "password"));
            Manager manager = managerRepository.save(new Manager("Manager", "Test", 12312312, "Manager@Test.com",
                    managerCreds, new ArrayList<>()));
            Employee employee = employeeRepository.save(new Employee("Employee", "Test", 2322423, "Employee@Test.com",
                    employeeCreds, manager, new ArrayList<>()));
            Client client = clientRepository.save(new Client(
                    "Client",
                    "Test",
                    1234123,
                    "client@Test.com",
                    clientCreds,
                    "sloneczna",
                    "Droga do slonecznej 12",
                    new ArrayList<>(),
                    1254215125,
                    "K24G2451252",
                    employee));

            CarInsurance carInsurance = carInsuranceRepository.save(new CarInsurance(
                    client,
                    "asdd",
                    LocalDate.parse("2024-12-12"),
                    LocalDate.parse("2025-12-12"),
                    employee,
                    new BigDecimal(5000),
                    "Toyota",
                    "Corolla",
                    "XYZ1111",
                    LocalDate.parse("2007-01-01"),
                    6000));


            if (manager.getEmployeeList() == null) {
                manager.setEmployeeList(new ArrayList<>());
            }
            manager.getEmployeeList().add(employee);

            if (employee.getClientList() == null) {
                employee.setClientList(List.of(client));
            }
            employee.getClientList().add(client);

            if (client.getInsuranceList() == null) {
                client.setInsuranceList(List.of(carInsurance.getId()));
            }
            client.getInsuranceList().add(carInsurance.getId());

            // Save the updated manager
            managerRepository.save(manager);
            employeeRepository.save(employee);
            clientRepository.save(client);

            List<CarDescriptionModel> vehicleFleet = new ArrayList<>();

            CarDescriptionModel car1 = new CarDescriptionModel(
                    "ABC123",
                    "Ford",
                    "Focus",
                    "1HGCM82633A123456",
                    LocalDate.parse("2015-05-20"),
                    1600
            );

            CarDescriptionModel car2 = new CarDescriptionModel(
                    "EFG1235",
                    "Audi",
                    "A5",
                    "H125A5523456",
                    LocalDate.parse("2014-02-12"),
                    3600
            );
            CarDescriptionModel car3 = new CarDescriptionModel(
                    "HIJ1235",
                    "Aston Martin",
                    "DB11",
                    "OHJAB245120ASVB",
                    LocalDate.parse("2024-01-26"),
                    4500
            );
            vehicleFleet.add(car1);
            vehicleFleet.add(car2);
            vehicleFleet.add(car3);



            CarInsuranceCollective carInsuranceCollective = carInsuranceCollectiveRepository.save(
                    new CarInsuranceCollective(
                            client,
                            LocalDate.parse("2024-11-11"),
                            LocalDate.parse("2025-11-11"),
                            employee,
                            new BigDecimal(20000),
                            "Company Fleet",
                            vehicleFleet
                    ));
        };
    }

}
