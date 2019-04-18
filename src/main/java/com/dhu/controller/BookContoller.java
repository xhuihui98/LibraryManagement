package com.dhu.controller;

import com.dhu.pojo.Book;
import com.dhu.pojo.Borrow;
import com.dhu.pojo.Message;
import com.dhu.pojo.Reader;
import com.dhu.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookContoller {
    @Autowired
    LibraryService service;


    @RequestMapping(value = "/book")
    String main(Model model){
        List<Book> book_list = service.showBookHots();
        model.addAttribute("book_list",book_list);
        return "book";
    }

    @RequestMapping(value = "/homepage")
    String homepage(Model model){
        List<Book> book_list = service.showBookHots();
        model.addAttribute("book_list",book_list);
        return "homepage";
    }

    @PostMapping(value="/main")
    private String doSave(@ModelAttribute Book book){
        service.addBook(book);
        return "redirect:book";
    }

    @RequestMapping(value = "/api/book")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object showBook() {
        List<Book> book_list = service.showBook();
        return book_list;
    }

    @RequestMapping(value = "/api/bookhots")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object bookBots() {
        List<Book> book_list = service.showBookHots();
        return book_list;
    }




    @RequestMapping(value = "/api/deletebook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object dele(@RequestBody Book book){
        System.out.println(book.toString());
        Message ms = null;
        int temp = service.deleteBookById(book);
        System.out.println(temp);
        if(temp == 0){
            ms = new Message(false);
        }
        else {
            ms = new Message(true);
        }
        return ms;
    }

    @RequestMapping(value = "/api/insertbook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object inse(@RequestBody Book book){
        int res = service.addBook(book);
        if(res == 0)
            return new Message(false);
        else
            return new Message(true);
    }

    @RequestMapping(value = "/api/modifybook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object modi(@RequestBody Book book){

        System.out.println(book);
        service.modifyBook(book);
        return new Message(true);

    }

    @RequestMapping(value = "/api/bookbd")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object selectBook(@RequestBody Book book) {
        System.out.println(book);
        List<Book> book_list = service.selectBookByCondition(book);
        return book_list;
    }

    @RequestMapping(value = "/api/borrowbook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object borrowBook(@RequestBody Borrow borrow) {
        int res = 0;
        if(service.checkBorrow(borrow) == null){
            res = service.borrowBook(borrow);
            if(res == 0)
                return new Message(false);
            else{
                Reader reader = service.selectReaderById(borrow.getReaderId());
                reader.setHasBorrowed(reader.getHasBorrowed()+1);
                Book book = service.findById(borrow.getBookId());
                book.setBorrowCount(book.getBorrowCount()+1);
                service.updateBorrowCount(book);
                service.updateHasBorrowed(reader);
                return new Message(true);
            }

        }
        else{
            return new Message(false);
        }



    }

    @RequestMapping(value = "/api/showborrow")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object  showBorrow(@RequestBody Reader reader) {
        System.out.println(reader);
       return service.showBorrow(reader.getReaderId());



    }
    @RequestMapping(value = "/api/returnbook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object  showBorrow(@RequestBody Borrow borrow) {
        System.out.println(borrow);
        int i = 0;
        i = service.returnBook(borrow);
        if(i == 0){
            //删除失败
            return new Message(false);
        }
        else{
            //归还成功
            Reader reader = service.selectReaderById(borrow.getReaderId());
            reader.setHasBorrowed(reader.getHasBorrowed()-1);
            service.updateHasBorrowed(reader);
            return new Message(true);
        }
    }
    @RequestMapping(value = "/api/renewbook")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public Object renewBook(@RequestBody Borrow borrow) {
        System.out.println(borrow);
        int res = 0;
        res = service.renewBook(borrow);
        if(res == 0)
            return new Message(false);
        else
            return new Message(true);

    }
}

