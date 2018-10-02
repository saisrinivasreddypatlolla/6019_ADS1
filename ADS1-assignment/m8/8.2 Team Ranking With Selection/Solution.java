import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for Team Information.
 */
class TeamInfo {
    /**
     * Name of the Team.
     */
    private String name;
    /**
     * No.of Wins of that Team.
     */
    private int wins;
    /**
     * No.of losses of that Team.
     */
    private int losses;
    /**
     * No.of draws of that Team.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      name1  The name1
     * @param      wins1   The wins1
     * @param      lost1  The lost1
     * @param      draws1  The draws1
     */
    TeamInfo(final String name1, final int wins1,
        final int lost1, final int draws1) {
        name = name1;
        wins = wins1;
        losses = lost1;
        draws = draws1;
    }

    /**
     * Method for Comparing the Objects w.r.t Wins, Losses, Draws.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final TeamInfo that) {
        if (this.wins < that.wins) {
            return 1;
        }
        if (this.wins > that.wins) {
            return -1;
        } else {
            if (this.losses < that.losses) {
                return -1;
            }
            if (this.losses > that.losses) {
                return 1;
            } else {
                if (this.draws < that.draws) {
                    return 1;
                }
                if (this.draws > that.draws) {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * Gets the name of the Team.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
}


/**
 * Class for lead board.
 */
class LeadBoard {
    /**
     * Object for Insertion Sort class.
     */
    private InsertionSort sorted = new InsertionSort();
    /**
     * Object Array for TeamInfo Class.
     */
    private TeamInfo[] teams;
    /**
     * Size of the Object Array.
     */
    private int size;

    /**
     * Constructs the object.
     */
    LeadBoard() {
        teams = new TeamInfo[1];
        size = 0;
    }

    /**
     * Resize Method is used to resize the array.
     */
    public void resize() {
        teams = Arrays.copyOf(teams, teams.length + 1);
    }

    /**
     * Adds a team to the Object Array.
     * Compelxity for adding is O(1).
     *
     * @param      team  The team
     */
    public void addTeam(final TeamInfo team) {
        if (size == teams.length) {
            resize();
        }
        teams[size++] = team;
    }

    /**
     * Print Method is used to print the Names of Sorted Teams.
     * Complexity of Print Method is O(N) it depends upon Size of Array.
     */
    public void print() {
        TeamInfo[] sortedteams = sorted.sorting(teams);
        for (int i = 0; i < size - 1; i++) {
            System.out.print(sortedteams[i].getName() + ",");
        }
        System.out.println(sortedteams[size - 1].getName());
    }
}

/**
 * Class for Insertion Sort.
 */
class InsertionSort {

    /**
     * Constructs the object.
     */
    InsertionSort() {
        //Not Using This Constructor.
    }

    /**
     * Method for Sorting all the objects in object array using Insertion Sort.
     * Complexity for Insertion Sort is O(N^2).
     * There is a nested loop a while loop inside for loop.
     * The for loop iterates N times.
     * The while loop iterates N times in the Worst Case.
     * Then the Complexity would be O(N^2).
     *
     * @param      teams  The teams
     *
     * @return     { It returns Sorted Object Array }.
     */
    public TeamInfo[] sorting(final TeamInfo[] teams) {
        int j = 0;
        for (int i = 1; i < teams.length; i++) {
            TeamInfo team = teams[i];
            j = i - 1;
            int value = teams[i].compareTo(teams[j]);
            while (j >= 0 && value == -1) {
                teams[j + 1] = teams[j];
                j -= 1;
                if (j >= 0) {
                    value = team.compareTo(teams[j]);
                }
            }
            teams[j + 1] = team;
        }
        return teams;
    }
}


/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Not Using this Constrcutor.
    }
    /**
     * Main Method for Sorting Teams Using Insertion Sort.
     * Complexity for Main Method is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LeadBoard cricketobj = new LeadBoard();
        Scanner scan = new Scanner(System.in);
        String[] info = null;
        while (scan.hasNext()) {
            info = scan.nextLine().split(",");
           TeamInfo team = new TeamInfo(info[0], Integer.parseInt(info[1]),
                Integer.parseInt(info[2]), Integer.parseInt(info[2 + 1]));


            cricketobj.addTeam(team);
        }
        cricketobj.print();
    }
}
