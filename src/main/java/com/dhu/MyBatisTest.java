package com.dhu;


import com.dhu.dao.UserDao;
import com.dhu.pojo.Reader;
import com.dhu.pojo.User;
import com.dhu.service.LibraryService;
import com.dhu.service.LibraryServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    @Autowired
    @Qualifier("LibraryService")
    private LibraryService libraryService;
    public static void main(String[] args) throws IOException{
        SqlSession sqlSession = null;
        String resource = "mybatis-config.xml";//根据全局配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();

            /*
            Book book = new Book("1234567890125","教育","企业JAVA","丁","世纪出版社",35.6,2,0);
            sqlSession.insert("BookMapper.insertbook",book);


        List<Map<String,Object>>list = sqlSession.selectList("BookMapper.searchbook");
        list.forEach(row -> System.out.println(row));*/
        //Book book = new Book("1233369458123","动漫","刀剑神域","川原砾","电击文库",56.6,5,5);
        //sqlSession.update("BookMapper.updatestocknum",4);

        //Reader reader = new Reader("stu1","111111");


        /*
    Reader admin = new Reader("admin","admin",1);
        sqlSession.insert("ReaderMapper.createAdmin",admin);
          */

       // List<Reader> reader_list =  sqlSession.selectList("ReaderMapper.selectReader",5);
        //reader_list.forEach(reader -> System.out.println(reader));
        //List<Book> book_list = sqlSession.selectList("BookMapper.searchbook");
        //book_list.forEach(book -> System.out.println(book));
       // MyBatisTest t = new MyBatisTest();
        //t.test(sqlSession);
        //ReaderDao bd = sqlSession.getMapper(ReaderDao.class);
        //Map<String,Object> params = new HashMap<>();
        //Reader reader = new Reader("admin","admin");
        //params.put("username",reader);
        //List<Reader> list = bd.selectReader(params);
        //list.forEach(reader1 -> System.out.println(reader1));
/*
        ReaderInfoDao re = sqlSession.getMapper(ReaderInfoDao.class);
        ReaderInformation readerInformation = re.selectByLevel(60);
        System.out.println(readerInformation.getAuthority());
        System.out.println(readerInformation);*/
       //ReaderDao dao = sqlSession.getMapper(ReaderDao.class);
        //Integer o = dao.selectIdByUsername("admin");
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User("stu3","stu3");
        userDao.createReader(user);
        sqlSession.commit();
        sqlSession.close();
        //System.out.println(o);


    }
    public void te(){
        System.out.println(5);
        User user = libraryService.login("admin","admin");
        System.out.println(user);
    }


}
