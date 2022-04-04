package com.stream.college.service.trade.service.impl;

import com.stream.college.service.trade.service.PayLogService;
import com.stream.college.service.trade.entity.PayLog;
import com.stream.college.service.trade.mapper.PayLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author stream
 * @since 2022-04-04
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
