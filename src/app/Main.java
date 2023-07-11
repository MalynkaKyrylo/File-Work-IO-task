package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getOutput(getChoice(getFileName()));
    }

    private static String getChoice(String file) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select the file processing option: \n 1) write \n 2) read");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Enter the text to write to the file: ");
                String text = scanner.nextLine();
                return writeFileData(file, text);
            } else if (choice == 2) {
                return readFileData(file);
            } else {
                System.out.println("Wrong number!");
                return getChoice(file);
            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid value!");
            return getChoice(file);
        }
    }

    private static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file name: ");
        return scanner.nextLine();
    }

    private static String readFileData(String file) {
        return new FileReadService().readFile(file);
    }

    private static String writeFileData(String file, String message) {
        return new FileWriteService().handleFile(file, message);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
