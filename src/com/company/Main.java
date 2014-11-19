    package com.company;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;

    public class Main {

        private static CompetitionManager Cats = new CompetitionManager();
        private static TeamManager TeamManager = new TeamManager();
        private static OlympianManager OlympianManager = new OlympianManager();

        //A method to create and initialize the events array, olympian matrix and help screen.
        public static void main(String[] args) {

            System.out.println("Lawn Game Olympics");//The title of the application.
            System.out.println("Press enter once, then input");//A bit of instructions.
            System.out.println("\t e for today's events");//A bit of instructions
            System.out.println("\t o for the competing olympians");//A bit of instructions
            System.out.println("\t t for the teams, and");//A bit of instructions
            System.out.println("\t h for additional help.");//A bit of instructions

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String userInput = br.readLine(); //returns user input as string

                while ((userInput = br.readLine()) != null) {
                    if (userInput.equals("e") || userInput.equals("events")) {
                        eventMethod();
                    } else if (userInput.equals("o") || userInput.equals("olympians")) {
                        getOlympian();
                    } else if (userInput.equals("h") || userInput.equals("help")) {
                        helpMethod();
                    }else if (userInput.equals("t") || userInput.equals("teams")) {
                        getTeams();
                    }else if(userInput.equals("sc")){
                        startCompetition();
                    }else if(userInput.equals("q") || userInput.equals("quit")) {
                        System.out.println("Bye.");
                        System.exit(0);
                    } else {
                        System.out.println("Your input could not be understood.");
                        System.out.println("Please refer to the start screen or enter the" +
                                "\nletter h then press enter for additional help.");
                    }
                }

            } catch (IOException ioe) {
                System.out.println("Problem reading from file");
            }
        }

        //A method to display the day's events.
        public static void eventMethod() {
            System.out.println("The events are:");
            EventManager EventManager = new EventManager();
            for (int i = 0; i < EventManager.eventsArray.length; i++) {
                System.out.println(EventManager.eventsArray[i].getName());
                System.out.println(EventManager.eventsArray[i].getPlayTo());
                System.out.println(EventManager.eventsArray[i].getIsPlaytoExact());
                System.out.println(EventManager.eventsArray[i].getPlayDistance());
            }
            System.out.println("\n");
        }

        //A method to display the day's olympians.
        public static void getOlympian() {
            System.out.println("The olympians are:\n");
            for (int i = 0; i < OlympianManager.list.size(); i++) {
                Olympian person = OlympianManager.list.get(i);
                System.out.println(person.getName() + ", " + person.getSex() + ", " + person.getAge() + "\n");
            }
            System.out.println("\n");
        }

        //A method to display the day's teams.
        public static void getTeams() {
            System.out.println("The teams are:\n");
            for (int i = 0; i < TeamManager.teams.length; i++) {
                Team person = TeamManager.teams[i];
                System.out.println(person.getOlympian1().getName() + ", " + person.getOlympian2().getName() + ", " + person.getLosses() + "," +
                        person.getWins()+"\n");
            }
            System.out.println("\n");
        }

        //A method to select choices for competitions.
        public static void startCompetition() {
            System.out.println("Enter the desired event for your new competition.");
            int event = Integer.parseInt(br.readLine());
            System.out.println("Enter the the desired first team.");
            String team1 = br.readLine();
            System.out.println("Enter the the desired second team.");
            String team2 = br.readLine();
            Cats.GetCompetions()[event].getEvent();
        }

        public static void endCompetition() {
            System.out.print("Enter the ended competition.");
            int competition = Integer.parseInt(br.readLine());
            System.out.println("Enter the winning team.");
            String winningTeam = br.readLine();
        }

        //A method to display the help screen.
        public static void helpMethod() {
            System.out.println("Help Menu:");//The help screen.
            System.out.println("Refer to the start screen for input options, or" +
                    "\nyou may input the word. Once you've have input" +
                    "\nthe your desired option, press the enter key."+
                    "\nPlease keep in mind that everything is lowercase.\n");
            System.out.println("And if you still don't know what to do," +
                    "\nI'm sorry but I can't help you anymore.");
            System.out.println("\n");
        }
    }