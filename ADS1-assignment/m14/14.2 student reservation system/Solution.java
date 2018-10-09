import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for details.
 */
class Details {
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * { var_description }
     */
    private String dob;
    /**.
     * { var_description }
     */
    private int sub1;
    /**.
     * { var_description }
     */
    private int sub2;
    /**.
     * { var_description }
     */
    private int sub3;
    /**.
     * { var_description }
     */
    private int tot;
    private String cat;
    private String[] dobs;
    Details() {

    }
    Details(String sName, String dob1, int subOne, int subTwo,
            int subThree, int total, String category) {
        this.name = sName;
        this.dob = dob1;
        this.sub1 = subOne;
        this.sub2 = subTwo;
        this.sub3 = subThree;
        this.tot = total;
        this.cat = category;
        convertDate();
    }
    int[] conv;
    public void convertDate() {
        dobs = this.dob.split("-");
        conv = new int[dobs.length];
        for (int i = 0; i < dobs.length; i++) {
            conv[i] = Integer.parseInt(dobs[i]);
        }
    }
    public int compareTo(Details obj) {
        if (this.tot < obj.tot) {
            return 1;
        }
        if (this.tot > obj.tot) {
            return -1;
        } else {
            if (this.sub3 < obj.sub3) {
                return 1;
            }
            if (this.sub3 > obj.sub3) {
                return -1;
            } else {
                if (this.sub2 < obj.sub2) {
                    return 1;
                }
                if (this.sub2 > obj.sub2) {
                    return -1;
                } else {
                    if (this.conv[2] < obj.conv[2]) {
                        return 1;
                    }
                    if (this.conv[2] > obj.conv[2]) {
                        return -1;
                    } else {
                        if (this.conv[1] < obj.conv[1]) {
                            return 1;
                        }
                        if (this.conv[1] > obj.conv[1]) {
                            return -1;
                        } else {
                            if (this.conv[0] < obj.conv[0]) {
                                return 1;
                            }
                            if (this.conv[0] > obj.conv[0]) {
                                return -1;
                            }
                        }
                    }
                    return 0;
                }

            }
        }
    }
    public String toString() {
        String str;
        str = this.name + "," + this.tot + "," + this.cat;
        return str;
    }
    public String getCategory() {
        return this.cat;
    }
    public String getName() {
        return this.name;
    }
}
class Results {
    Details[] details;
    int size;
    int vac;
    int un;
    int bc;
    int sc;
    int st;
    Details obj1 = new Details();
    Results() {
        details = new Details[20];
        size = 0;
    }
    public void addVac(int vace, int unr, int bc1, int sc1, int st1) {
        this.vac = vace;
        this.un = unr;
        this.bc = bc1;
        this.sc = sc1;
        this.st = st1;
    }
    public void add(Details obj) {
        if (details.length == size) {
            resize();
        }
        details[size++] = obj;
    }
    // public void delete(Details obj){
    //     if(size==0){
    //         return;
    //     }
    //     for(int i = 0;i<size-1;i++){
    //         if(details[i].getName().equals(obj.getName())){
    //             while(i<size){
    //                 details[i] = details[i+1];
    //                 i++;
    //             }
    //             size--;
    //         }
    //     }
    Insertion insobj = new Insertion();
    // }
    public void sort() {
        insobj.sort(details, size);
    }
    public void resize() {
        details = Arrays.copyOf(details, details.length + 1);
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(details[i].toString());
        }
    }
    public boolean contains(Details obj) {
        for (int i = 0; i < size; i++) {
            if (obj.getName().equals(details[i].getName())) {
                return false;
            }
        }
        return true;
    }
    public void allotment() {
        Details[] temp = new Details[vac];
        int tempSize = 0;
        int i;
        int countbc = 0;
        int countsc = 0;
        int countst = 0;
        for (i = 0; i < un; i++) {
            // System.out.println(details[i].toString());
            temp[tempSize++] = details[i];
            // delete(details[i]);
        }
        int j = i;
        while (countbc < bc && j < size) {
            if (details[j].getCategory().equals("BC")) {
                // System.out.println(details[j].toString());
                if (contains(details[j])) {
                    temp[tempSize++] = details[j];
                }
                countbc++;
                // delete(details[j]);

            }
            j++;
        }

        int l = i;
        while (countst < st && l < size) {
            if (details[l].getCategory().equals("ST")) {
                // System.out.println(details[l].toString());
                if (contains(details[l])) {
                    temp[tempSize++] = details[l];
                }

                countst++;
                // delete(details[l]);

            }
            l++;
        }



        int k = i;
        while (countsc < sc && k < size) {
            if (details[k].getCategory().equals("SC")) {
                if (contains(details[k])) {
                    temp[tempSize++] = details[k];
                }
                // System.out.println(details[k].toString());
                countsc++;
                // delete(details[k]);

            }
            k++;
        }
        if (countbc < bc) {
            int m = i;
            while (countbc < bc) {
                if (contains(details[m])) {
                    temp[tempSize++] = details[m];
                }
                // System.out.println(details[m].toString());
                countbc++;
                m++;
                i++;

            }
        }
        if (countst < st) {
            int n = i;
            while (countst < st) {
                // System.out.println(details[n].toString());
                if (contains(details[n])) {
                    temp[tempSize++] = details[n];
                }
                countst++;
                n++;
                i++;

            }
        }
        if (countsc < sc) {
            int o = i;
            while (countsc < sc) {
                // System.out.println(details[o].toString());
                if (contains(details[o])) {
                    temp[tempSize++] = details[o];
                }
                countsc++;
                o++;
                i++;

            }
        }
        insobj.sort(temp, tempSize);
        for (int a = 0; a < tempSize; a++) {
            System.out.println(temp[a].toString());
        }




    }
}
class Insertion {

    public Insertion() {}
    public void sort(Details[] a, int size) {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }

        }
    }
    public boolean less(Details b1, Details b2) {
        return b1.compareTo(b2) < 0;

    }
    public void exchange(Details[] a, int i, int j) {
        Details swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
class Solution {
    public static void main(String[] args) {
        Results resultObj = new Results();
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int vac = Integer.parseInt(scan.nextLine());
        int un = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        resultObj.addVac(vac, un, bc, sc, st);
        for (int i = 0; i < N; i++) {
            String[] tokens = scan.nextLine().split(",");
            resultObj.add(new Details(tokens[0], tokens[1], Integer.parseInt(
                                          tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(
                                          tokens[4]), Integer.parseInt(tokens[5]), tokens[6]));
        }
        resultObj.sort();
        resultObj.print();
        System.out.println();
        resultObj.allotment();
    }
}
