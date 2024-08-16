package Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestApp
{
	private static ArrayList<Student> listObj = new ArrayList<Student>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		while (true)
		{
			System.out.println("\n-----------------------------------------------");
			System.out.println("            Student Management System          ");
			System.out.println("-----------------------------------------------");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Search Student By RNO");
			System.out.println("4. Update Student");
			System.out.println("5. Remove Student");
			System.out.println("6. Sorting");
			System.out.println("7. Exit Application");
			System.out.println("-----------------------------------------------");

			System.out.println("Enter the choice : ");
			int choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				addStudent();
				break;

			case 2:
				dispAllStudents();
				break;

			case 3:
				searchStudent();
				break;

			case 4:
				updateStudent();
				break;

			case 5:
				removeStudent();
				break;

			case 6:
				System.out.println("----------------------------------");
				System.out.println("        Choose Sorting style      ");
				System.out.println("----------------------------------");
				System.out.println("1) Rno Wise Sorting");
				System.out.println("2) Name Wise Sorting");
				System.out.println("3) Std Wise Sorting");
				System.out.println("4) Marks Wise Sorting");
				System.out.println("5) exit");
				System.out.println("----------------------------------");

				System.out.println("Enter choice : ");
				choice = sc.nextInt();

				switch (choice)
				{
				case 1:
					System.out.println("1) ASC");
					System.out.println("2) DESC");
					System.out.println("3) exit");

					System.out.println("Enter choice : ");
					choice = sc.nextInt();

					switch (choice)
					{
					case 1:
						Collections.sort(listObj, new RnoWiseComparator());
						System.out.println("Student Rno By Sorting in ASC Successfully!");
						break;

					case 2:
						Collections.sort(listObj, new RnoWiseComparator());
						Collections.reverse(listObj);
						System.out.println("Student Rno By Sorting in DESC Successfully!");
						break;

					case 3:
						exitApplication();
						break;

					default:
						System.out.println("Invalid choice !");
						break;
					}
					break;

				case 2:
					System.out.println("1) ASC");
					System.out.println("2) DESC");
					System.out.println("3) exit");

					System.out.println("Enter choice : ");
					choice = sc.nextInt();

					switch (choice)
					{
					case 1:
						Collections.sort(listObj, new NameWiseComparator());
						System.out.println("Student Name By Sorting in ASC Successfully!");
						break;

					case 2:
						Collections.sort(listObj, new NameWiseComparator());
						Collections.reverse(listObj);
						System.out.println("Student Name By Sorting in DESC Successfully!");
						break;

					case 3:
						exitApplication();
						break;

					default:
						System.out.println("Invalid choice !");
						break;
					}
					break;

				case 3:
					System.out.println("1) ASC");
					System.out.println("2) DESC");
					System.out.println("3) exit");

					System.out.println("Enter choice : ");
					choice = sc.nextInt();

					switch (choice)
					{
					case 1:
						Collections.sort(listObj, new StdWiseComparator());
						System.out.println("Student Std By Sorting in ASC Successfully!");
						break;

					case 2:
						Collections.sort(listObj, new StdWiseComparator());
						Collections.reverse(listObj);
						System.out.println("Student Std By Sorting in DESC Successfully!");
						break;

					case 3:
						exitApplication();
						break;

					default:
						System.out.println("Invalid choice !");
						break;
					}
					break;

				case 4:
					System.out.println("1) ASC");
					System.out.println("2) DESC");
					System.out.println("3) exit");

					System.out.println("Enter choice : ");
					choice = sc.nextInt();

					switch (choice)
					{
					case 1:
						Collections.sort(listObj, new MarksWiseComparator());
						System.out.println("Student Marks By Sorting in ASC Successfully!");
						break;

					case 2:
						Collections.sort(listObj, new MarksWiseComparator());
						Collections.reverse(listObj);
						System.out.println("Student Marks By Sorting in DESC Successfully!");
						break;

					case 3:
						exitApplication();
						break;

					default:
						System.out.println("Invalid choice !");
						break;
					}
					break;

				case 5:
					exitApplication();
					break;

				default:
					System.out.println("Invalid choice !");
					break;
				}
				break;

			case 7:
				exitApplication();
				break;

			default:
				System.out.println("Invalid choice. Please try again.");

			} // end of switch
		} // end of while
	}

	private static void addStudent()
	{
		System.out.println("\n-----------------------------------------------");
		System.out.println("            Add Student                        ");
		System.out.println("-----------------------------------------------");

		Boolean flag = false;
		Student objScan = new Student();
		objScan.scanData();

		for (int i = 0; i < listObj.size(); i++)
		{
			Student existingObj = listObj.get(i);
			if (objScan.getRno() == existingObj.getRno())
			{
				flag = true;
				break;
			}
		}

		if (flag)
		{
			System.out.println("RNO already exists. Please enter a unique RNO.");
		} else
		{
			listObj.add(objScan);
			System.out.println("Student added successfully!");
		}
	}

	private static void dispAllStudents()
	{
		System.out.println("\n-----------------------------------------------");
		System.out.println("            Display All Students              ");
		System.out.println("-----------------------------------------------");

		if (listObj.isEmpty())
		{
			System.out.println("No students found!");
		} else
		{
			for (int i = 0; i < listObj.size(); i++)
			{
				Student s = listObj.get(i);
				s.dispData();
				System.out.println();
			}
		}
	}

	private static void searchStudent()
	{
		System.out.println("\n-----------------------------------------------");
		System.out.println("            Search Student By RNO             ");
		System.out.println("-----------------------------------------------");

		Boolean flag = false;
		int i = 0;
		System.out.println("Enter Rno You Wants to Search in Record : ");
		int searchRno = sc.nextInt();

		for (i = 0; i < listObj.size(); i++)
		{
			Student searchObj = listObj.get(i);
			if (searchRno == searchObj.getRno())
			{
				flag = true;
				break;
			}
		}

		if (flag)
		{
			Student searchObj = listObj.get(i);
			searchObj.dispData();
			System.out.println("Student found!");
		} else
		{
			System.out.println("Student not found!");
		}
	}

	private static void updateStudent()
	{
		System.out.println("\n-----------------------------------------------");
		System.out.println("            Update Student                    ");
		System.out.println("-----------------------------------------------");

		boolean flag = false;
		int i = 0;
		System.out.println("Enter Rno You Wants to Update in Record : ");
		int updateRno = sc.nextInt();

		for (i = 0; i < listObj.size(); i++)
		{
			Student updateObj = listObj.get(i);
			if (updateRno == updateObj.getRno())
			{
				flag = true;
				break;
			}
		}

		if (flag)
		{
			Student updateObj = listObj.get(i);
			updateObj.updateData();
			listObj.set(i, updateObj);
			System.out.println("Student updated successfully!");
		} else
		{
			System.out.println("Student not found!");
		}
	}

	private static void removeStudent()
	{
		System.out.println("\n-----------------------------------------------");
		System.out.println("            Remove Student                    ");
		System.out.println("-----------------------------------------------");

		boolean flag = false;
		int i = 0;
		System.out.println("Enter Rno You Wants to Remove from Record : ");
		int searchRno = sc.nextInt();

		for (i = 0; i < listObj.size(); i++)
		{
			Student searchObj = listObj.get(i);
			if (searchRno == searchObj.getRno())
			{
				flag = true;
				break;
			}
		}

		if (flag)
		{
			listObj.remove(i);
			System.out.println("Student Remove Successfully!");
		} else
		{
			System.out.println("Student not found!");
		}
	}

	private static void exitApplication()
	{
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("======================== Application Closed Successfully ========================");
		System.exit(0);
	}

}
