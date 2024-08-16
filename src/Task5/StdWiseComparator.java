package Task5;

import java.util.Comparator;

public class StdWiseComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2)
	{
		if (s1.getStd() > s2.getStd())
		{
			return 1;
		} else if (s1.getStd() < s2.getStd())
		{
			return -1;
		} else
		{
			return 0;
		}
	}
}
