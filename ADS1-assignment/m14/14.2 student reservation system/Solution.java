import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for students.
 */
class Students {
    /**
     * { StudentInfo Object Array }.
     */
    private StudentInfo[] info;
    /**
     * { num Variable }.
     */
    private int num;
    /**
     * { size of StudentInfo Array }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      data   The data
     */
    Students(final int data) {
        num = data;
        info = new StudentInfo[num];
        size = 0;
    }
    /**
     * { Add Object to Object Array }.
     *
     * @param      stud  The stud
     */
    public void add(final StudentInfo stud) {
        if (size == info.length) {
            resize();
        }
        info[size++] = stud;
    }

    /**
     * { Resizing the Array }.
     */
    public void resize() {
        info = Arrays.copyOf(info, info.length * 2);
    }

    /**
     * Gets the information.
     *
     * @return     The information.
     */
    public StudentInfo[] getInfo() {
        return info;
    }
}


/**
 * Class for category criteria.
 */
class CategoryCriteria {
    /**
     * Constructs the object.
     */
    private CategoryCriteria() {
        //Unused.
    }
    /**
     * { Object for Merge Class }.
     */
    private Merge mergee = new Merge();
    /**
     * { No.of applied }.
     */
    private int applied;
    /**
     * { No.of Vacancies }.
     */
    private int vacancies;
    /**
     * { No.of Unrevacancies }.
     */
    private int urevacancies;
    /**
     * { No.of BC Vacancies }.
     */
    private int bcvac;
    /**
     * { No.of SC Vacancies }.
     */
    private int scvac;
    /**
     * { No.of ST Vacancies }.
     */
    private int stvac;
    /**
     * { Size of the Array }.
     */
    private int asize;
    /**
     * { Duplicate array for Sorted Objects }.
     */
    private StudentInfo[] dupSorted;
    /**
     * { size of the Object Array }.
     */
    private int size;
    /**
     * { Array to store objects according category }.
     */
    private StudentInfo[] catSorted;
    /**
     * Constructs the object.
     *
     * @param      app     The application
     * @param      vac     The vac
     * @param      urev    The urev
     * @param      bv      { BC Vacancies }
     * @param      sv      { SC Vacancies }
     * @param      stv     The stv
     * @param      sorted  The sorted
     */
    CategoryCriteria(final int app, final int vac, final int urev,
        final int bv, final int sv, final int stv, final StudentInfo[] sorted) {
        applied = app;
        vacancies = vac;
        urevacancies = urev;
        bcvac = bv;
        scvac = sv;
        stvac = stv;
        dupSorted = sorted;
        asize = 0;
        size = sorted.length;
        catSorted = new StudentInfo[vacancies];

    }

    /**
     * { Checks whether the Object contained in Array }.
     *
     * @param      student  The student
     *
     * @return     { Returns true id=f contains else false }
     */
    private boolean contains(final StudentInfo student) {
        for (int i = 0; i < asize; i++) {
            if (catSorted[i].getName().equals(student.getName())) {
                // System.out.println(catSorted[i].getName());
                return true;
            }
        }
        return false;
    }
    /**
     * { Categorising According to Criteria }.
     */
    public void catCriteria() {
        for (int i = 0; i < urevacancies; i++) {
            catSorted[asize++] = dupSorted[i];
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (dupSorted[i].getCategory().equals("BC") && bcvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    bcvac--;
                } else if (dupSorted[i].getCategory().equals("SC")
                    && scvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    scvac--;
                } else if (dupSorted[i].getCategory().equals("ST")
                    && stvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    stvac--;
                }
            }
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (bcvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (scvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (stvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                }
            }
        }
        mergee.insertionSort(
            catSorted, 0, catSorted.length - 1, StudentInfo.comp);
        mergee.print(catSorted);
    }
}


/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { Constructor }.
     */
    private Solution() {
    }
    /**
     * main Method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int studcount = Integer.parseInt(scan.nextLine());
        Merge sort = new Merge();
        int vacancies = Integer.parseInt(scan.nextLine());
        int unrevacancies = Integer.parseInt(scan.nextLine());
        int bcvacancies = Integer.parseInt(scan.nextLine());
        int scvacancies = Integer.parseInt(scan.nextLine());
        int stvacancies = Integer.parseInt(scan.nextLine());
        Students stobj = new Students(studcount);
        String[] sinfo = null;
        for (int i = 0; i < studcount; i++) {
            sinfo = scan.nextLine().split(",");
            stobj.add(new StudentInfo(sinfo[0], sinfo[1],
                Integer.parseInt(sinfo[2]),
                Integer.parseInt(sinfo[2 + 1]),
                Integer.parseInt(sinfo[2 + 2]),
                Integer.parseInt(sinfo[2 + 2 + 1]),
                (sinfo[2 + 2 + 2])));
        }
        StudentInfo[] stinfo = stobj.getInfo();
        sort.insertionSort(stinfo, 0, stinfo.length - 1, StudentInfo.comp);
        sort.print(stinfo);
        System.out.println();
        CategoryCriteria ccobj = new CategoryCriteria(
            studcount, vacancies, unrevacancies, bcvacancies,
            scvacancies, stvacancies, stinfo);
        ccobj.catCriteria();
    }
}
/**
 * Class for merge.
 */
class Merge {
    /**
     * Constructs the object.
     */
    Merge() {
    }

    /**
     * { Insertion Sort }.
     * Worst Case Complexity is O(N^2).
     * It Iterates through out the array two times due to nested for loop.
     *
     * @param      a           { Object Array }
     * @param      lo          The lower
     * @param      hi          The higher
     * @param      comparator  The comparator
     */
    public void insertionSort(StudentInfo[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
    }

    /**
     * { Swapping Elements in the Array }.
     *
     * @param      a     { Student Item }
     * @param      i     { index i }
     * @param      j     { index j }
     */
    private  void exch(StudentInfo[] a, int i, int j) {
        StudentInfo swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * { Less method }.
     *
     * @param      a     { Student Item 1 }
     * @param      b     { Student Item 2 }
     * @param      comp  The component
     *
     * @return     { Returns boolean }
     */
    private boolean less(StudentInfo a, StudentInfo b, Comparator comp) {
        return comp.compare(a, b) < 0;
    }
    /**
     * { Print to print the Output }
     *
     * @param      items  The items
     */
    public void print(StudentInfo[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getName() + "," + items[i].getMarks() + "," + items[i].getCategory());
        }
    }
}
/**
 * Class for student information.
 */
class StudentInfo {
    /**
     * Name.
     */
    private String name;
    /**
     * DOB.
     */
    private int[] dob;
    /**
     * { Subject 1 Marks }.
     */
    private int sub1;
    /**
     * { Sub2 Marks}.
     */
    private int sub2;
    /**
     * { Sub3 Marks }.
     */
    private int sub3;
    /**
     * { Total Marks }.
     */
    private int tmarks;
    /**
     * { Category }.
     */
    private String category;
    /**
     * { No.of Days }.
     */
    private static final int DAYS = 30;

    /**
     * Constructs the object.
     *
     * @param      n         { Name }
     * @param      b         { Date of Birth }
     * @param      s1        The s 1
     * @param      s2        The s 2
     * @param      s3        The s 3
     * @param      totmarks  The totmarks
     * @param      cat       The cat
     */
    StudentInfo(final String n, final String b, final int s1,
        final int s2, final int s3, final int totmarks, final String cat) {
        name = n;
        String[] dupdob = b.split("-");
        dob = new int[dupdob.length];
        for (int i = 0; i < dupdob.length; i++) {
            dob[i] = Integer.parseInt(dupdob[i]);
        }
        sub1 = s1;
        sub2 = s2;
        sub3 = s3;
        tmarks = totmarks;
        category = cat;
    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public int getMarks() {
        return tmarks;
    }

    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * { Comparator. }.
     */
    static Comparator<StudentInfo> comp = new Comparator<StudentInfo>() {
        public int compare(final StudentInfo s1, final StudentInfo s2) {
            if (s2.tmarks - s1.tmarks != 0) {
                return s2.tmarks - s1.tmarks;
            } else if (s2.sub3 - s1.sub3 != 0) {
                return s2.sub3 - s1.sub3;
            } else if (s2.sub2 - s1.sub2 != 0) {
                return s2.sub2 - s1.sub2;
            } else {
                if (s2.dob[2] - s1.dob[2] != 0) {
                    return s2.dob[2] - s1.dob[2];
                } else {
                    int count = 2 * 2 * (2 + 1);
                    return (((count - s1.dob[1]) * DAYS)
                        - ((count - s2.dob[1]) * DAYS));
                }
            }
        }
    };

}