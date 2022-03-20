package com.stream.college.service.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.stream.college.service.oss.service.FileService;
import com.stream.college.service.oss.util.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.joda.time.DateTime;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author stream
 * @since 2022/3/20 14:53
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        //读取配置信息
        String endpoint = ossProperties.getEndpoint();
        String keyId = ossProperties.getKeyid();
        String keySecret = ossProperties.getKeysecret();
        String bucketName = ossProperties.getBucketname();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
        if (!ossClient.doesBucketExist(bucketName)) {
            ossClient.createBucket(bucketName);
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        }

        //构建objectName：文件路径 avatar/2020/04/15/default.jpg
        String folder = new DateTime().toString("yyyy/MM/dd");
        String fileName = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName + fileExtension;

        // 上传文件流。
        ossClient.putObject(bucketName, key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //返回url
        //https://guli-file-191125.oss-cn-beijing.aliyuncs.com/avatar/default.jpg
        return "https://" + bucketName + "." + endpoint + "/" + key;
    }

    @Override
    public void removeFile(String url) {
        //读取配置信息
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);

        // 删除文件。
        //https://guli-file-191125.oss-cn-beijing.aliyuncs.com/
        String host = "https://" + bucketname + "." + endpoint + "/";
        String objectName = url.substring(host.length());
        ossClient.deleteObject(bucketname, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
