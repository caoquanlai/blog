package cn.fairyzww.blog.dao;

import cn.fairyzww.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Yg
 * @date: 2019/12/1
 * @time: 14:05
 * @description: No Description
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    /**
     * 按照update_time降序得到前size个Blog
     * @return List<Blog>
     */
    @Query(value = "select * FROM t_blog as b where b.recommend = true ORDER BY update_time DESC LIMIT 0,?1", nativeQuery = true)
    List<Blog> findTop(Integer size);

    /**
     * ---
     * @param pageable Pageable
     * @return List<Blog>
     */
    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    /**
     * ---
     * @param id Long
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Blog b set b.views = b.views+1 where b.id = ?1")
    int updateViews(Long id);

    /**
     * ---
     * @param query String
     * @param pageable Pageable
     * @return Page<Blog>
     */
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    /**
     * ---
     * @return List<String>
     */
    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
    List<String> findGroupYear();

    /**
     * ---
     * @param year String
     * @return List<Blog>
     */
    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
    List<Blog> findByYear(String year);
}
