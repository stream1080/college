package com.stream.college.service.vod.service;

import com.aliyuncs.exceptions.ClientException;

import java.io.InputStream;

/**
 * @author stream
 * @since 2022/3/27 20:23
 */
public interface VideoService {

    String uploadVideo(InputStream inputStream, String originalFilename);

    void removeVideo(String videoId) throws ClientException;
}
