package com.stream.college.service.trade.service;

import java.util.Map;

/**
 * @author stream
 * @since 2022/4/26 2:48
 */
public interface WeixinPayService {

    Map<String, Object> createNative(String orderNo, String remoteAddr);
}
