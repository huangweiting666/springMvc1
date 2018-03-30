package com.newer.controller;

import com.sun.net.httpserver.Headers;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("/upload")
    public String upload(MultipartFile myPic, HttpSession session) throws IOException {
        //获取保存文件的绝对路径
        String path=session.getServletContext().getRealPath("images");
        //获取文件上传名
        String fileName=myPic.getOriginalFilename();
        File file = new File(path,fileName);
        //文件另存到指定路径
        myPic.transferTo(file);
        session.setAttribute("fileName",fileName);
        return "suc";
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String fileName,HttpSession session) throws IOException {
        //获取保存文件的绝对路径
        String path=session.getServletContext().getRealPath("images");
        File file = new File(path,fileName);
        //定义相应数据包头部数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",fileName);//弹出文件另存为的对话框
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }
}
