package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper ;


    /**
     * 根据父ID查询子分类
     * @param pid
     * @return
     */
    public List<Category> queryCategorysByPid(long pid) {
        Category category = new Category();
        category.setParentId(pid);
       return this.categoryMapper.select(category);
    }
}
