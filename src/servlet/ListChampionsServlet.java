package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;


@WebServlet(name = "listarCampeoes", urlPatterns = "/listarCampeoes")
public class ListChampionsServlet extends HttpServlet {
	Banco banco = new Banco();
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Banco banco = new Banco();
//		champions = banco.exibirCampeoes();
//		
//		req.setAttribute("champions", champions);
//		req.getRequestDispatcher("champions.jsp").forward(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<String> championsGeneral ;
		championsGeneral = banco.exibirCampeoesArray();
		req.setAttribute("championsGeneral", championsGeneral);
		req.getRequestDispatcher("champions.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		banco.inserirCampeoesArray(name);
		doPost(req, resp);
		
	}
	
	
	
	
	
}
