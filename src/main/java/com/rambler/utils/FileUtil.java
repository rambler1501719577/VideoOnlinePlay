package com.rambler.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具类(上传到指定目录下)
 */
public class FileUtil {

    /**
     * 单文件上传
     *
     * @param aimFolder 指定目录
     * @param file      文件
     * @return 文件名称(标示成功与否)
     */
    public static String uploadFileTo(String aimFolder, MultipartFile file) {
        String finalName = "";
        String originalName = file.getOriginalFilename();
        String fileName = IDUtil.uuid() + originalName.substring(originalName.indexOf("."));
        String destFileName = aimFolder + File.separator + fileName;
        File destFile = new File(destFileName);
        try {
            file.transferTo(destFile);
            finalName = fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalName;
    }
}
