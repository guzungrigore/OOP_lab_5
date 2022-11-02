import Coffee.*;
import Desert.*;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Barista barista = new Barista("Intermediate"); // change the proficiency of the barista:
                                                                //  Beginner, Intermediate, Expert.

        Client client = new Client("client");
        Random rand = new Random();
        Scanner scanner =  new Scanner(System.in);

        int anHour = 60; // in minutes
        int timePassed = 0;
        int hourlyRevenue = 0;
        int dailyRevenue = 0;
        int totalRevenue = 0;
        int hour = 8;
        int day = 1;
        int simulation = 1;

        int coffeeCounter = 0;
        int desertCounter = 0;

        while(simulation == 1) {

            int timeNextCustomer = client.timeBetweenCustomers(hour);
            timePassed += timeNextCustomer;
            System.out.println("A new customer arrived in " + timeNextCustomer + " minutes.");

            int randName = rand.nextInt(5) + 1;
            if (randName == 1) {
                client.setName("Greg");
            } else if (randName == 2) {
                client.setName("Alex");
            } else if (randName == 3) {
                client.setName("Anna");
            } else if (randName == 4) {
                client.setName("Bob");
            } else {
                client.setName("Alice");
            }

            int randomWillTip = rand.nextInt(2) + 1;
            client.setWillTip(randomWillTip != 1);

            int randomWantsDesert = rand.nextInt(2) + 1;
            client.setWantsDesert(randomWantsDesert != 1);

            int check = 0;

            int randCoffee = rand.nextInt(9) + 1;
            switch (randCoffee) {
                case 1:
                    System.out.println(client.getName() + " ordered an Espresso");
                    Espresso espresso = new Espresso();
//                    espresso.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += espresso.getPrice();
                    check += espresso.getPrice();
                    timePassed += 2 + barista.skill();
                    barista.setCoffeeMade("Espresso");
                    break;
                case 2:
                    System.out.println(client.getName() + " ordered an Americano");
                    Americano americano = new Americano();
//                    americano.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += americano.getPrice();
                    check += americano.getPrice();
                    timePassed += 3 + barista.skill();
                    barista.setCoffeeMade("Americano");
                    break;
                case 3:
                    System.out.println(client.getName() + " ordered an Affogato");
                    Affogato affogato = new Affogato();
//                    affogato.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += affogato.getPrice();
                    check += affogato.getPrice();
                    timePassed += 3 + barista.skill();
                    barista.setCoffeeMade("Affogato");
                    break;
                case 4:
                    System.out.println(client.getName() + " ordered a Cappucino");
                    Cappucino cappucino = new Cappucino();
//                    cappucino.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += cappucino.getPrice();
                    check += cappucino.getPrice();
                    timePassed += 4 + barista.skill();
                    barista.setCoffeeMade("Cappucino");
                    break;
                case 5:
                    System.out.println(client.getName() + " ordered a Flat White");
                    FlatWhite flatWhite = new FlatWhite();
//                    flatWhite.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += flatWhite.getPrice();
                    check += flatWhite.getPrice();
                    timePassed += 4 + barista.skill();
                    barista.setCoffeeMade("FlatWhite");
                    break;
                case 6:
                    System.out.println(client.getName() + " ordered an Irish Coffee");
                    IrishCoffee irishCoffee = new IrishCoffee();
//                    irishCoffee.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += irishCoffee.getPrice();
                    check += irishCoffee.getPrice();
                    timePassed += 4 + barista.skill();
                    barista.setCoffeeMade("IrishCoffee");
                    break;
                case 7:
                    System.out.println(client.getName() + " ordered a Macchiato");
                    Macchiato macchiato = new Macchiato();
//                    macchiato.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += macchiato.getPrice();
                    check += macchiato.getPrice();
                    timePassed += 3 + barista.skill();
                    barista.setCoffeeMade("Macchiato");
                    break;
                case 8:
                    System.out.println(client.getName() + " ordered a Mochaccino");
                    Mochaccino mochaccino = new Mochaccino();
//                    mochaccino.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += mochaccino.getPrice();
                    check += mochaccino.getPrice();
                    timePassed += 5 + barista.skill();
                    barista.setCoffeeMade("Mochaccino");
                    break;
                case 9:
                    System.out.println(client.getName() + " ordered a Vietnamese Coffee");
                    VietnameseCoffee vietnameseCoffee = new VietnameseCoffee();
//                    vietnameseCoffee.makeCoffee();
                    coffeeCounter++;
                    hourlyRevenue += vietnameseCoffee.getPrice();
                    check += vietnameseCoffee.getPrice();
                    timePassed += 6 + barista.skill();
                    barista.setCoffeeMade("VietnameseCoffee");
                    break;
            }

            //System.out.println("And after all of this he served it to the customer");

            if (client.isWantsDesert()) {
                int whatDessert = rand.nextInt(5) + 1;
                switch (whatDessert) {
                    case 1:
                        Muffin muffin = new Muffin();
                        System.out.println(client.getName() + " also ordered a muffin that was " + muffin.getDesertPrice() + " lei");
                        hourlyRevenue += muffin.getDesertPrice();
                        check += muffin.getDesertPrice();
                        desertCounter++;
                        break;
                    case 2:
                        Croissant croissant = new Croissant();
                        System.out.println(client.getName() + " also ordered a croissant that was " + croissant.getDesertPrice() + " lei");
                        hourlyRevenue += croissant.getDesertPrice();
                        check += croissant.getDesertPrice();
                        desertCounter++;
                        break;
                    case 3:
                        ChocolateCroissant chocolateCroissant = new ChocolateCroissant("chocolate");
                        System.out.println(client.getName() + " also ordered a croissant with chocolate that was " + chocolateCroissant.getDesertPrice() + " lei");
                        hourlyRevenue += chocolateCroissant.getDesertPrice();
                        check += chocolateCroissant.getDesertPrice();
                        desertCounter++;
                        break;
                    case 4:
                        CherryMuffin cherryMuffin = new CherryMuffin("cherry");
                        System.out.println(client.getName() + " also ordered a muffin with cherry that was " + cherryMuffin.getDesertPrice() + " lei");
                        hourlyRevenue += cherryMuffin.getDesertPrice();
                        check += cherryMuffin.getDesertPrice();
                        desertCounter++;
                        break;
                    case 5:
                        Cheesecake cheesecake = new Cheesecake();
                        System.out.println(client.getName() + " also ordered a cheesecake that was " + cheesecake.getDesertPrice() + " lei");
                        hourlyRevenue += cheesecake.getDesertPrice();
                        check += cheesecake.getDesertPrice();
                        desertCounter++;
                        break;
                }
            }

            System.out.println(client.getName() + " payed " + check + " lei");

            if (client.isWillTip()) {
                int tip = rand.nextInt(20) + 1;
                System.out.println("The client also tipped the barista " + tip + " lei");
            }
            System.out.println("***************************************************");
            if(timePassed >= anHour) {
                timePassed = 0;

                System.out.println("Total revenue at hour " + hour++ + " was: " + hourlyRevenue + " lei");
                dailyRevenue += hourlyRevenue;
                hourlyRevenue = 0;

                if (hour >= 20){
                    System.out.println("***************************************************");
                    dailyRevenue -= barista.getSalary() + 500;
                    System.out.println("Total revenue for day " + day++ + ": " + dailyRevenue + " lei");
                    System.out.println("Total coffee ordered today: " + coffeeCounter);
                    System.out.println("Total deserts ordered today: " + desertCounter);
                    totalRevenue += dailyRevenue;
                    hour = 8;
                    dailyRevenue = 0;
                    coffeeCounter = 0;
                    desertCounter = 0;
                    System.out.println("Barista's current proficiency: " + barista.getProficiency());
                    System.out.println("Total revenue made so far " + totalRevenue);
                }

                System.out.println("Type 0 to end the simulation or 1 to continue it");
                simulation = scanner.nextInt();
                if (simulation == 0) {
                    System.out.println("Simulation ended.");
                    System.exit(0);
                }
            }
        }
    }
}