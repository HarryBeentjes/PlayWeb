package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *        
 * @author Harry Beentjes
 */
public class OtherServlet extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    void test() throws Exception {
        throw new Exception("");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
   protected void doGet(
          final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse)
            throws IOException {
        
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("text/html");
        
        //ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        PrintWriter out = httpServletResponse.getWriter();
        
        out.println("<div style=\"background-color:#FF0000\">");
        out.println("Andere Servlet!");
        out.println("</div>");
        out.close();
    }
}
