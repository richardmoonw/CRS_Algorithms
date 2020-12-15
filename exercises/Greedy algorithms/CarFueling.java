// You are going to travel to another city that is located d miles away from your home
// city. Your car can travel at most m miles on a full tank and you start with a full
// tank. Along your way, there are gas stations at distances stop1, stop2, ... , stopn
// from your home city. What is the minimum number of refills needed.

import java.util.*;

public class CarFueling {

    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Declare and ask the user to enter the input data.
        int total_distance, fuel_performance, number_of_gas_stations;
        total_distance = input.nextInt();
        fuel_performance = input.nextInt();
        number_of_gas_stations = input.nextInt();

        // The starting and the endpoint should be added too.
        int[] gas_stations = new int[number_of_gas_stations+2];
        gas_stations[0] = 0;

        // Ask the user to enter the rest of the gas stations' distances.
        gas_stations[number_of_gas_stations+1] = total_distance;
        for(int i=1; i<=number_of_gas_stations; i++) {
            gas_stations[i] = input.nextInt();
        }

        input.close();

        int number_of_refills, last_refill, current_station;
        number_of_refills = 0;
        last_refill = 0;
        current_station = 0;

        // While we have not reached our destination.
        while(gas_stations[current_station] < total_distance) {

            // Set the current station as the last refill point.
            last_refill = gas_stations[current_station];

            // While we have not reached our destination and the next gas station is 
            // reachable from our last refill point.
            while(gas_stations[current_station] < total_distance &&
                gas_stations[current_station+1] - last_refill <= fuel_performance) {
                current_station++;
            }

            // If we could not advance any distance.
            if(last_refill == gas_stations[current_station]){
                number_of_refills = -1;
                break;
            }

            // If we have not arrived to our destination yet, refill the tank in the
            // current gas station (we are sure it is a safe one).
            if(gas_stations[current_station] < total_distance) {
                number_of_refills++;
            }
        }

        System.out.println(number_of_refills);
    }
}