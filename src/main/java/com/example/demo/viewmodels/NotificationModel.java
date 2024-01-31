package com.example.demo.viewmodels;

public class NotificationModel {
    private CarInsuranceDTO carInsuranceDTO;

//    public String sendMessage(){
//        return String.format("Your %s is expiring %s, please contact %s %s, phone number: %d",
//                carInsuranceDTO.getLicensePlate(), carInsuranceDTO.getEndDate().toString(),
//                carInsuranceDTO.getCtName(), carInsuranceDTO.getCtLastname(),
//                carInsuranceDTO.getCtPhone());
//    }

    public void setInsuranceDTO(CarInsuranceDTO carInsuranceDTO) {
        this.carInsuranceDTO = carInsuranceDTO;
    }
}