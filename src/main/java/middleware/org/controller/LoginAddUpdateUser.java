package middleware.org.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class LoginAddUpdateUser
 */
@WebServlet("/loginAddGetUpdate")
public class LoginAddUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(LoginAddUpdateUser.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAddUpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("doPost method of entry servlet has been called.");
		String resp = "";
		PrintWriter out = response.getWriter();
		LOG.info("Get Session: " + request.getSession(false));
		if (request.getSession(false) == null) {
			resp = "{\"error\" : \" Please login : http://localhost:8888/AddGetUserProject/login.html\"}";
		} else {
			StringBuffer jb = new StringBuffer();
			String line = null;
			BufferedReader reader = null;
			try {
				reader = request.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) {
				LOG.error("Exception occurs in servlet...." + e.getMessage(), e);

			} finally {
				reader.close();
			}
			String json = new String(jb.toString().getBytes("UTF-8"));

		
	}

}
