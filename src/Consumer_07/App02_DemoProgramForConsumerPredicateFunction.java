package Consumer_07;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class App02_DemoProgramForConsumerPredicateFunction {

	static void addStudent(ArrayList<Student> l) {
		l.add(new Student("Sunny", 100));
		l.add(new Student("Bunny", 65));
		l.add(new Student("Chinny", 55));
		l.add(new Student("Vinny", 45));
		l.add(new Student("Pinny", 25));
	}

	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		addStudent(al);

		Predicate<Student> p = s -> s.marks >= 60;
		Function<Student, String> f = s -> {
			int marks = s.marks;
			if (marks >= 80)
				return "A[Dictinction]";
			else if (marks >= 60)
				return "B[First Class]";
			else if (marks >= 50)
				return "C[Second Class]";
			else if (marks >= 35)
				return "D[Third Class]";
			else {
				return "E[Failed]";
			}
		};

		Consumer<Student> c = s -> {
			System.out.println("Student Name : " + s.name);
			System.out.println("Student Marks : " + s.marks);
			System.out.println("Student Grade : " + f.apply(s));
			System.out.println();
		};

		for (Student s : al) {
			if (p.test(s)) {
				c.accept(s);
			}
		}

	}
}
