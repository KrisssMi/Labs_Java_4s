package tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class MKVsubmit extends TagSupport {
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    public int doStartTag() {
        String output = String.format("<input type=\"submit\" value=\"%s\">", label);   // указываем значение кнопки
        JspWriter jw = pageContext.getOut();                                            // получаем объект для вывода в браузер

        try {
            jw.print(output);                                                   // выводим в браузер
        } catch (IOException e) {
            e.printStackTrace();                                                // выводим ошибку
        }
        return EVAL_BODY_INCLUDE;                                             // возвращаем результат выполнения тега
    }
}
