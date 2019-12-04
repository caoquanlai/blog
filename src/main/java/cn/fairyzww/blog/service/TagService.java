package cn.fairyzww.blog.service;

import cn.fairyzww.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 21:40
 * @Description: No Description
 */
public interface TagService {
    /**
     * 保存Tag
     * @param tag Tag
     * @return Tag
     */
    Tag saveTag(Tag tag);

    /**
     * 通过id获取Tag
     * @param id Long
     * @return Tag
     */
    Tag getTag(Long id);

    /**
     * 通过name获取Tag
     * @param name String
     * @return Tag
     */
    Tag getTagByName(String name);

    /**
     * 分页获取Tag
     * @param pageable Pageable
     * @return Page<Tag>
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 获取Tag列表
     * @return List<Tag>
     */
    List<Tag> listTag();

    /**
     * 将字符串拆分成List
     * @param ids String
     * @return List<Tag>
     */
    List<Tag> listTag(String ids);

    /**
     * ---
     * @param size Integer
     * @return List<Tag>
     */
    List<Tag> listTagTop(Integer size);

    /**
     * 通过id更新Tag
     * @param id Long
     * @param tag Tag
     * @return Tag
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 通过id删除Tag
     * @param id Long
     */
    void deleteTag(Long id);
}
