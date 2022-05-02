package modele.metier;

import java.util.List;

import modele.domaine.Student;

public interface IStudentMetier {
	public void addStudent(Student Student);
	public List<Student> listStudents();
	public List<Student> listStudentsByName(String name);
	public void updateStudent(Student student);
	public void deleteStudent(int matricNo);
	public Student getStudentByMatricNo (int matricNo);
}
