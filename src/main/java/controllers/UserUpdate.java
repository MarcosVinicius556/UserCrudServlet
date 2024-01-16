package controllers;

import java.io.IOException;

import dao.UserDAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserUpdate() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = Long.parseLong(request.getParameter("id"));
		User user = UserDAOFactory.getDAO().findById(userId);
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("formUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("nascimento");
		String situacao = request.getParameter("situacao");
		
		User user = new User(id, nome, cpf, nascimento, situacao);
		
		UserDAOFactory.getDAO().update(user);
		
		CreateAndFindUser cafu = new CreateAndFindUser();
		cafu.doGet(request, response);
	}

}
