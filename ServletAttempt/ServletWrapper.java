//referenced and modified from https://www.tutorialspoint.com/servlets/servlets-first-example.htm

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ServletWrapper extends HttpServlet {

   private ProgramClass program;

   public void init() throws ServletException {
      // Do required initialization
      program = new ProgramClass();
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String ret = "";

      if (request.getQueryString() == null) {
         ret = program.handleRequest(
               request.getRequestURI());
      } else {
         ret = program.handleRequest(
               request.getRequestURI() + "?" + request.getQueryString());
      }
      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + ret + "</h1>");
   }

   public void destroy() {
      // do nothing.
   }
}
