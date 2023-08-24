import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Match {
    private String location;
    private String team1;
    private String team2;
    private String timing;

    public Match(String location, String team1, String team2, String timing) {
        this.location = location;
        this.team1 = team1;
        this.team2 = team2;
        this.timing = timing;
    }

    public String getLocation() {
        return location;
    }

    public String getTeams() {
        return team1 + " vs " + team2;
    }

    public String getTiming() {
        return timing;
    }
}

class FlightTable {
    private List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> listMatchesByTeam(String teamName) {
        List<Match> teamMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTeams().contains(teamName)) {
                teamMatches.add(match);
            }
        }
        return teamMatches;
    }

    public List<Match> listMatchesByLocation(String location) {
        List<Match> locationMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getLocation().equalsIgnoreCase(location)) {
                locationMatches.add(match);
            }
        }
        return locationMatches;
    }

    public List<Match> listMatchesByTiming(String timing) {
        List<Match> timingMatches = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTiming().equalsIgnoreCase(timing)) {
                timingMatches.add(match);
            }
        }
        return timingMatches;
    }
}

public class lab04 {
    public static void main(String[] args) {
        FlightTable flightTable = new FlightTable();

        // Adding matches to the flight table
        flightTable.addMatch(new Match("Mumbai", "India", "Sri Lanka", "DAY"));
        flightTable.addMatch(new Match("Delhi", "England", "Australia", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Chennai", "India", "South Africa", "DAY"));
        flightTable.addMatch(new Match("Indore", "England", "Sri Lanka", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Mohali", "Australia", "South Africa", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Delhi", "India", "Australia", "DAY"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Search Options:");
            System.out.println("1. List of all the matches of a Team");
            System.out.println("2. List of Matches on a Location");
            System.out.println("3. List of Matches based on timing");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the team name: ");
                    String teamName = scanner.nextLine();
                    List<Match> teamMatches = flightTable.listMatchesByTeam(teamName);
                    for (Match match : teamMatches) {
                        System.out.println("Location: " + match.getLocation() + ", Teams: " + match.getTeams()
                                + ", Timing: " + match.getTiming());
                    }
                    break;

                case 2:
                    System.out.print("Enter the location: ");
                    String location = scanner.nextLine();
                    List<Match> locationMatches = flightTable.listMatchesByLocation(location);
                    for (Match match : locationMatches) {
                        System.out.println("Teams: " + match.getTeams() + ", Timing: " + match.getTiming());
                    }
                    break;

                case 3:
                    System.out.print("Enter the timing: ");
                    String timing = scanner.nextLine();
                    List<Match> timingMatches = flightTable.listMatchesByTiming(timing);
                    for (Match match : timingMatches) {
                        System.out.println("Location: " + match.getLocation() + ", Teams: " + match.getTeams());
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}