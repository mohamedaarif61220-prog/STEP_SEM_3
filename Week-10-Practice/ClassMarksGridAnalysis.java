public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] totals = new int[names.length];
        int[] subjectTotals = new int[3];

        int topperIndex = 0;

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }

            if (totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }
        }

        System.out.print("Totals ");

        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " " + totals[i]);

            if (i < names.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.print("averages ");

        for (int j = 0; j < 3; j++) {
            double average = (double) subjectTotals[j] / names.length;
            System.out.printf("%.2f", average);

            if (j < 2) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("topper " + names[topperIndex]
            + " (" + totals[topperIndex] + ")");
    }
}