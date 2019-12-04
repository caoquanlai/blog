package cn.fairyzww.blog.dao;

import cn.fairyzww.blog.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 16:25
 * @Description: No Description
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
    /**
     * 通过name查找Type
     * @param name name
     * @return Type
     */
    Type findTypeByName(String name);

    /**
     * 通过id查找Type
     * @param id id
     * @return type
     */
    Type findTypeById(Long id);

    /**
     * 按照update_time降序得到前size个Type
     * @param size Integer
     * @return List<Type>
     */
    @Query(value = "SELECT type.id, type.`name` FROM \n" +
                   "(SELECT b.type_id as id, COUNT(b.type_id) as count FROM t_blog as b GROUP BY b.type_id) as s, t_type as type\n" +
                   "WHERE s.id = type.id ORDER BY s.count DESC LIMIT 0,?1", nativeQuery = true)
    List<Type> findTop(Integer size);

    /**
     * 按照update_time降序得到前size个Type
     * @param pageable Pageable
     * @return List<Type>
     */
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
