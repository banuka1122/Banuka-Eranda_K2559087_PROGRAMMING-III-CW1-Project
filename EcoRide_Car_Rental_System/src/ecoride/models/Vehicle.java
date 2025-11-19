/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecoride.models;

/**
 *
 * @author Banuka
 */
public class Vehicle {
        
    private String carId;
    private String model;
    private String category;
    private double dailyRate;
    private String status; // Available / Reserved / Under Maintenance

    public Vehicle(String carId, String model, String category, double dailyRate, String status) {
        this.carId = carId;
        this.model = model;
        this.category = category;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    // Getters and Setters
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
