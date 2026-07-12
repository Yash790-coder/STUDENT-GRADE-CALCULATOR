import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static double[] calculateResults(List<Double> marks) {
        if (marks == null || marks.isEmpty()) {
            throw new IllegalArgumentException("At least one subject mark is required.");
        }

        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = totalMarks / marks.size();
        String grade = calculateGrade(averagePercentage);

        return new double[]{totalMarks, averagePercentage, grade.equals("A+") ? 5 : grade.equals("A") ? 4 : grade.equals("B") ? 3 : grade.equals("C") ? 2 : grade.equals("D") ? 1 : 0};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjectCount;
        try {
            subjectCount = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer for the number of subjects.");
            return;
        }

        List<Double> marks = new ArrayList<>();
        for (int i = 1; i <= subjectCount; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + i + " (out of 100): ");
                String input = scanner.nextLine().trim();
                try {
                    double mark = Double.parseDouble(input);
                    if (mark >= 0 && mark <= 100) {
                        marks.add(mark);
                        break;
                    }
                } catch (NumberFormatException ignored) {
                }
                System.out.println("Please enter a valid number between 0 and 100.");
            }
        }

        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        double averagePercentage = totalMarks / marks.size();
        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
