package cn.fairyzww.blog.service;

import cn.fairyzww.blog.dao.TypeRepository;
import cn.fairyzww.blog.entity.Type;
import cn.fairyzww.blog.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 16:24
 * @Description: No Description
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Type getType(Long id) {
        return typeRepository.findTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findTypeByName(name);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        //Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        //Pageable pageable = new PageRequest(0,size,sort);
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findTypeById(id);
        if (null == t) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
