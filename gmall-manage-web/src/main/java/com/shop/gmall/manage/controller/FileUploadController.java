package com.shop.gmall.manage.controller;


import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import java.io.IOException;

@RestController
@CrossOrigin
public class FileUploadController {

    @Value("${fileServer.url}")
    private String fileUrl;

    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file)  throws IOException, MyException  {
        String imgUrl = fileUrl;
        if (file!=null && file.getSize()>0) {

            String configFile  = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(configFile);
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageClient storageClient=new StorageClient(trackerServer,null);
            String orginalFilename=file.getOriginalFilename();
            String afterLast = StringUtils.substringAfterLast(orginalFilename, ".");

            String[] upload_file = storageClient.upload_file(file.getBytes(), afterLast, null);
            for (int i = 0; i < upload_file.length; i++) {
                String s = upload_file[i];
                imgUrl+="/" + s;
            }
        }
        return imgUrl;
    }
}
