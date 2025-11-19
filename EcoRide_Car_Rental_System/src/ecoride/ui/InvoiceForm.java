/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ecoride.ui;

import javax.swing.JOptionPane;
import ecoride.models.Booking;
import ecoride.services.EcoRideSystem;



/**
 *
 * @author Banuka
 */
public class InvoiceForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InvoiceForm.class.getName());

    /**
     * Creates new form InvoiceForm
     */
    public InvoiceForm() {
    initComponents();
    loadBookingCombo();
    clearInvoiceLabels();
        
    }

    // Load all booking IDs into the combo box
    private void loadBookingCombo() {
    cmbBooking.removeAllItems();
    if (EcoRideSystem.bookings == null || EcoRideSystem.bookings.isEmpty()) {
        cmbBooking.addItem("No bookings");
        cmbBooking.setEnabled(false);
        return;
    }
    cmbBooking.setEnabled(true);
    for (Booking b : EcoRideSystem.bookings) {
        // add only booking id 
        cmbBooking.addItem(b.getBookingId());
    }
}
   // Search for a booking object by its booking ID
    private Booking findBookingById(String id) {
    for (Booking b : EcoRideSystem.bookings) {
        if (b.getBookingId().equals(id)) {
            return b;
        }
    }
    return null;
}

    // Generate all invoice values and update UI labels
    private void generateInvoice() {
    try {
String selected = (String) cmbBooking.getSelectedItem();

if (selected == null || selected.equals("No bookings")) {
    JOptionPane.showMessageDialog(this, "Please select a booking.");
    return;
}

String bookingId = selected; 
Booking b = findBookingById(bookingId);


        if (b == null) {
            JOptionPane.showMessageDialog(this, "Booking not found!");
            return;
        }
         // SET BASIC DETAILS IN LABELS
        lblBookingId.setText(b.getBookingId());
        lblBookingDate.setText(b.getBookingDate().toString());

        lblCustomerId.setText(b.getCustomer().getCustomerId());
        lblCustomerName.setText(b.getCustomer().getName());

        lblCarId.setText(b.getVehicle().getCarId());
        lblModel.setText(b.getVehicle().getModel());
        lblCategory.setText(b.getVehicle().getCategory());
        lblDailyRate.setText(String.valueOf(b.getVehicle().getDailyRate()));

        lblRentalDate.setText(b.getRentalDate().toString());
        lblRentalDays.setText(String.valueOf(b.getRentalDays()));
        lblTotalKm.setText(String.valueOf(b.getTotalKm()));

        
        // CALCULATION SECTION
int days = b.getRentalDays();
int totalKm = b.getTotalKm();
String category = b.getVehicle().getCategory();
double dailyRate = b.getVehicle().getDailyRate(); // double from Vehicle

// calculation parameters
int freeKm = 0;
int extraKmCharge = 0;
double taxRate = 0.0;

switch (category) {
    case "Compact Petrol":
        freeKm = 100; extraKmCharge = 50; taxRate = 0.10; break;
    case "Hybrid":
        freeKm = 150; extraKmCharge = 60; taxRate = 0.12; break;
    case "Electric":
        freeKm = 200; extraKmCharge = 40; taxRate = 0.08; break;
    case "Luxury SUV":
        freeKm = 250; extraKmCharge = 75; taxRate = 0.15; break;
}

// Use double for money calculations
double basePrice = dailyRate * days;

int totalFreeKm = freeKm * days;
int extraKm = Math.max(0, totalKm - totalFreeKm);
int extraKmCost = extraKm * extraKmCharge; // int is fine here

double discount = (days >= 7) ? basePrice * 0.10 : 0.0;

double tax = (basePrice - discount + (double)extraKmCost) * taxRate;

int deposit = 5000;

double finalAmount = basePrice - discount + (double)extraKmCost + tax - deposit;

// UPDATE UI LABELS WITH VALUES
lblDailyRate.setText(String.format("%.2f", dailyRate));
lblBasePrice.setText(String.format("%.2f", basePrice));
lblExtraKmCharge.setText(String.format("%.2f", (double)extraKmCost));
lblDiscount.setText(String.format("%.2f", discount));
lblTax.setText(String.format("%.2f", tax));
lblDeposit.setText(String.format("%.2f", -(double)deposit));
lblFinalAmount.setText(String.format("%.2f", finalAmount));



    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error generating invoice.");
    }
}
    // Reset all labels to default value "__"
    private void clearInvoiceLabels() {
    lblBookingId.setText("__");
    lblBookingDate.setText("__");
    lblCustomerId.setText("__");
    lblCustomerName.setText("__");
    lblCarId.setText("__");
    lblModel.setText("__");
    lblCategory.setText("__");
    lblDailyRate.setText("__");
    lblRentalDate.setText("__");
    lblRentalDays.setText("__");
    lblTotalKm.setText("__");
    lblBasePrice.setText("__");
    lblFreeKm.setText("__");
    lblExtraKm.setText("__");
    lblExtraKmCharge.setText("__");
    lblDiscount.setText("__");
    lblTax.setText("__");
    lblDeposit.setText("__");
    lblFinalAmount.setText("__");
}

    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSelect = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbBooking = new javax.swing.JComboBox<>();
        btnGenerate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblBookingId = new javax.swing.JLabel();
        lblBookingDate = new javax.swing.JLabel();
        lblCustomerId = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblCarId = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblDailyRate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblRentalDate = new javax.swing.JLabel();
        lblRentalDays = new javax.swing.JLabel();
        lblTotalKm = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblFreeKm = new javax.swing.JLabel();
        lblExtraKm = new javax.swing.JLabel();
        lblExtraKmCharge = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        lblTax = new javax.swing.JLabel();
        lblDeposit = new javax.swing.JLabel();
        lblFinalAmount = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblBasePrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("InvoiceForm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Booking");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblSelect.setBackground(new java.awt.Color(102, 102, 102));
        lblSelect.setForeground(new java.awt.Color(255, 255, 255));
        lblSelect.setText("_");
        jPanel1.add(lblSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 100, -1));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Booking ID =");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        cmbBooking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBookingActionPerformed(evt);
            }
        });
        jPanel1.add(cmbBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        btnGenerate.setText("Load Invoice");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Booking ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Booking Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Customer ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Customer Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lblBookingId.setBackground(new java.awt.Color(102, 102, 102));
        lblBookingId.setForeground(new java.awt.Color(255, 255, 255));
        lblBookingId.setText("__");
        jPanel1.add(lblBookingId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 70, -1));

        lblBookingDate.setBackground(new java.awt.Color(102, 102, 102));
        lblBookingDate.setForeground(new java.awt.Color(255, 255, 255));
        lblBookingDate.setText("__");
        jPanel1.add(lblBookingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 80, -1));

        lblCustomerId.setBackground(new java.awt.Color(102, 102, 102));
        lblCustomerId.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomerId.setText("__");
        jPanel1.add(lblCustomerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 90, -1));

        lblCustomerName.setBackground(new java.awt.Color(102, 102, 102));
        lblCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomerName.setText("__");
        jPanel1.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, -1));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Booking Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vehicle Details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Car ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Model");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Category");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Daily Rate");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        lblCarId.setBackground(new java.awt.Color(102, 102, 102));
        lblCarId.setForeground(new java.awt.Color(255, 255, 255));
        lblCarId.setText("__");
        jPanel1.add(lblCarId, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 70, -1));

        lblModel.setBackground(new java.awt.Color(102, 102, 102));
        lblModel.setForeground(new java.awt.Color(255, 255, 255));
        lblModel.setText("__");
        jPanel1.add(lblModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 70, -1));

        lblCategory.setBackground(new java.awt.Color(102, 102, 102));
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblCategory.setText("__");
        jPanel1.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 90, -1));

        lblDailyRate.setBackground(new java.awt.Color(102, 102, 102));
        lblDailyRate.setForeground(new java.awt.Color(255, 255, 255));
        lblDailyRate.setText("__");
        jPanel1.add(lblDailyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 90, -1));

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Rental Summary");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Rental Start");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Rental Days");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total KM Used");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        lblRentalDate.setBackground(new java.awt.Color(102, 102, 102));
        lblRentalDate.setForeground(new java.awt.Color(255, 255, 255));
        lblRentalDate.setText("__");
        jPanel1.add(lblRentalDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 90, -1));

        lblRentalDays.setBackground(new java.awt.Color(102, 102, 102));
        lblRentalDays.setForeground(new java.awt.Color(255, 255, 255));
        lblRentalDays.setText("__");
        jPanel1.add(lblRentalDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 90, -1));

        lblTotalKm.setBackground(new java.awt.Color(102, 102, 102));
        lblTotalKm.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalKm.setText("__");
        jPanel1.add(lblTotalKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 80, -1));

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Calculation Breakdown");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Base Price");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Free KM Allocated");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Extra KM");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Extra KM Charge");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        jLabel23.setBackground(new java.awt.Color(102, 102, 102));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Discount");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tax");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Deposit Deducted");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, -1, -1));

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Final Amount");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 590, 80, 20));

        lblFreeKm.setBackground(new java.awt.Color(102, 102, 102));
        lblFreeKm.setForeground(new java.awt.Color(255, 255, 255));
        lblFreeKm.setText("__");
        jPanel1.add(lblFreeKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 80, -1));

        lblExtraKm.setBackground(new java.awt.Color(102, 102, 102));
        lblExtraKm.setForeground(new java.awt.Color(255, 255, 255));
        lblExtraKm.setText("__");
        jPanel1.add(lblExtraKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 80, -1));

        lblExtraKmCharge.setBackground(new java.awt.Color(102, 102, 102));
        lblExtraKmCharge.setForeground(new java.awt.Color(255, 255, 255));
        lblExtraKmCharge.setText("__");
        jPanel1.add(lblExtraKmCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 90, -1));

        lblDiscount.setBackground(new java.awt.Color(102, 102, 102));
        lblDiscount.setForeground(new java.awt.Color(255, 255, 255));
        lblDiscount.setText("__");
        jPanel1.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 90, -1));

        lblTax.setBackground(new java.awt.Color(102, 102, 102));
        lblTax.setForeground(new java.awt.Color(255, 255, 255));
        lblTax.setText("__");
        jPanel1.add(lblTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 90, -1));

        lblDeposit.setBackground(new java.awt.Color(102, 102, 102));
        lblDeposit.setForeground(new java.awt.Color(255, 255, 255));
        lblDeposit.setText("__");
        jPanel1.add(lblDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 120, -1));

        lblFinalAmount.setBackground(new java.awt.Color(102, 102, 102));
        lblFinalAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblFinalAmount.setText("___");
        jPanel1.add(lblFinalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 100, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        lblBasePrice.setBackground(new java.awt.Color(102, 102, 102));
        lblBasePrice.setForeground(new java.awt.Color(255, 255, 255));
        lblBasePrice.setText("__");
        jPanel1.add(lblBasePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookingActionPerformed
            String sel = (String) cmbBooking.getSelectedItem();
    if (sel == null || sel.equals("No bookings")) {
        lblSelect.setText("_");
    } else {
        lblSelect.setText(sel);
    }
    }//GEN-LAST:event_cmbBookingActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        generateInvoice();

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Dashboard().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InvoiceForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JComboBox<String> cmbBooking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBasePrice;
    private javax.swing.JLabel lblBookingDate;
    private javax.swing.JLabel lblBookingId;
    private javax.swing.JLabel lblCarId;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCustomerId;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDailyRate;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblExtraKm;
    private javax.swing.JLabel lblExtraKmCharge;
    private javax.swing.JLabel lblFinalAmount;
    private javax.swing.JLabel lblFreeKm;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblRentalDate;
    private javax.swing.JLabel lblRentalDays;
    private javax.swing.JLabel lblSelect;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblTotalKm;
    // End of variables declaration//GEN-END:variables
}
