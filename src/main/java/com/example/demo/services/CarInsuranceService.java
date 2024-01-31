package com.example.demo.services;

import com.example.demo.entities.CarInsurance;
import com.example.demo.entities.Client;
import com.example.demo.models.CarInsuranceDTO;
import com.example.demo.repositories.CarInsuranceRepository;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarInsuranceService {
    private final CarInsuranceRepository carInsuranceRepository;
    private final ClientRepository clientRepository;
    //todo maskowanie id clienta
    @Autowired
    public CarInsuranceService(CarInsuranceRepository carInsuranceRepository, ClientRepository clientRepository) {
        this.carInsuranceRepository = carInsuranceRepository;
        this.clientRepository = clientRepository;
    }

    public CarInsuranceDTO addInsurance(CarInsuranceDTO carInsurance) {
        Client client = clientRepository.findById(carInsurance.getClient()).orElse(new Client());
        carInsuranceRepository.save(CarInsurance.toEntity(carInsurance, client));
        return carInsurance;
    }

    public List<CarInsuranceDTO> getAll() {
        return carInsuranceRepository.findAll()
                .stream()
                .map(CarInsuranceDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarInsuranceDTO> getAllByName(String name) {
        return (List<CarInsuranceDTO>) carInsuranceRepository.findCarInsuranceByName(name)
                .stream()
                .map(CarInsuranceDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarInsuranceDTO> getEndDateInsurance(String name) {
        List<CarInsurance> carInsurances = (List<CarInsurance>) carInsuranceRepository.findCarInsuranceByName(name);
        return carInsurances
                .stream()
                .filter(carInsurance ->
                        carInsurance
                                .getEndDate()
                                .isBefore(LocalDate.now()
                                        .plusMonths(1)))
                .map(CarInsuranceDTO::toDTO)
                .collect(Collectors.toList());
    }
}
