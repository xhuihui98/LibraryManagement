package com.dhu.controller;

import com.dhu.pojo.*;
import com.dhu.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private LibraryService libraryService;
    private static List<User> userList;
    public UserController(){
        super();
        userList = new ArrayList<User>();
    }
    @RequestMapping (value = "/welcome")
    public ModelAndView welcome(HttpServletRequest request,ModelAndView mv){
        mv.setViewName("welcome");

        Cookie[] cookies = request.getCookies();
       //跳转到欢迎页面
        if(cookies != null){
            for(Cookie cookie:cookies){
                if (cookie.getName().equals("username")) {
                    mv.addObject("username",cookie.getValue());
                }
                if (cookie.getName().equals("password")) {
                    mv.addObject("password",cookie.getValue());
                }
            }
        }


        return mv;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("pass_confirm") String passconfirm,
            ModelAndView mv
    ){

        mv.setViewName("forward:welcome");
        //用户名为空
        if("".equals(username) || "".equals(passconfirm) || "".equals(password)){
           mv.addObject("message","用户名密码不能为空");
           return mv;
        }
        if(!password.equals(passconfirm)){
            //两次密码不一致
            mv.addObject("message","两次密码不一致");
            return mv;
        }
        if(libraryService.findUserByUsername(username) !=null){
            //用户名已存在
            mv.addObject("message","用户名已存在");
             return mv;
        }
           // libraryService.register(username,password);
            mv.addObject("message","注册成功");
            return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            String check,
            ModelAndView mv,
            HttpSession session,
            HttpServletResponse response
    ){
        if(username.equals("") || password.equals("")){
            mv.addObject("message","用户名和密码不能为空");
            mv.setViewName("forward:welcome");
        }
        else {
            User user = libraryService.login(username,password);
            if (user != null){
                session.setAttribute("user",user);
                if("on".equals(check)){
                    //新建cookie
                    Cookie userNameCookie = new Cookie("username", user.getUserName());
                    Cookie passwordCookie = new Cookie("password", user.getPassword());
                    userNameCookie.setMaxAge(7 *24 * 60 * 60);
                    userNameCookie.setPath("/");
                    passwordCookie.setMaxAge(7 *24 * 60 * 60);
                    passwordCookie.setPath("/");
                    response.addCookie(userNameCookie);
                    response.addCookie(passwordCookie);
                }
                else{
                    //清空cookie
                    Cookie userNameCookie = new Cookie("username", user.getUserName());
                    Cookie passwordCookie = new Cookie("password", user.getPassword());
                    userNameCookie.setMaxAge(0);
                    userNameCookie.setPath("/");
                    passwordCookie.setMaxAge(0);
                    passwordCookie.setPath("/");
                    response.addCookie(userNameCookie);
                    response.addCookie(passwordCookie);
                }
                if(user.getAuthority() == 0){
                    mv.setViewName("redirect:homepage");
                }
                else {
                    mv.setViewName("redirect:admin");
                }
            }
            else{
                mv.addObject("message","登录名或密码错误，请重新输入！");
                mv.setViewName("forward:welcome");
            }
        }
        return mv;
    }


    @GetMapping(value = "/admin")
    public String admin(){
        return "admin";
    }


    @GetMapping(value = "/main")
    String main(Model model){
        return "main";
    }

    @RequestMapping(value = "/api/login")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object userLogin(@RequestBody User user) throws Exception{
        user = libraryService.login(user.getUserName(),user.getPassword());
        return user;
    }

    @RequestMapping(value = "/api/regist")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object useRegist(@RequestBody User user) throws Exception{
        int res  = libraryService.regist(user);
        if(res ==0){
            return new Message(false);
        }
        else{
            libraryService.addReaderInfo(user.getUserId());
            return new Message(true);
        }
    }
    @RequestMapping(value = "/api/readerinfo")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object readerInfo(@RequestBody User user) throws Exception{
        Reader reader = libraryService.selectReaderById(user.getUserId());
        System.out.println(reader);
        return  reader;
    }

    @RequestMapping(value = "/api/modifyreader")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object modireader(@RequestBody Reader reader){

        System.out.println(reader);
        int res = libraryService.modifyReader(reader);
        if(res == 0){
            return new Message(false);
        }
        else{
            return new Message(true);
        }
    }

    @RequestMapping(value = "/api/readerinf")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object showReader() throws Exception{
        Reader reader = libraryService.selectReaderById(5);
        System.out.println(reader);
        System.out.println(reader.getAuthority());
        return  reader;
    }

    @RequestMapping(value = "/api/borrow")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object showBorrow() throws Exception{
        List<Borrow> list = libraryService.selectBorrowByReader(5);
        return  list;
    }
    @RequestMapping(value = "/api/showuser")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object showUser() throws Exception{
        List<User> list = libraryService.selectUserByAuthority(0);
        return  list;
    }
    @RequestMapping(value = "/api/showadmin")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object showAdmin() throws Exception{
        List<User> list = libraryService.selectUserByAuthority(1);
        return  list;
    }

    @RequestMapping(value = "/api/deleteuser")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object deleUser(@RequestBody User user){
        if(user == null){
            return new Message(false);
        }
        libraryService.deleteUserById(user.getUserId());
        Message ms = null;

            ms = new Message(true);

        return ms;
    }

    @RequestMapping(value = "/api/usersearch")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object selectBook(@RequestBody User user) {
        List<User> list = new ArrayList<>();
        User temp = null;
        if(user == null){
            return new Message(false);
        }

        else{
            if(user.getUserName() != null && !user.getUserName().equals("")){
                temp = libraryService.findUserByUsername(user.getUserName());
            }
            else{
                temp = libraryService.findUserById(user.getUserId());
            }
        }
    if(temp != null){
        list.add(temp);
        return list;
    }
    else {
        return new Message(false);
    }

    }

    @RequestMapping(value = "/api/addadmin")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object addAdmin(@RequestBody User user){
        if(user == null){
            return new Message(false);
        }
        int i = libraryService.addadmin(user);
        if(i == 0)
        return new Message(false);
        else
            return new Message(true);


    }
}
