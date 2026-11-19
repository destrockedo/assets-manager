
package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired,
                   BigDecimal originalCost, String makeModel,
                   int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = Math.max(0, Year.now().getValue() - year);
        BigDecimal value = getOriginalCost();

        if (age <= 3) {
            value = value.subtract(
                    getOriginalCost().multiply(new BigDecimal("0.03"))
                            .multiply(BigDecimal.valueOf(age))
            );
        } else if (age <= 6) {
            value = value.subtract(
                    getOriginalCost().multiply(new BigDecimal("0.06"))
                            .multiply(BigDecimal.valueOf(age))
            );
        } else if (age <= 10) {
            value = value.subtract(
                    getOriginalCost().multiply(new BigDecimal("0.08"))
                            .multiply(BigDecimal.valueOf(age))
            );
        } else {
            value = value.subtract(new BigDecimal("1000.00"));
        }

        if (odometer > 100000 &&
                !makeModel.toLowerCase().contains("honda") &&
                !makeModel.toLowerCase().contains("toyota")) {

            value = value.multiply(new BigDecimal("0.75"));
        }

        return value.max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }
}
