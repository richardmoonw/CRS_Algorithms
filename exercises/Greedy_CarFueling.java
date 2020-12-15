// You are going to travel to another city that is located d miles away from your home
// city. Your car can travel at most m miles on a full tank and you start with a full
// tank. Along your way, there are gas stations at distances stop1, stop2, ... , stopn
// from your home city. What is the minimum number of refills needed.

import java.util.*;

public class Greedy_CarFueling {

    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Declare and ask the user to enter the input data.
        int total_distance, fuel_performance, number_of_gas_stations;
        total_distance = input.nextInt();
        fuel_performance = input.nextInt();
        number_of_gas_stations = input.nextInt();

        int[] gas_stations = new int[number_of_gas_stations+1];
        for(int i=0; i<number_of_gas_stations; i++) {
            gas_stations[i] = input.nextInt();
        }
        gas_stations[number_of_gas_stations] = total_distance;

        input.close();

        // // Sort the gas stations distance.
        // Arrays.sort(gas_stations);

        int current_gas_station, distance_traveled, number_of_refills;
        current_gas_station = 0;
        distance_traveled = 0;
        number_of_refills = 0;

        // While we are not able to reach our destination.
        while(distance_traveled + fuel_performance < total_distance) {
            
            while(gas_stations[current_gas_station] - distance_traveled <= fuel_performance){
                current_gas_station++;
            }
            if(gas_stations[current_gas_station] - distance_traveled >= fuel_performance) {
                number_of_refills++;
                distance_traveled = gas_stations[current_gas_station-1];
                
                if(gas_stations[current_gas_station] - distance_traveled >= fuel_performance) {
                    number_of_refills = -1;
                    break;
                }
            }            
        }

        System.out.println(number_of_refills);
    }
}