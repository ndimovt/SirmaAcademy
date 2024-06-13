package io.github.ndimovt.exc5.cartasks;

import java.util.ArrayList;
import java.util.Scanner;

public class CarTest {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        int n = inn.nextInt();
        inn.nextLine();
        for (int i = 0; i < n ; i++) {
            String[] carInfo = inn.nextLine().split(" ");
            if(carInfo.length == 1){
                cars.add(new Car(carInfo[0]));
            } else if (carInfo.length == 2) {
                cars.add(new Car(carInfo[0], carInfo[1]));
            } else{
                cars.add(new Car(carInfo[0],carInfo[1],Integer.parseInt(carInfo[2])));
            }
        }
        for(Car car : cars){
            System.out.println(car.info());
        }
    }

}
