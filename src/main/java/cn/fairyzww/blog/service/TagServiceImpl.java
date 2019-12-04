package cn.fairyzww.blog.service;

import cn.fairyzww.blog.dao.TagRepository;
import cn.fairyzww.blog.dao.TypeRepository;
import cn.fairyzww.blog.entity.Tag;
import cn.fairyzww.blog.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 21:40
 * @Description: No Description
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.findTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findTagByName(name);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllByIdIsIn(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
//        Pageable pageable = new PageRequest(0, size, sort);
        Pageable pageable = PageRequest.of(0,size, sort);
        return tagRepository.findTop(pageable);
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findTagById(id);
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
