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
     * @param      losses1  The losses1
     * @param      draws1  The draws1
     */
    TeamInfo(final String name1, final int wins1, final int losses1, final int draws1) {
        name = name1;
        wins = wins1;
        losses = losses1;
        draws = draws1;
    }

    /**
     * Method to check which value of Team is higher is lower.
     *
     * @param      that  The that
     *
     * @return     Returns the boolean Value true if there is need to swap
     *               else false
     */
    public boolean less(final TeamInfo that) {
        if (this.wins < that.wins) {
            return true;
        }
        if (this.wins > that.wins) {
            return false;
        } else {
            if (this.losses < that.losses) {
                return false;
            }
            if (this.losses > that.losses) {
                return true;
            } else {
                if (this.draws < that.draws) {
                    return true;
                }
                if (this.draws > that.draws) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Gets the Team Name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
}


/**
 * Class for selection sort.
 */
class SelectionSort {

    /**
     * Sorting of TeamInfo Objects based on Wins, losses, draws
     * using selection sort.
     * Complexity of Selection Sort is O(N^2).
     * Because It uses nested loops.
     * One for loop and a while loop
     * So the complexity would be O(N^2).
     *
     * @param      teams  The teams
     *
     * @return     Returns the sorted array of objects
     */
    public TeamInfo[] selectsort(final TeamInfo[] teams) {
        int min = 0;
        TeamInfo[] sortedteams = teams;
        for (int i = 0; i < sortedteams.length; i++) {
            min = i;
            for (int j = i + 1; j < sortedteams.length; j++) {
                if (sortedteams[min].less(sortedteams[j])) {
                    min = j;
                }
            }
            sortedteams = exchange(sortedteams, min, i);
        }
        return teams;
    }

    /**
     * This method is used to swap the objects in an array.
     *
     * @param      teams  The teams
     * @param      min    The minimum
     * @param      index  The index
     *
     * @return     Returns the array after swapping the objects
     */
    public TeamInfo[] exchange(final TeamInfo[] teams, final int min,
                                final int index) {
        TeamInfo temp = teams[min];
        teams[min] = teams[index];
        teams[index] = temp;
        return teams;
    }
}

/**
 * Class for lead board.
 */
class LeadBoard {
    /**
     * Object of Selection Sort class.
     */
    private SelectionSort sort = new SelectionSort();
    /**
     * Creates the object array of Class TeamInfo.
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
     * Resize Method for Resizing object Array.
     */
    public void resize() {
        teams = Arrays.copyOf(teams, teams.length + 1);
    }

    /**
     * Adds a team to Object Array.
     * Complexity of Add is O(1).
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
     * To Print the Team Names after sorting.
     * Complexity of Print is O(N).
     */
    public void print() {
        TeamInfo[] sortedteams = sort.selectsort(teams);
        for (int i = 0; i < size - 1; i++) {
            System.out.print(sortedteams[i].getName() + ",");
        }
        System.out.println(sortedteams[size - 1].getName());
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
        //Not Using this Constructor.
    }
    /**
     * Main Method for Sorting the Teams using Selection Sort.
     * The complexity of main method is O(N).
     * Because it iterates whenever it has an input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LeadBoard cricketobj = new LeadBoard();
        Scanner scan = new Scanner(System.in);
        String[] info = null;
        while (scan.hasNext()) {
            info = scan.nextLine().split(",");
            cricketobj.addTeam(new TeamInfo(info[0], Integer.parseInt(info[1]),
                Integer.parseInt(info[2]), Integer.parseInt(info[2 + 1])));
        }
        cricketobj.print();
    }
}