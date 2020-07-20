package com.leyou.item.controller;


import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父ID查询子分类
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategorysByPid(@RequestParam("pid") Long pid){
        if( pid == null || pid < 0){
            return ResponseEntity.badRequest().build();
        }
        List<Category> categorys = categoryService.queryCategorysByPid(pid);
        if(CollectionUtils.isEmpty(categorys)){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categorys);
    }
}
