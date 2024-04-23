package charStreams;

import java.io.*;
import java.util.Scanner;

public class FileHandling
{
    public static void main(String[] args)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userInput.txt"))) {
            try (Scanner scanner = new Scanner(System.in)) {
                String input;
                do {
                    System.out.print("Enter the text to be written: ");
                    input = scanner.nextLine();
                    writer.write(input + "\n");

                    System.out.print("Want to add more? (y/n): ");
                    input = scanner.nextLine();
                } while (!input.equalsIgnoreCase("n"));
            }

            System.out.println("User input saved to file 'InputFile.txt'.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        // Read and display content from the file using Scanner
        System.out.println("Contents of the file 'InputFile.txt':");
        try (Scanner fileScanner = new Scanner(new File("InputFile.txt"))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println( e.getMessage());
        }
    }
}
