package servlets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *        
 * @author Harry Beentjes
 * 
 * todo: zoekuit: Connection Refused: connect
 */
public class ProxyServlet extends HttpServlet {
    
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
   protected void doGet(@SuppressWarnings("unused")
    final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse)
            throws IOException {
        
        URL url = new URL("http://localhost:9080/PlayWeb/other");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write("string=" + "hallo");
        writer.write("<div style=\"background-color:#FF0000\">");
        writer.write("Dit is van ProxyServlet!");
        writer.write("</div>");
        writer.close();
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                connection.getInputStream()));
        
        PrintWriter out = httpServletResponse.getWriter();
        String result;
        while ((result = in.readLine()) != null) {
            out.println(result);
        }
        in.close();
      }
}
