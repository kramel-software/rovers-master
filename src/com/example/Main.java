package com.example;

import com.example.entity.*;
import com.example.file.FileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Path of filename
        String filename = args[0];
        FileReader fileReader = new FileReader(filename);
        List<String> inputList;
        inputList = fileReader.read();

        if (!inputList.isEmpty()) {
            String plateauValue = inputList.get(0);
            String[] tabValue = plateauValue.split(" ");
            Plateau plateau = new Plateau(new Coordinate(Integer.parseInt(tabValue[0]), Integer.parseInt(tabValue[1])));

            Rover rover = null;
            for (int i = 1; i < inputList.size() ; i++ ) {
               //Go to the next rover
               if ((i+1)%2 == 0) {

                   String roverValue = inputList.get(i);
                   String[] tabRoverValue = roverValue.split(" ");
                   Cardinal cardinal = null;

                   if (tabRoverValue[2].equals(Cardinal.E.toString()))
                       cardinal = Cardinal.E;
                   else if (tabRoverValue[2].equals(Cardinal.W.toString()))
                       cardinal = Cardinal.W;
                   else if (tabRoverValue[2].equals(Cardinal.S.toString()))
                       cardinal = Cardinal.S;
                   else if (tabRoverValue[2].equals(Cardinal.N.toString()))
                       cardinal = Cardinal.N;

                   rover = new Rover(new Coordinate((Integer.parseInt(tabRoverValue[0])), Integer.parseInt(tabRoverValue[1])), cardinal);
               } else {
                   String letterValue = inputList.get(i);
                   char[] tabLetter = letterValue.toCharArray();
                   Letter letter;
                   for (char c : tabLetter) {
                       if (String.valueOf(c).equals(Letter.L.toString()))
                           letter = Letter.L;
                       else if (String.valueOf(c).equals(Letter.R.toString()))
                           letter = Letter.R;
                       else if (String.valueOf(c).equals(Letter.M.toString()))
                           letter = Letter.M;
                       else
                           letter = null;

                       if (letter != null) {
                           rover.move(letter);
                       }
                   }
               }

               //Output
                System.out.println(rover);

            }
        }
    }
}
