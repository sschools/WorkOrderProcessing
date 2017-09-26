package com.ironyard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Processor {

    public Map<Status, HashSet> orderMap = new HashMap<>();

    public ObjectMapper mapper = new ObjectMapper();

    public void processWorkOrders() {
        moveIt();
        readIt();
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        processWorkOrders();
    }

    private void moveIt() {
        // move work orders in map from one state to another
    }

    private void readIt() {
        // read the json files into WorkOrders and put in map
        File currentDirectory = new File(".");
        File files[] = currentDirectory.listFiles();
        Set<WorkOrder> orderSet = new HashSet<>();
        List<String> fileContents = new ArrayList<>();
        for (File f : files) {
            if (f.getName().endsWith(".json")) {
                try {
                    Scanner fileScanner = new Scanner(f);
                    while (fileScanner.hasNext()) {
                        fileContents.add(fileScanner.nextLine());
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("Could not find file *" + f + "*");
                    ex.printStackTrace();
                }
                System.out.println("File contents: " + fileContents);

                f.delete();
            }
        }
        String [] orders = fileContents.toArray(new String[0]);
        for (int i = 0; i < orders.length; i++) {
            try {
                WorkOrder readOrder = mapper.readValue(orders[i], WorkOrder.class);
                orderSet.add(readOrder);
                orderMap.put(Status.INITIAL, (HashSet) orderSet);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }
}
