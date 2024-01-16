package controllers;

import java.io.IOException;

import dao.UserDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = Long.parseLong(request.getParameter("id"));
		UserDAOFactory.getDAO().delete(userId);
		
		/**
		 * Após deletar, chama o método para listar os usuários novamente
		 */
		
		CreateAndFindUser cafu = new CreateAndFindUser();
		cafu.doGet(request, response);
	}

}
