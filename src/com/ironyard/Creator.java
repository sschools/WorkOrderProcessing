package com.ironyard;

import java.util.Scanner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creator {
    public void createWorkOrders() throws JsonProcessingException {
        Main.orderCount += 1;
        WorkOrder newOrder = new WorkOrder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a new Work Order:");
        System.out.println("Enter description:");
        newOrder.setDescription(scanner.nextLine());
        System.out.println("Enter your name:");
        newOrder.setSenderName(scanner.nextLine());
        newOrder.setStatus(Status.INITIAL);
        newOrder.setId(Main.orderCount);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(newOrder);
        String fileTitle = newOrder.getId() + ".json";

        try {
            File file = new File(fileTitle);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        createWorkOrders();
    }

    public static void main(String args[]) throws JsonProcessingException {
        Creator creator = new Creator();
        creator.createWorkOrders();
    }
}
