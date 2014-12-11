    package com.company;

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
            System.out.println("\t e for today's events,");
            System.out.println("\t o for the competing olympians,");
            System.out.println("\t t for the teams,");
            System.out.println("\t c for the competitions,");
            System.out.println("\t sc for start competition,");
            System.out.println("\t ec for end competition, and");
            System.out.println("\t h for additional help.");

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
                //If the event is over, the top three teams are returned in order
                if(EM.getEvents()[i].isEmpty()){
                    EM.getEvents()[i].ReturnPlacing();
                }else{
                    System.out.println("*");
                }
                System.out.print("Play to:" + EM.getEvents()[i].getPlayTo());
                System.out.print(", " + EM.getEvents()[i].getIsPlaytoExact());
                System.out.print(", & " +EM.getEvents()[i].getPlayDistance());
                System.out.println("* The event is still ongoing; no placing to display.\n");
            }
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

        //A method to display the current events.
        public static void getCompetitions() {
            helloWorld(); //starts initial competitions and sees if there are any more competitions that can be started
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

                //passes the competition and the winning team into endCompetition in Competition Manager
                CM.endCompetition(CM.getCompetitions()[c], TM.getTeams()[w]);
                //checks to see of there are any new competitions that can be started
                helloWorld();
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

        /*If method that starts a competition by checking to see if an event is in a competition, and if the two upcoming teams for that event is in
        * a competition. If none of the above is in a competition then the a competition is started with the event, and the two teams.*/
        public static void helloWorld() {
            for (int i = 0; i < EM.getEvents().length; i++) { //checks through every Event
                for (int j = 0; j < CM.getCompetitions().length; j++) { //check through every Competition
                    ICompetition[] curr = CM.getCompetitions();
                    if (EM.getEvents()[i] == curr[j].getEvent()) { //if the event is in an Competition
                        i++; //go to the next Event
                    //if the event is not in Competition, and it is the last element of Competition => the event is not in Competition
                    } else if (EM.getEvents()[i] != curr[j].getEvent() && curr[j] == curr[curr.length]) {
                        //checks if the next team is in Competition
                        for (int k = 0; k == CM.getCompetitions().length; k++) {
                            ICompetition[] cur = CM.getCompetitions();
                            if (EM.getEvents()[i].PeekNextTeams()[0] == cur[k].getTeam1() || EM.getEvents()[i].PeekNextTeams()[0] == cur[k].getTeam2()) {
                                i++;
                            } else if (EM.getEvents()[i].PeekNextTeams()[0] != cur[k].getTeam1() || EM.getEvents()[i].PeekNextTeams()[0] != cur[k].getTeam2() && cur[k] == cur[curr.length]) {
                                //checks if the next-next team is in Competition
                                for (int l = 0; l == CM.getCompetitions().length; l++) {
                                    ICompetition[] cu = CM.getCompetitions();
                                    if (EM.getEvents()[i].PeekNextTeams()[1] == cu[l].getTeam1() || EM.getEvents()[i].PeekNextTeams()[1] == cu[l].getTeam2()) {
                                        i++;
                                    //if the next-next team is also not in Competition
                                    } else if (EM.getEvents()[i].PeekNextTeams()[1] != cur[l].getTeam1() || EM.getEvents()[i].PeekNextTeams()[1] != cur[l].getTeam2() && cu[l] == cu[curr.length]) {
                                        //start a new competition with the event that is not in Competition, and the two next teams.
                                        CM.startCompetition(EM.getEvents()[i], EM.getEvents()[i].GetNextTeams()[0], EM.getEvents()[i].GetNextTeams()[1]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }