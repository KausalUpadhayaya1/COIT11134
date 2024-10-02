package com.mycompany.staffphonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {

    private String fileName;
    private ArrayList<PhoneNumber> phoneNoList;

    public DataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        phoneNoList = new ArrayList<>();
        readDataFile();  // Read existing phone numbers
    }

    // Read data from the file and add to phoneNoList
    private void readDataFile() throws FileNotFoundException {
        try (Scanner in = new Scanner(new FileReader(fileName))) {
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();

                // Log the line for debugging
                System.out.println("Reading line: " + line);

                // Skip empty lines
                if (line.isEmpty()) {
                    System.out.println("Skipped an empty line.");
                    continue;
                }

                // Split by the first occurrence of '(' assuming phone numbers always start with '('
                int phoneStartIndex = line.indexOf('(');
                if (phoneStartIndex != -1) {
                    String name = line.substring(0, phoneStartIndex).trim();
                    String phone = line.substring(phoneStartIndex).trim();

                    // Log the name and phone for debugging
                    System.out.println("Name: " + name + ", Phone: " + phone);

                    phoneNoList.add(new PhoneNumber(name, phone));
                } else {
                    System.out.println("Skipping line due to incorrect format: " + line);
                }
            }
        }
    }

    // Save phone numbers to the file
    public void saveData() {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (PhoneNumber phoneNumber : phoneNoList) {
                out.println(phoneNumber.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a phone number to the list
    public void addPhoneNo(PhoneNumber ph) {
        phoneNoList.add(ph);
    }

    // Get display output for text area
    public String getDisplayOutput() {
        StringBuilder output = new StringBuilder();
        for (PhoneNumber phoneNumber : phoneNoList) {
            output.append(phoneNumber.toString()).append("\n");
        }
        output.append("Total number of phone entries: ").append(phoneNoList.size());
        return output.toString();
    }
}
