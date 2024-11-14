package com.ms.edu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aliyunoss")
public class AliyunOssConfig {
    /**
     * 地域节点
     */
    private String endpoint;

    /**
     * AccessKey
     */
    private String accessKeyId;

    /**
     * AccessKey秘钥
     */
    private String accessKeySecret;

    /**
     * bucket名称
     */
    private String bucketName;

    /**
     * bucket下文件夹的路径
     */
    private String filehost;

    /**
     * 访问域名
     */
    private String url;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFilehost() {
        return filehost;
    }

    public void setFilehost(String filehost) {
        this.filehost = filehost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AliyunOssConfig{" +
                "endpoint='" + endpoint + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", filehost='" + filehost + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}