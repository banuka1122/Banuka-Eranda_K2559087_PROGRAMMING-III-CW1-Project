/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecoride.models;


   import java.time.LocalDate;

/**
 *
 * @author Banuka
 */
public class Booking {
    
    private String bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate bookingDate;  // date customer books
    private LocalDate rentalDate;   // date rental starts
    private int rentalDays;
    private int totalKm;

    public Booking(String bookingId, Customer customer, Vehicle vehicle,
                   LocalDate bookingDate, LocalDate rentalDate,
                   int rentalDays, int totalKm) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        this.totalKm = totalKm;
    }

    // Getters & Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(int totalKm) {
        this.totalKm = totalKm;
    }
}
