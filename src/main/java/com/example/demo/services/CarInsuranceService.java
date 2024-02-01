package com.example.demo.services;

import com.example.demo.entities.CarInsurance;
import com.example.demo.entities.Client;
import com.example.demo.repositories.CarInsuranceRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.viewmodels.CarInsuranceDTO;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
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

    public CarInsuranceDTO addInsurance(CarInsurance carInsurance) {
        CarInsuranceDTO insDto = CarInsuranceDTO.toDTO(carInsuranceRepository.save(carInsurance));
        Client client = clientRepository.findClientByID(insDto.getClientId()).orElseThrow(NullPointerException::new);
        client.updateInsuranceList(carInsurance.getId());
        clientRepository.save(client);
        return insDto;
    }

    public CarInsuranceDTO updateInsurance(CarInsurance carInsurance){
        CarInsurance updatedCarInsurance = carInsuranceRepository.findCarInsuranceById(carInsurance.getId())
                .orElseThrow(NullPointerException::new);
        return CarInsuranceDTO.toDTO(carInsuranceRepository.save(updatedCarInsurance.update(carInsurance)));
    }

    public List<CarInsuranceDTO> getAll() {
        return carInsuranceRepository.findAll()
                .stream()
                .map(CarInsuranceDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarInsuranceDTO> getAllByName(UUID id) {
        return carInsuranceRepository.findCarInsuranceByClientId(id)
                .stream()
                .map(o -> o.orElse(new CarInsurance()))
                .map(CarInsuranceDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarInsuranceDTO> getEndDateInsurance(UUID id) {
        return carInsuranceRepository.findCarInsuranceByClientId(id)
                .stream()
                .map(o -> o.orElse(new CarInsurance()))
                .map(CarInsuranceDTO::toDTO)
                .filter(carInsurance ->
                        carInsurance
                                .getEndDate()
                                .isBefore(LocalDate.now()
                                        .plusMonths(1)))
                .collect(Collectors.toList());
    }
}