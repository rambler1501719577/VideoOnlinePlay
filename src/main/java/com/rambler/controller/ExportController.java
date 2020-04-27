package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.beans.Course;
import com.rambler.beans.User;
import com.rambler.service.ClassifyService;
import com.rambler.service.CourseService;
import com.rambler.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("export")
public class ExportController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("course")
    public void exportCourseInfo(HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        List<Course> list = courseService.getCourseList();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("课程信息表");
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("ID");
        titleRow.createCell(1).setCellValue("教师姓名");
        titleRow.createCell(2).setCellValue("课程分类");
        titleRow.createCell(3).setCellValue("课程名");
        titleRow.createCell(4).setCellValue("课程描述");
        titleRow.createCell(5).setCellValue("课程发布时间");
        titleRow.createCell(6).setCellValue("课程累计学习次数");
        for (Course course : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(course.getId());
            User teacher = userService.getUserById(course.getTeacherId());
            dataRow.createCell(1).setCellValue(teacher.getName());
            Classify classify = classifyService.getClassifyById(course.getClassifyId());
            dataRow.createCell(2).setCellValue(classify.getName());
            dataRow.createCell(3).setCellValue(course.getName());
            dataRow.createCell(4).setCellValue(course.getDescription());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dataRow.createCell(5).setCellValue(format.format(course.getCreateTime()));
            dataRow.createCell(6).setCellValue(course.getStudyTimes());
        }
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String("课程信息".getBytes(), StandardCharsets.ISO_8859_1) + ".xls");
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
