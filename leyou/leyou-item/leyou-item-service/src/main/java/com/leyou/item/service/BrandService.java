package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * 根据条件查询排序分页数据
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> getPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 关键字不为空
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("name","%" + key +"%").orEqualTo("letter",key);
        }
        // 分页查询
        PageHelper.startPage(page,rows);
        // 排序
        if(StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause( sortBy + " " + (desc? "desc":"asc"));
        }

        List<Brand> brands = brandMapper.selectByExample(example);

        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);

        return new PageResult<>(brandPageInfo.getTotal(),brandPageInfo.getList());

    }
}
