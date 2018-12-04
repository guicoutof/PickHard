package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;



@WebServlet(name = "gerarTime", urlPatterns = "/gerarTime")
public class ReturnChampionsServlet extends HttpServlet{
	Banco banco = new Banco();
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Banco banco = new Banco();
//		
//		ArrayList<String> champions = banco.gerarTime();
//	
//		resp.setCharacterEncoding("UTF-8");	//Definindo Codificação UTF-8
//		resp.getWriter().println("<html>");
//		resp.getWriter().println("<head>");
//		resp.getWriter().println("<meta charset=\"UTF-8\">");
//		resp.getWriter().println("<title>First Servlet</title>");
//		resp.getWriter().println("</head>");
//		resp.getWriter().println("<body>");
//		resp.getWriter().println("Produto inserido com sucesso");
//		resp.getWriter().println("</body>");
//		
//		req.setAttribute("champions", champions);
//		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		//resp.sendRedirect("produtos.jsp");
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<String> champions = banco.gerarTimeArray();
		req.setAttribute("champions", champions);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
