package control;

import Entity.CodeEntity;
import Entity.SubjectEntity;
import model.Code;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CT_List_Code", urlPatterns = "/CT_List_Code")
public class CT_List_Code extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String subid = request.getParameter("id");
            String name1 = request.getParameter("name1");
            CodeEntity pr = new CodeEntity();
            int sub = Integer.parseInt(subid);
            List<Code> value = pr.getAllByCode(sub);
//            System.out.print(value.get(1).getTc());
            request.setAttribute("list",value);
            request.setAttribute("id",subid);
            request.setAttribute("name1",name1);
            request.getRequestDispatcher("/List-code.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
