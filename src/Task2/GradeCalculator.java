package Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeCalculator
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of students: ");
		int numStudents = sc.nextInt();

		Map<String, Map<String, Integer>> studentMarks = new HashMap<String, Map<String, Integer>>();

		for (int i = 0; i < numStudents; i++)
		{
			System.out.print("Enter student name: ");
			String studentName = sc.next();

			System.out.print("Enter the No of Subjects: ");
			int numSubjects = sc.nextInt();

			Map<String, Integer> marks = new HashMap<String, Integer>();

			for (int j = 0; j < numSubjects; j++)
			{
				System.out.print("Enter Subject Name : ");
				String subject = sc.next();
				System.out.print("Enter Marks for " + subject + " : ");
				int mark = sc.nextInt();
				marks.put(subject, mark);
			}

			studentMarks.put(studentName, marks);
		}

		System.out.println("\nStudent Marks and Grades:");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Student\tSubjects\t\t\t\tTotalMarks\tAvgPercentage\tGrade");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");

		for (Map.Entry<String, Map<String, Integer>> studentEntry : studentMarks.entrySet())
		{
			String studentName = studentEntry.getKey();
			Map<String, Integer> marks = studentEntry.getValue();

			int totalMarks = calcTotalMarks(marks);
			double avgPercentage = calcAvgPercentage(totalMarks, marks.size());
			String grade = calcGrade(avgPercentage);

			System.out.print(studentName + "\t");

			for (Map.Entry<String, Integer> markEntry : marks.entrySet())
			{
				System.out.print(markEntry.getKey() + " : " + markEntry.getValue() + "\t");
			}

			System.out.println(totalMarks + "\t" + avgPercentage + "%\t\t" + grade);
		}
	}

	private static int calcTotalMarks(Map<String, Integer> marks)
	{
		int totalMarks = 0;

		for (int mark : marks.values())
		{
			totalMarks += mark;
		}

		return totalMarks;
	}

	private static double calcAvgPercentage(int totalMarks, int numSubjects)
	{
		return (totalMarks / numSubjects);
	}

	private static String calcGrade(double avgPercentage)
	{
		if (avgPercentage >= 90)
		{
			return "A";
		} else if (avgPercentage >= 80)
		{
			return "B";
		} else if (avgPercentage >= 70)
		{
			return "C";
		} else if (avgPercentage >= 60)
		{
			return "D";
		} else
		{
			return "F";
		}
	}
}