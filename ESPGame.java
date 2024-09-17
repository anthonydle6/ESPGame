package espgame;
/*
 * Class: CMSC203 23488 
 * Instructor: Huseyin Aygun
 * Description: ESP (Extrasensory Perception) Game
 * Due: 09/16/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Anthony Le
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class ESPGame 
{

    public static void main(String[] args) 
    {
        // create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // print assignment and skill test comment
        System.out.print("CMSC203 Assignment1: Test your ESP skills!\n");
        
        // ask the user for the filename 
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        // declare constants (number of colors)
        final int NUM_COLORS = 16;
        final String[] COLORS = new String[NUM_COLORS];

        // use scanner to read the file
        try (Scanner input = new Scanner(new File(filename))) 
        {
            int index = 0;
            System.out.println("There are sixteen colors from the file:");
            
            // loop to go through line in file
            while (input.hasNextLine() && index < NUM_COLORS) 
            {
                String line = input.nextLine();
                String[] colorLine = line.split(" ", 2); //space between num and color
                COLORS[index] = colorLine[1]; // store color in array
                System.out.println(line); // display color
                index++;
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
            // program exit if file is not read
            return;  
        }

        Random rand = new Random();
        int correctGuesses = 0;

        // play 3 rounds
        for (int round = 1; round <= 3; round++) 
        {
            System.out.println("\nRound " + round);
            System.out.println("\nI am thinking of a color.");
            System.out.println("Is it one of the colors above?");
            
            // generate a random color
            int randomColorIndex = rand.nextInt(NUM_COLORS);  // Random number between 0 and 15
            String selectedColor = COLORS[randomColorIndex];

            // ask the user for guess
            System.out.print("Enter your guess: ");
            String userGuess = scanner.nextLine().trim();

            // check to see if users guess is correct ignoring caps
            if (userGuess.equalsIgnoreCase(selectedColor)) {
                System.out.println("I was thinking of " + selectedColor + ".");
                correctGuesses++;
            } else {
                System.out.println("I was thinking of " + selectedColor + ".");
            }
        }

        // display game over + result
        System.out.println("Game Over");
        System.out.println("\nYou guessed " + correctGuesses + " out of 3 colors correctly.");

        // ask user for details
        
        //name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        //description
        System.out.print("Describe yourself: ");
        String description = scanner.nextLine();
        
        //due date
        System.out.print("Due Date: ");
        String dueDate = scanner.nextLine();

        // display user inputed details 
        System.out.println("\nUser Name: " + name);
        System.out.println("User Description: " + description);
        System.out.println("Date: " + dueDate);
    }
}

