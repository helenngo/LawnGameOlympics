    package com.company;

    import com.sun.media.sound.InvalidFormatException;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;

    public class Main {

        private static OlympianManager OM;
        private static TeamManager TM;
        private static EventManager EM;
        private static CompetitionManager CM;
        static BufferedReader br;
        static String filePath;

        //A method to create and initialize the events array, olympian matrix and help screen.
        public static void main(String[] args) {

            filePath = args[0];


            OM = new OlympianManager(filePath);
            TM = new TeamManager(OM);
            EM = new EventManager(TM);
            CM = new CompetitionManager();

            System.out.println("Lawn Game Olympics");//The title of the application.
            System.out.println("Please remember input a file into configurations.");//The title of the application.
            System.out.println("Press enter once, then input");//A bit of instructions.
            System.out.println("\t e for today's events,");//A bit of instructions
            System.out.println("\t o for the competing olympians,");//A bit of instructions
            System.out.println("\t t for the teams,");//A bit of instructions
            System.out.println("\t c for the competitions,");//A bit of instructions
            System.out.println("\t sc for start competition,");//A bit of instructions
            System.out.println("\t ec for end competition, and");//A bit of instructions
            System.out.println("\t h for additional help.");//A bit of instructions

            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                String userInput = br.readLine(); //returns user input as string

                while ((userInput = br.readLine()) != null) {
                    if (userInput.equals("e") || userInput.equals("events")) {
                        getEvents();
                    } else if (userInput.equals("o") || userInput.equals("olympians")) {
                        getOlympian();
                    } else if (userInput.equals("h") || userInput.equals("help")) {
                        helpMethod();
                    }else if (userInput.equals("t") || userInput.equals("teams")) {
                        getTeams();
                    }else if(userInput.equals("c") || userInput.equals("competitions")){
                        getCompetitions();
                    }else if(userInput.equals("sc") || userInput.equals("start competition")){
                        startCompetition();
                    }else if(userInput.equals("ec") || userInput.equals("end competition")){
                        endCompetition();
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
        public static void getEvents() {
            System.out.println("The events are:");
            for (int i = 0; i < EM.getEvents().length; i++) {
                System.out.println(EM.getEvents()[i].getName());
                System.out.println(EM.getEvents()[i].getPlayTo());
                System.out.println(EM.getEvents()[i].getIsPlaytoExact());
                System.out.println(EM.getEvents()[i].getPlayDistance());
            }
            System.out.println("\n");
        }

        //A method to display the day's olympians.
        public static void getOlympian() {
            System.out.println("The olympians are:\n");
            for (int i = 0; i < OM.getOlympians().size(); i++) {
                Olympian person = OM.getOlympians().get(i);
                System.out.println(person.getName() + ", " + person.getSex() + ", " + person.getAge() + "\n");
            }
            System.out.println("\n");
        }

        //A method to display the day's teams.
        public static void getTeams() {
            System.out.println("The teams are:\n");
            for (int i = 0; i < TM.getTeams().length; i++) {
                Team person = TM.getTeams()[i];
                System.out.println(i + " " + person.getOlympian1().getName() + " & " + person.getOlympian2().getName());
                System.out.println("Wins:" + person.getWins() + ", Losses" + person.getLosses()+"\n");
            }
            System.out.println("\n");
        }

        //A method to select choices for competitions.
        public static void startCompetition(){
            try {
                System.out.println("Enter the desired event for your new competition.");
                for (int i = 0; i < EM.getEvents().length; i++) {
                    System.out.println(i + " " +EM.getEvents()[i].getName());
                }
                int e = Integer.parseInt(br.readLine());

                System.out.println("The teams are:\n");
                for (int i = 0; i < TM.getTeams().length; i++) {
                    Team person = TM.getTeams()[i];
                    System.out.println(i + " " + person.getOlympian1().getName() + " & " + person.getOlympian2().getName());
                }
                System.out.println("Enter the the desired first team.");
                int t1 = Integer.parseInt(br.readLine());
                System.out.println("Enter the the desired second team.");
                int t2 = Integer.parseInt(br.readLine());

                while (t1 == t2){
                    System.out.println("Don't be silly, a team can't play against themselves.");
                    System.out.println("Choose another team.");
                    t2 = Integer.parseInt(br.readLine());
                }

                CM.startCompetition(EM.getEvents()[e], TM.getTeams()[t1], TM.getTeams()[t2]);

            } catch (IOException ioe) {
                System.out.println("Don't be silly.");
            }catch (NumberFormatException nfe) {
                System.out.println("The events and teams are defined by their index numbers.");
            }catch (ArrayIndexOutOfBoundsException aiobe){
                System.out.println("You've chosen an invalid event or team.");
            }
        }

        //A method to display the current events.
        public static void getCompetitions() {
            System.out.println("The ongoing competitions are:\n");
            for (int i = 0; i < CM.getCompetitions().length; i++) {
                ICompetition match = CM.getCompetitions()[i];
                System.out.println(i + " Playing " + match.getEvent().getName()
                        + " are:");
                System.out.println("Team " + match.getTeam1().getOlympian1().getName() + " & " + match.getTeam1().getOlympian2().getName() + " and");
                System.out.println("Team " + match.getTeam2().getOlympian1().getName() + " & " + match.getTeam2().getOlympian2().getName() + "\n" );
            }
        }

        //A method to select competition to end.
        public static void endCompetition() {
            try{
                getCompetitions();
                System.out.println("Enter the ended competition.");
                int c = Integer.parseInt(br.readLine());
                System.out.println("The teams are:\n");
                for (int i = 0; i < TM.getTeams().length; i++) {
                    Team person = TM.getTeams()[i];
                    System.out.println(i + " " + person.getOlympian1().getName() + " & " + person.getOlympian2().getName());
                }
                System.out.println("Enter the winning team.");
                int w = Integer.parseInt(br.readLine());

                ICompetition competition = CM.getCompetitions()[c];
                Team winningTeam = TM.getTeams()[w];

                CM.endCompetition(competition, winningTeam);
            }
            catch (IOException ioe) {
                System.out.println("Incorrect input.");
            }
            catch (NumberFormatException nfe){
                System.out.println("The competitions and teams are defined by their index numbers.");
            }
            System.out.println("\n");
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