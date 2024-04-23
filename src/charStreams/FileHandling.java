package charStreams;

import java.io.*;

public class FileHandling
{
    public static void main(String[] args)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("InputFile.txt"))) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String str;
                do {
                    System.out.print("Enter the text to be written: ");
                    str = reader.readLine();
                    writer.write(str + "\n");

                    System.out.print("Want to add more? (y/n): ");
                    str = reader.readLine();
                } while (!str.equalsIgnoreCase("n"));
            }

            System.out.println("Entered text saved to the file--> 'InputFile.txt'.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        // Read and display content from the file
        System.out.println("Contents of the file 'InputFile.txt':");
        try (BufferedReader fileReader = new BufferedReader(new FileReader("InputFile.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
