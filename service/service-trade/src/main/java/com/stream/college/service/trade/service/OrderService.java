package com.stream.college.service.trade.service;

import com.stream.college.service.trade.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author stream
 * @since 2022-04-04
 */
public interface OrderService extends IService<Order> {

    String saveOrder(String courseId, String memberId);

    Order getByOrderId(String orderId, String memberId);

    Boolean isBuyByCourseId(String courseId, String memberId);

    List<Order> selectByMemberId(String memberId);

    boolean removeById(String orderId, String memberId);
}