package com.stream.college.service.edu.service.impl;

import com.stream.college.service.edu.mapper.CommentMapper;
import com.stream.college.service.edu.entity.Comment;
import com.stream.college.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author stream
 * @since 2022-02-02
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
