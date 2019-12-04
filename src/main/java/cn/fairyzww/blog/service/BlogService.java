package cn.fairyzww.blog.service;

import cn.fairyzww.blog.entity.Blog;
import cn.fairyzww.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 22:24
 * @Description: No Description
 */
public interface BlogService {

    /**
     * 获取Blog
     * @param id Long
     * @return Blog
     */
    Blog getBlog(Long id);

    /**
     * ---
     * @param id Long
     * @return Blog
     */
    Blog getAndConvert(Long id);

    /**
     * 分页获取Blog
     * @param pageable Pageable
     * @param blog BlogQuery
     * @return Page<Blog>
     */
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    /**
     * ---
     * @param pageable Pageable
     * @return Page<Blog>
     */
    Page<Blog> listBlog(Pageable pageable);

    /**
     * ---
     * @param tagId Long
     * @param pageable Pageable
     * @return Page<Blog>
     */
    Page<Blog> listBlog(Long tagId,Pageable pageable);

    /**
     * ---
     * @param query String
     * @param pageable Pageable
     * @return Page<Blog>
     */
    Page<Blog> listBlog(String query,Pageable pageable);

    /**
     * ---
     * @param size Integer
     * @return List<Blog>
     */
    List<Blog> listRecommendBlogTop(Integer size);

    /**
     * ---
     * @return Map<String,List<Blog>>
     */
    Map<String,List<Blog>> archiveBlog();

    /**
     * ---
     * @return Long
     */
    Long countBlog();

    /**
     * 保存Blog
     * @param blog Blog
     * @return Blog
     */
    Blog saveBlog(Blog blog);

    /**
     * 更新Blog
     * @param id Long
     * @param blog Blog
     * @return Blog
     */
    Blog updateBlog(Long id,Blog blog);

    /**
     * 删除Blog
     * @param id Long
     */
    void deleteBlog(Long id);
}
