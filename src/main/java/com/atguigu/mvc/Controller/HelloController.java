package com.atguigu.mvc.Controller;
import com.atguigu.aop.User;
import com.atguigu.mvc.doman.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/param")
public class HelloController
{
    @RequestMapping("/testParam")
    @ResponseBody
    public String testParam(String username,String password){
        System.out.println("执行了.....");
        System.out.println("用户名："+username+"密码："+password);
        return "successController";
    }

//    请求参数绑定把数据封装到javaBean的类中
    @RequestMapping(value="/saveAccount",method = RequestMethod.POST)
    @ResponseBody
    public String saveAccount(Account account){
        System.out.println("执行了....");
        System.out.println(account);
        return "successAccount";
    }

    //
    @RequestMapping("/testServlet")
    @ResponseBody
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了.....");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    @ResponseBody
    public String testRequtstBody(@RequestBody String body){
        System.out.println("执行了.....");
        System.out.println(body);
        return "success";
    }

    /**
     * 测试testPathVariable注解
     */
    @RequestMapping("/testPathVariable")
    @ResponseBody
    public String testPathVariable(@PathVariable String id){
        System.out.println("执行了.....");
        System.out.println(id);
        return "success";
    }

    /**
     * 测试RequestHead
     */
    @RequestMapping("/requestHead")
    @ResponseBody
    public String requestHead(@RequestHeader(value="Accept") String header){
        System.out.println("执行了.....");
        System.out.println(header);
        return "success";
    }

    /**
     * 测试cookieValue
     */
    @RequestMapping("/cookieValue")
    @ResponseBody
    public String cookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println("执行了.....");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * 返回String类型
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小美");
        user.setId(10);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 是void
     * 请求转发一次请求，不用编写项目的名称????????
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了");
        //编写请求转发的程序
        request.getRequestDispatcher("templates/successagain.jsp").forward(request,response);
    }
}









