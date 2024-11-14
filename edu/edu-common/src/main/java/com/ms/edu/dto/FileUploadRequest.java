package com.ms.edu.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: FileUploadRequest
 * Package: com.ms.edu.dto
 * Description:
 *
 * @Author ms
 * @Create 2024/6/12 12:22
 * @Version 1.0
 */
public class FileUploadRequest {
    private MultipartFile file;
    private byte[] fileContent;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}
