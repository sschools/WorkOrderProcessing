package com.ironyard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Processor {

    public Map<Status, HashSet> orderMap = new HashMap<>();

    public void processWorkOrders() {
        moveIt();
        readIt();
    }

    private void moveIt() {
        // move work orders in map from one state to another
    }

    private void readIt() {
        // read the json files into WorkOrders and put in map
        File currentDirectory = new File(".");
        File files[] = currentDirectory.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".json")) {
                // f is a reference to a json file

                // f.delete(); will delete the file
            }
        }
    }

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }
}
