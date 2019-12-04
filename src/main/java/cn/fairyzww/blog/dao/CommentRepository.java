package cn.fairyzww.blog.dao;

import cn.fairyzww.blog.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Yg
 * @date: 2019/12/2
 * @time: 22:03
 * @description: No Description
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    /**
     * ---
     * @param blogId Long
     * @param sort Sort
     * @return List<Comment>
     */
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
