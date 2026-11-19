
package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("My House", "2020-07-17", new BigDecimal("200000.00"),
                "123 Street", 2, 2000, 5000));

        assets.add(new House(
                "Moon house", "2022-12-31", new BigDecimal("150000.00"),
                "321 Moon alley", 1, 1500, 3000));


        assets.add(new Vehicle(
                "sun mobile", "2021-01-01", new BigDecimal("25000.00"),
                "Thermal Civic", 2021, 80000));

        assets.add(new Vehicle(
                "Booster Car", "2019-01-23", new BigDecimal("40000.00"),
                "Ford Super Fusion", 2019, 120000));

        // Displays full aray list
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Current Value: $" + asset.getValue());

            // Determine the specific asset type/ and or turns an object thats orginally an asset to a HOuse to use its parts
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());

            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
            }
        }
    }
}
