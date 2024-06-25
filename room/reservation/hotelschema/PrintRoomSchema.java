package io.github.ndimovt.room.reservation.hotelschema;

import java.io.*;

public class PrintRoomSchema {
    private final File firstFloor = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema\\firstFloor.txt");
    private final File secondFloor = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema\\secondFloor.txt");
    private final File thirdFloor = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema\\thirdFloor.txt");
    private final File fourthFloor = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema\\fourthFloor.txt");
    private final File fifthFloor = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\room\\reservation\\hotelschema\\fifthFloor.txt");
    public void printFloor(int floor){
            switch (floor){
                case 1:
                    System.out.println(result(firstFloor));
                    break;
                case 2:
                    System.out.println(result(secondFloor));
                    break;
                case 3:
                    System.out.println(result(thirdFloor));
                    break;
                case 4:
                    System.out.println(result(fourthFloor));
                    break;
                case 5:
                    System.out.println(result(fifthFloor));
                    break;
                default:
                    break;
            }
    }
    private String result(File file){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return sb.toString();
    }

}
