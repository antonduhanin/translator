import dao.WordDAO;
import entity.Word;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Created by ANTON DUKHANIN on 05.02.2018.
 */
public class MyServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Word word = new Word();

        String wordFromPage = request.getParameter("txt");

        wordFromPage = new String(wordFromPage.getBytes("ISO-8859-1"), "UTF-8");

        wordFromPage = wordFromPage.toLowerCase();

        if (wordFromPage.equals("")) {
            request.setAttribute("translate", "try again");
        }

        //97-122
        //1072-1103
        if ((int) wordFromPage.charAt(0) > 96 && (int) wordFromPage.charAt(0) < 123) {
            word.setEng(wordFromPage);
            word = new WordDAO().translateInRus(word);
            request.setAttribute("translate", word.getRus());
        } else if ((int) wordFromPage.charAt(0) > 1071 && (int) wordFromPage.charAt(0) < 1104) {
            word.setRus(wordFromPage);
            word = new WordDAO().translateInEng(word);
            request.setAttribute("translate", word.getEng());
        } else {

            request.setAttribute("translate","try again");

        }

        request.getRequestDispatcher("/Dictionary.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
