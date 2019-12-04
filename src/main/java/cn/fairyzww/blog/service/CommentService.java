package cn.fairyzww.blog.service;

import cn.fairyzww.blog.entity.Comment;

import java.util.List;

/**
 * @author: Yg
 * @date: 2019/12/2
 * @time: 21:28
 * @description: No Description
 */
public interface CommentService {

    /**
     * ---
     * @param blogId Long
     * @return List<Comment>
     */
    List<Comment> listCommentByBlogId(Long blogId);

    /**
     * ---
     * @param comment Comment
     * @return Comment
     */
    Comment saveComment(Comment comment);
}
