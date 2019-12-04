package cn.fairyzww.blog.dao;

import cn.fairyzww.blog.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 21:42
 * @Description: No Description
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    /**
     * 通过name查找Tag
     * @param name String
     * @return Tag
     */
    Tag findTagByName(String name);

    /**
     * 通过id查找Tag
     * @param id Long
     * @return Tag
     */
    Tag findTagById(Long id);

    /**
     * 查询列表里所有id的Tag
     * @param ids List<Long>
     * @return List<Tag>
     */
    List<Tag> findAllByIdIsIn(List<Long> ids);

    /**
     * 按照update_time降序得到前size个Tag
     * @param size
     * @return
     */
    @Query(value = "SELECT tag.id, tag.`name` FROM \n" +
                   "(SELECT b.tags_id as id, COUNT(b.tags_id) as count FROM t_blog_tags as b GROUP BY b.tags_id) as s, t_tag as tag\n" +
                   "WHERE s.id = tag.id ORDER BY s.count DESC LIMIT 0,?1", nativeQuery = true)
    List<Tag> findTop(Integer size);

    /**
     * 按照update_time降序得到前size个Tag
     * @param pageable
     * @return
     */
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
