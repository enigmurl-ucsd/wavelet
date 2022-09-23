/**
 * Referenced and modified from https://www.tutorialspoint.com/servlets/servlets-first-example.htm
 * Author: Yasushi Oh
 * Description: This file serves as a servlet wrapper that 
 * initializes a servlet web application. It takes in a 
 * wildcard url pattern(allowing any urls) and prints the result
 * of the requested url after processing the url
 * in ProgramClass.handleRequest(url). The user who's only 
 * expected to modify the code in ProgramClass will handle the
 * logic code of all the incoming requests.
 */

import java.io.*; //for PrintWriter
//servlet jar using Apache Tomcat api
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ServletWrapper extends HttpServlet {

   //the ProgramClass where users write their logic code
   private ProgramClass program;

   //Initialization once the server starts
   public void init() throws ServletException {
      program = new ProgramClass();
   }

   //Runs what's inside once getting a Get reuqest from the corresponding
   //url(any url since wildcard)
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      //the string to write
      String ret = "";

      //if there's no quety string, just return
      //the requested url
      if (request.getQueryString() == null) {
         ret = program.handleRequest(
               request.getRequestURI());
      } else {
         //we reconstruct the query string here
         ret = program.handleRequest(
               request.getRequestURI() + "?" + request.getQueryString());
      }

      //form the return string and write it on the browser
      PrintWriter out = response.getWriter();
      out.println(ret);
   }

   public void destroy() {
      // do nothing.
   }
}
