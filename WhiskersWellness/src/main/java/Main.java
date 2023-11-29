import java.sql.Connection;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static  void main(String[] args){
        Scanner deats = new Scanner(System.in);
        String details;

        DbConnection db = new DbConnection();
        Connection conn = db.connect_to_db("cat", "postgres", "postgres");
        db.createTable(conn, "cat");
        db.createWTable(conn, "weight_tracker");
        db.createTableV(conn, "vet_visits");

        System.out.println();
        System.out.println("Welcome to Whiskers & Wellness! ≽^•⩊•^≼ ");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please Enter your Cat's name \uD83D\uDC08\u200D");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Your Cat's name is " + userName+"!");  // Output user input
        System.out.println("How adorable! ♡");

        System.out.println("Please Enter "+userName+"'s weight:");

        Double cat_weight = myObj.nextDouble();  // Read user input
        if (cat_weight>12) {
            System.out.println("That's a lot of cat! Perhaps a diet may help your feline friend live a longer life ⋆˚\uD83D\uDC3E˖°");
        }else{
            System.out.println("Thank you for entering your cat's weight!");

        }

        System.out.println("Please Enter the AM time when "+userName+" is fed:");
        Scanner t = new Scanner(System.in);  //
        String timeA = t.nextLine();
        System.out.println("Please Enter the PM time when "+userName+" is fed:");
        Scanner b = new Scanner(System.in);  //
        String timeP = t.nextLine();

        feedingSchedule feed = new feedingSchedule(timeA, timeP);
        feed.start();



        db.insert_row(conn,"cats",userName, cat_weight);
        db.insert_Wrow(conn, "weight_tracker", cat_weight);
System.out.println("Now let's get familiar with the app!");
System.out.println("There are multiple commands to navigate the app!");
System.out.println("Type add weight to add a weight measurement for "+userName);
System.out.println("If you ever forget, just type help and the command list will pop right back up!");
        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object

        String cmd = myObj2.nextLine();  // Read user input
//        if (command.equals("help")){
//            help hlp = new help();
//System.out.print(hlp.help);
//        }else{
//            System.out.println("Oops that's not command!");
//        }
        //String cmd = myObj2.nextLine();  // Read user input

        while (!cmd.equalsIgnoreCase("end")) {
            System.out.println("You've entered "+cmd);
            if (cmd.equalsIgnoreCase("help")) {
                help hlp = new help();
                System.out.println(hlp.help);
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                cmd = myObj2.nextLine();
            } else if (cmd.equalsIgnoreCase("add weight")) {
                System.out.println("Please enter weight:");
                cat_weight = myObj.nextDouble();
                db.insert_Wrow(conn, "weight_tracker", cat_weight);
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                cmd = myObj2.nextLine();
            } else if (cmd.equalsIgnoreCase("read weight")) {
                db.read_w(conn, "weight_tracker");
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                cmd = myObj2.nextLine();
            }else if (cmd.equalsIgnoreCase("add vet visit")){
                System.out.println("Please enter details:");
                details = deats.nextLine();
                db.insert_Vrow(conn, "vet_visits", details);
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                cmd = myObj2.nextLine();
        }else if (cmd.equalsIgnoreCase("read vet visits")){
                db.read_V(conn, "vet_visits");
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                cmd = myObj2.nextLine();
            }else {
                System.out.println("That's not a command! Try again");
                help hlp = new help();
                System.out.println(hlp.help);
                System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");
                System.out.println("Please enter a new command");
                //System.out.println("≽^•⩊•^≼ ⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖°⋆˚\uD83D\uDC3E˖° ≽^•⩊•^≼");

                cmd = myObj2.nextLine();

            }

        }
    }

    }

