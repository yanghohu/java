package hello.hellospring.Contoller;

import hello.hellospring.repository.IDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class helloController {

    @Autowired
    private SqlSession sqlSession;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model) {
        model.addAttribute("name", name);
        return "hello-template.html";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        IDao dao = sqlSession.getMapper(IDao.class);

        model.addAttribute("list", dao.listDao());

        return "/list";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {

        return "/writeForm";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        IDao dao = sqlSession.getMapper(IDao.class);
        dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));

        return "redirect:list";
    }

    @RequestMapping("/view")
    public String view() {

        return "/view";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        IDao dao = sqlSession.getMapper(IDao.class);
        dao.deleteDao(request.getParameter("mId"));

        return "redirect:list";
    }
}
