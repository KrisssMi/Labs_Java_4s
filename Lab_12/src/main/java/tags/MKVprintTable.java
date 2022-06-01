package tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import model.SortMethod;
import requests.SortRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MKVprintTable extends TagSupport {
    public int doStartTag() {
        JspWriter jw = pageContext.getOut();    // получаем объект для вывода в браузер
        try {
            jw.println("<table border=\"1\">" +
                    "<tr>" +
                    "<th>Name</th><th>Speed</th>" +
                    "</tr>");

            SortRequest sortRequest = new SortRequest();    // получаем объект для получения данных из БД
            ArrayList<SortMethod> methods = sortRequest.selectSorts();  // получаем данные из БД

            for (SortMethod method : methods) {             // выводим данные в браузер
                jw.print("<tr><td>" + method.getName() + "</td><td>" + method.getSpeed() + "</td></tr>");
            }
            jw.println("</table>");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
}
