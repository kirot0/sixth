package com.scggi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdderServlet
 */
@WebServlet("/AdderServlet")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstNum = request.getParameter("firstNum");
		String secondNum = request.getParameter("secondNum");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			int sum = Integer.parseInt(firstNum)+Integer.parseInt(secondNum);
			
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" + 
					"<title>Hello Servlet</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<h5>"+firstNum+"+"+secondNum+"="+sum+"</h5>" +
					"</body>\r\n" + 
					"</html>");
		}catch(Exception e) {
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"ko\">\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" + 
					"<title>오류</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<h5>"+"add operation error"+"</h5>" +
					"</body>\r\n" + 
					"</html>");			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
