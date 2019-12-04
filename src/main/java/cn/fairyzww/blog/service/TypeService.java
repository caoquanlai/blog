package cn.fairyzww.blog.service;

import cn.fairyzww.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 16:18
 * @Description: 分类管理service
 */
public interface TypeService {
    /**
     * 保存分类
     * @param type Type
     * @return Type
     */
    Type saveType(Type type);

    /**
     * 通过id获取Type
     * @param id id
     * @return Type
     */
    Type getType(Long id);

    /**
     * 通过name获取Type
     * @param name name
     * @return Type
     */
    Type getTypeByName(String name);

    /**
     * 分页获取Type
     * @param pageable pageable
     * @return Page<Type>
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 返回所有分类列表
     * @return List<Type>
     */
    List<Type> listType();

    /**
     * 首页分类
     * @param size Integer
     * @return List<Type>
     */
    List<Type> listTypeTop(Integer size);

    /**
     * 更新Type
     * @param id id
     * @param type Type
     * @return Type
     */
    Type updateType(Long id, Type type);

    /**
     * 删除Type
     * @param id id
     */
    void deleteType(Long id);
}
