package com.whu.order.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

    /**
     * 存储文件
     * @param file file
     * @return filename
     */
    public String storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
