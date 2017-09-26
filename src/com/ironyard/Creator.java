package com.ironyard;

import java.util.Scanner;

public class Creator {
    public void createWorkOrders() {
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
    }

    public static void main(String args[]) {
        Creator creator = new Creator();
        creator.createWorkOrders();
    }
}
