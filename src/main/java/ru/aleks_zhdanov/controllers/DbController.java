package ru.aleks_zhdanov.controllers;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.aleks_zhdanov.HibernateUtil;
import ru.aleks_zhdanov.User;

import java.util.List;

/**
 * Created by alien on 25.12.16.
 */
@Controller
public class DbController {

    private static Session session;

    public DbController(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @RequestMapping("/index.html")
    private String index(Model model) {
        model.addAttribute("list", getListUsers());
        return "WEB-INF/jsp/db.jsp";
    }

    @RequestMapping("/adduser.html")
    private String addUser(@RequestParam(value="name", required=false) String name,
                          @RequestParam(value="sex", required=false) Character sex,
                          @RequestParam(value="age", required=false) Integer age,
                          @RequestParam(value="isadmin", required=false) Boolean isAdmin, Model model){
        if(!name.equals(null) && !name.equals("") && !name.equals(" ") && sex!=null && age!=null && age>0 && isAdmin!=null){
            List<User> users = getListUsers();
            int id=0;
            if(users.size()!=0 && users!=null){
                for (User u:users) {
                    if(id==u.getId())id++;
                }
            }
            User newUser = new User(id, name, sex, age, isAdmin);
            session.save(newUser);
            session.flush();
            model.addAttribute("result", newUser);
        }else {
            model.addAttribute("result", null);
        }
        return "WEB-INF/jsp/adduser.jsp";
    }

    private List<User> getListUsers(){
        String query = "select p from " + User.class.getSimpleName() + " p";
        @SuppressWarnings("unchecked")
        List<User> list = (List<User>) session.createQuery(query).list();
        return list;
    }

    @RequestMapping("/deluseronid.html")
    private String removeUserOnId(int id, Model model){
        User deletUser = (User) session.load(User.class, id);
        if(deletUser!=null) {
            session.delete(deletUser);
            session.flush();
            model.addAttribute("result", deletUser);
        }else {
            model.addAttribute("result", null);
        }
        return "WEB-INF/jsp/deluser.jsp";
    }

    @RequestMapping("/deluseronname.html")
    private String removeUserOnName(String name, Model model){
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        List<User> list = criteria.list();
        if(list!=null || list.size()!=0) {
            for (User u : list) {
                session.delete(u);
            }
            model.addAttribute("result", list);
            session.flush();
        }else{
            model.addAttribute("result", null);
        }
        return "WEB-INF/jsp/deluser.jsp";
    }

    @RequestMapping("/updateuser.html")
    private String updateUser(@RequestParam(value="id", required=false) Integer id,
                              @RequestParam(value="name", required=false) String name,
                              @RequestParam(value="sex", required=false) Character sex,
                              @RequestParam(value="age", required=false) Integer age,
                              @RequestParam(value="isadmin", required=false) Boolean isAdmin, Model model){
        User updateUser = null;
        if(id!=null){
            for (User u:getListUsers()) {
                if(u.getId()==id) updateUser = (User) session.load(User.class, id);
            }
        }
        if(updateUser!=null && !name.equals(null) && name!=null && !name.equals("") && !name.equals(" ")){
            updateUser.setName(name);
        }
        if(updateUser!=null && sex!=null){
            updateUser.setSex(sex);
        }
        if(updateUser!=null && age!=null){
            updateUser.setAge(age);
        }
        if(updateUser!=null && isAdmin!=null){
            updateUser.setAdmin(isAdmin);
        }
        session.update(updateUser);
        session.flush();
        return "index.html";
    }
    @RequestMapping("/searchuser.html")
    private String searchUser(@RequestParam(value="id", required=false) Integer id,
                              @RequestParam(value="name", required=false) String name,
                              @RequestParam(value="sex", required=false) Character sex,
                              @RequestParam(value="age", required=false) Integer age,
                              @RequestParam(value="isadmin", required=false) Boolean isAdmin, Model model){

        Criteria criteria = session.createCriteria(User.class);
        if(id!=null){
            criteria.add(Restrictions.eq("id", id));
        }
        if(!name.equals(null) && name!=null && !name.equals("")){
            criteria.add(Restrictions.eq("name", name));
        }
        if(sex!=null){
            criteria.add(Restrictions.eq("sex", sex));
        }
        if(age!=null){
            criteria.add(Restrictions.eq("age", age));
        }
        if(isAdmin!=null){
            criteria.add(Restrictions.eq("isAdmin", isAdmin));
        }
        List<User> list = criteria.list();
        model.addAttribute("searchlist",list);
        return "index.html";
    }

    @RequestMapping("/add20users.html")
    private String add20Users(){
        for (int a=0;a<20;a++) {
            List<User> users = getListUsers();
            int id = 0;
            if (users.size() != 0 && users != null) {
                for (User u : users) {
                    if (id == u.getId()) id++;
                }
            }
            char[] alfa = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'};
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                name.append(alfa[(int) (Math.random() * alfa.length)]);
            }
            int sexInt = (int) (Math.random() * 10);
            char sex = 'm';
            if (sexInt == 0) sex = 'm';
            else sex = 'f';
            int age = (int) (Math.random() * 100);
            int admInt = (int) (Math.random() * 10);
            boolean adm = false;
            if (admInt == 0) adm = true;
            else adm = false;
            User user = new User(id, name.toString(), sex, age, adm);
            session.save(user);
            session.flush();
        }
        return "index.html";
    }
}
