package modele.metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.dao.DaoImpl;
import modele.dao.DaoInterface;
import modele.domaine.Student;

public class StudentMetierImpl implements IStudentMetier {
	private DaoInterface dao = null;	
	
	public StudentMetierImpl() {
		 dao = new DaoImpl();
	}
	@Override
	public void addStudent(Student u) {
		// TODO Auto-generated method stub
		try {
			// préparer la requête SQL
			PreparedStatement ps = dao.connection.prepareStatement(" insert into studnet values (?,?,?,0)");
			// passer les paramètres
			ps.setString(1, u.getName());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getEmail());
			// executer la requête
			dao.ecrire(ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> listStudentsByName(String name) {
		List<Student> students= new ArrayList<Student>();

		try {
			String sql= "select * from student where name like ?";
			PreparedStatement ps = dao.connection.prepareStatement(sql);
			ps.setString(1,"%"+name+"%");
			ResultSet rs= dao.lire(ps);
			if (rs!=null)
			{
				while(rs.next())
				{
					Student s = new Student(rs.getString("name"), rs.getString("address"), rs.getString("email"),  rs.getInt("matricNo"));
					students.add(s);
				}
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int matricNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudentByMatricNo(int matricNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
