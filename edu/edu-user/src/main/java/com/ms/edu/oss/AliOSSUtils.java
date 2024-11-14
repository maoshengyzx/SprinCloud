package com.ms.edu.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.ms.edu.config.AliyunOssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AliOSSUtils {

    private static AliyunOssConfig aliyunOssConfig;

    private static OSS ossClient = null;

    /**
     * 使用构造方法注入配置信息
     */
    @Autowired
    public AliOSSUtils(AliyunOssConfig aliyunOssConfig) {
        AliOSSUtils.aliyunOssConfig = aliyunOssConfig;
        ossClient = new OSSClientBuilder().build(aliyunOssConfig.getEndpoint(), aliyunOssConfig.getAccessKeyId(),aliyunOssConfig.getAccessKeySecret());
    }


    //创建OSS存储空间
    public static void creatOSS(){
        try {
            // 创建存储空间。
            ossClient.createBucket(aliyunOssConfig.getBucketName());

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * OSS文件上传
     * @param CloudPath 云端的目的地址
     * @param filePath 本地的文件路径
     */
    public static String UploadOSS(String CloudPath,InputStream filePath){
        ossClient = new OSSClientBuilder().build(aliyunOssConfig.getEndpoint(), aliyunOssConfig.getAccessKeyId(),aliyunOssConfig.getAccessKeySecret());
        try {
            ossClient.putObject(aliyunOssConfig.getBucketName(), CloudPath, filePath);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }

            StringBuilder stringBuilder = new StringBuilder("https://");
            stringBuilder
                    .append(aliyunOssConfig.getBucketName())
                    .append(".")
                    .append(aliyunOssConfig.getEndpoint())
                    .append("/")
                    .append(CloudPath);

            return stringBuilder.toString();
        }
    }

    /**
     * OSS文件下载
     * @param CloudPath 云端的目的地址
     * @param fileDownloadPath 本地的文件路径
     */
    public static void DowloadOSS(String CloudPath,String fileDownloadPath){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileDownloadPath))) {
            // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元数据。
            OSSObject ossObject = ossClient.getObject(aliyunOssConfig.getBucketName(), CloudPath);
            // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
            InputStream content = ossObject.getObjectContent();
            if (content != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println("\n" + line);
                    writer.write(line, 0, line.length());
                    writer.newLine();
                }
                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                content.close();
            }
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 列举文件
     */
    public static void ListOSS(){
        try {
            // ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
            ObjectListing objectListing = ossClient.listObjects(aliyunOssConfig.getBucketName());
            // objectListing.getObjectSummaries获取所有文件的描述信息。
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + "  " +
                        "(size = " + objectSummary.getSize() + ")");
            }
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 删除云端文件
     * @param CloudPath 云端文件路径
     */
    public static void DelOSS(String CloudPath){
        try {
            // 删除文件。
            ossClient.deleteObject(aliyunOssConfig.getBucketName(), CloudPath);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
