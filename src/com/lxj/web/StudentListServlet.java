package com.lxj.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxj.dao.StudentDao;
import com.lxj.model.PageBean;
import com.lxj.model.Student;
import com.lxj.util.DbUtil;
import com.lxj.util.JsonUtil;
import com.lxj.util.ResponseUtil;
import com.lxj.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * StudentListServlet
 */
public class StudentListServlet extends HttpServlet {

    private DbUtil dbUtil = new DbUtil();
    StudentDao studentDao = new StudentDao();

    private static final long serialVersionUID = -1793767898651385099L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String stuNo = req.getParameter("stuNo");
        String stuName = req.getParameter("stuName");
        String sex = req.getParameter("sex");
        String bbirthday = req.getParameter("bbirthday");
        String ebirthday = req.getParameter("ebirthday");
        String gradeId = req.getParameter("gradeId");

        Student student = new Student();
        if (stuNo != null) {
            student.setStuNo(stuNo);
            student.setStuName(stuName);
            student.setSex(sex);
            if (StringUtil.isNotEmpty(gradeId)) {
                student.setGradeId(Integer.parseInt(gradeId));
            }
        }

        String page = req.getParameter("page");
        String rows = req.getParameter("rows");

        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Connection con = null;
        try {
            con = dbUtil.getConn();
            JSONObject result = new JSONObject();
            JSONArray jsonArray = JsonUtil
                    .formatRsToJsonArray(studentDao.studentList(con, pageBean, student, bbirthday, ebirthday));
            int total = studentDao.studentCount(con, student, bbirthday, ebirthday);
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(res, result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeConn(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



    }
    
}