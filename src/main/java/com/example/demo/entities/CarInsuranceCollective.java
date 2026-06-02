package com.example.demo.entities;

import com.example.demo.baseEntities.Insurance;
import com.example.demo.viewModels.CarDescriptionModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vehicle_Fleets_Insurance")
public class CarInsuranceCollective extends Insurance {

    @Transient
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

    private String groupName;

    @Column(name="vehicle_fleet", columnDefinition = "TEXT")
    private List<String> vehicleFleet;

    public CarInsuranceCollective(Client client, LocalDate startDate,
                                  LocalDate endDate, Employee employee, BigDecimal totalCostAmount,
                                  String groupName, List<CarDescriptionModel> vehicleFleet) {
        super(client, startDate, endDate, employee, totalCostAmount);
        this.groupName = groupName;
        this.vehicleFleet = serializeVehicleFleet(vehicleFleet);
    }

    private List<String> serializeVehicleFleet(List<CarDescriptionModel> vehicleFleet) {
        List<String> serializedList = new ArrayList<>();
        for (CarDescriptionModel model : vehicleFleet) {
            try {
                serializedList.add(objectMapper.writeValueAsString(model));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error serializing CarDescriptionModel", e);
            }
        }
        return serializedList;
    }

    public List<CarDescriptionModel> getDeserializedVehicleFleet() {
        List<CarDescriptionModel> deserializedList = new ArrayList<>();
        for (String json : vehicleFleet) {
            try {
                deserializedList.add(objectMapper.readValue(json, CarDescriptionModel.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error deserializing CarDescriptionModel", e);
            }
        }
        return deserializedList;
    }

}
