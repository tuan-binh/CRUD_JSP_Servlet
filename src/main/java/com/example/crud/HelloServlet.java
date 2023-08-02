package com.example.crud;

import ra.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<Student> list = new ArrayList<>();

    public void init() {
        list.add(new Student(1, "Nguyễn Văn A", 21));
        list.add(new Student(2, "Nguyễn Văn B", 20));
        list.add(new Student(3, "Nguyễn Văn C", 19));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            showListStudent(req, resp);
        } else {
            switch (action) {
                case "DELETE":
                    // remoev by id
                    list.remove(findById(Integer.parseInt(req.getParameter("id"))));
                    break;
                case "EDIT":
                    // edit by id
                    Student student = findById(Integer.parseInt(req.getParameter("id")));
                    req.setAttribute("data", student);
                    req.getRequestDispatcher("/view/EditStudent.jsp").forward(req, resp);
                    break;
                default:
                    break;
            }
        }
        req.setCharacterEncoding("UTF-8");
        showListStudent(req, resp);
    }

    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", list);
        req.getRequestDispatcher("/view/listStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "ADD":
                // add new student
                addNewStudent(req, resp);
                break;
            case "EDIT":
                // edit student
                finished(req, resp);
                break;
            default:
                break;
        }
        resp.sendRedirect("/hello-servlet");
    }

    private void addNewStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        list.add(new Student(getNewId(), name, Integer.parseInt(age)));
    }

    private void finished(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String newName = req.getParameter("name");
        String newAge = req.getParameter("age");
        Student newStudent = new Student(Integer.parseInt(id), newName, Integer.parseInt(newAge));
        list.set(list.indexOf(findById(Integer.parseInt(id))), newStudent);
    }

    public int getNewId() {
        int idMax = 0;
        for (Student s : list) {
            if (s.getId() > idMax) {
                idMax = s.getId();
            }
        }
        return idMax + 1;
    }

    public Student findById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}