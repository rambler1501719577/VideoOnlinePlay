package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.beans.User;
import com.rambler.beans.UserCourseApply;
import com.rambler.config.TableResponse;
import com.rambler.config.Variable;
import com.rambler.dao.CourseMapper;
import com.rambler.dao.UserCourseApplyMapper;
import com.rambler.dao.UserMapper;
import com.rambler.utils.IDUtil;
import com.rambler.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserCourseApplyMapper userCourseApplyMapper;

    @Autowired
    private UserMapper userMapper;

    public List<Course> getCourseByClassifyId(String classifyId) {
        return courseMapper.getByClassifyId(classifyId);
    }

    public Course getCourseById(String id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public boolean attendCourse(String courseId, String userId) {
        List<UserCourseApply> list = userCourseApplyMapper.getApplyByUser(userId, courseId);
        if (list.size() > 0) {
            return false;
        }
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStudyTimes(course.getStudyTimes() + 1);
        courseMapper.updateByPrimaryKey(course);
        UserCourseApply userCourseApply = new UserCourseApply();
        userCourseApply.setApplyTime(new Date());
        userCourseApply.setUserId(userId);
        userCourseApply.setCourseId(courseId);
        userCourseApplyMapper.insert(userCourseApply);
        return true;
    }

    public List<Course> getCourseByUserId(String userId) {
        return courseMapper.getCourseByUser(userId);
    }

    public List<Course> getCourseList() {
        return courseMapper.selectAll();
    }

    public TableResponse getVideoList(Integer page, Integer limit) {
        List<Course> all = courseMapper.selectAll();
        List<VideoVo> result = new ArrayList<>();
        List<Course> list = courseMapper.selectList((page - 1) * limit, limit);
        for (Course course : list) {
            User user = userMapper.selectByPrimaryKey(course.getTeacherId());
            result.add(new VideoVo(course, user.getName()));
        }
        return TableResponse.createSuccessResponse("", result, all.size());
    }

    public int removeVideo(String id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        course.setPlaySrc("");
        return courseMapper.updateByPrimaryKey(course);
    }

    public TableResponse getPageData(Integer page, Integer limit) {
        List<Course> list = courseMapper.selectList((page - 1) * limit, limit);
        int length = courseMapper.selectAll().size();
        return TableResponse.createSuccessResponse("", list, length);
    }

    public int deleteCourse(String id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    public TableResponse getRequestPageData(Integer page, Integer limit) {
        List<Course> list = courseMapper.selectRequestList((page - 1) * limit, limit);
        int length = courseMapper.selectRequestAll().size();
        return TableResponse.createSuccessResponse("", list, length);
    }

    public int apply(String id, int status) {
        return courseMapper.updateApply(id, status);
    }

    public int addNewCourse(String classify, String title, String description, MultipartFile video, MultipartFile coverImage, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Variable.CURRENT_USER);
        Course course = new Course();
        course.setId(IDUtil.uuid());
        course.setName(title);
        course.setClassifyId(classify);
        course.setDescription(description);
        course.setCreateTime(new Date());
        course.setStudyTimes(0);
        course.setRequireLevel(0);
        course.setStatus(2);
        course.setTeacherId(user.getId());
        String rootPath = request.getSession().getServletContext().getRealPath("static/upload");
        // 上传视频
        if (video != null) {
            String playSrc;
            String videoPath = rootPath + File.separator + "video";
            String extend = getFileExt(video.getOriginalFilename());
            File file = new File(videoPath);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                String filePrefix = IDUtil.uuid();
                File newFile = new File(videoPath + File.separator + filePrefix + extend);
                video.transferTo(newFile);
                playSrc = "/static/upload/video/" + filePrefix + extend;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
            course.setPlaySrc(playSrc);
        }
        if (coverImage != null) {
            String finalImageSrc;
            String imagePath = rootPath + File.separator + "images";
            String extend = getFileExt(coverImage.getOriginalFilename());
            File file = new File(imagePath);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                String filePrefix = IDUtil.uuid();
                File newFile = new File(imagePath + File.separator + filePrefix + extend);
                coverImage.transferTo(newFile);
                finalImageSrc = "/static/upload/images/" + filePrefix + extend;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
            course.setCoverImage(finalImageSrc);
        }
        return courseMapper.insert(course);
    }

    /**
     * 获取文件扩展名
     *
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

}
