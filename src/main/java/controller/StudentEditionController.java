package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.domaine.Student;
import modele.metier.IStudentMetier;
import modele.metier.StudentMetierImpl;


@WebServlet("/StudentEditionController")
public class StudentEditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
	IStudentMetier metier = null;
    public StudentEditionController() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier = new StudentMetierImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tableau pour stocker les erreurs éventuelles
		ArrayList erreurs = new ArrayList();

		// Récupérer les paramètres du formulaire
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String id = request.getParameter("id");

		// Contrôler les valeurs saisies
		if (name == null || name.equals(""))
			erreurs.add("Veuillez remplir le champ name");

		if (address == null || address.equals(""))
			erreurs.add("Veuillez remplir le champ address");

		if (email == null || email.equals(""))
			erreurs.add("Veuillez remplir le champ email");

		if (erreurs.size() != 0) {
			// en cas d'existence de champs nulls
			request.setAttribute("err", erreurs);
			// reenvoyer les paramètres du formulaire s'ils existent sous forme
			// d'un objet 'User' passé comme attribut addressmé "user"
			Student s = new Student( name, address, email,0);
			request.setAttribute("student", s);

			// retourner au formulaire
			request.getRequestDispatcher("StudentForm.jsp").forward(request, response);
		}
		else // La saisie est correcte
		{

			// lire à partir de la session ( portée session)
			HttpSession session = request.getSession(true);
			// Récupérer le tableau des users de la session
			List<Student> studentsStore = (ArrayList<Student>) session.getAttribute("listOfStudents");

			// Mode Ajout
			if (id != null && id.equals("0")) {

				// Créer une instance "User" en lui passant une valeur pour l'id et les champs
				// récupérés
				Student s = new Student(name, address, email, 0);

				// Ajouter le nouvel objet dans la base de données
				metier.addStudent(s);
			}
			// Mode Edition
			else {
				// Modifier l'objet en question
//				Student u = new User(Integer.parseInt(id), address, email, name, password);
//				metier.updateUser(u);

			}

			// Charger la liste des utilisateurs;
			studentsStore = metier.listStudents();

			// passer le tableau dans le session
			session.setAttribute("listOfUsers", studentsStore);
			// passer à la vue de liste des utilisateurs
			request.getRequestDispatcher("StudentList.jsp").forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// Récupérer les paramètres
//		String id = request.getParameter("id");
//		String mode = request.getParameter("mode");
//
//		// lire le tableau des utilisateurs stocké dans la session
//		HttpSession session = request.getSession(true);
//		// Récupérer le tableau des users de la session
//		List<User> usersStore = (ArrayList<User>) session.getAttribute("listOfUsers");
//
//		// gérer le mode "Edition"
//		if (mode != null && mode.equals("Edition")) {
//			
//			User u = metier.getUserById(Integer.parseInt(id));
//			// passer l'objet trouvé comme attribut dans la requête
//			request.setAttribute("user", u);
//			// passer au formulaire
//			request.getRequestDispatcher("UserForm.jsp").forward(request, response);
//		}
//		// gérer le mode "Suppression"
//		if (mode != null && mode.equals("Suppression")) {
//
//			int index = Integer.parseInt(id);
//			
//			// Supprimer dans la base de données
//			metier.deleteUser(index);
//
//			// Charger la liste des utilisateurs;
//			usersStore = metier.listUsers();
//			// Mettre à jour dans le session
//			session.setAttribute("listOfUsers", usersStore);
//			// passer à la liste
//			request.getRequestDispatcher("UserList.jsp").forward(request, response);
//		}
		doGet(request, response);


	}

	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		User u = (User) session.getAttribute("user");
//		if (u == null) {
//			request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
//		} 
//		else {
//			super.service(request, response);
//		}
//	}
}