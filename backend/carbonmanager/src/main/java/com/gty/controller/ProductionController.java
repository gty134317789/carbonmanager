package com.gty.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gty.entity.Company;
import com.gty.service.CompanyService;
import com.gty.service.ProductionService;
import com.gty.entity.Production;
import com.gty.vo.PageVO;
import com.gty.vo.ProductionVO;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static sun.misc.Version.println;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
@RestController
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionService productionService;
    @GetMapping("/list/{page}/{size}")
    public PageVO list(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
        return this.productionService.voList(page,size);
    }

    @PostMapping ("/save")
    public boolean save(@RequestBody Production production){
        return  this.productionService.save(production);
    }

    @GetMapping("/findById/{id}")
    public ProductionVO findById(@PathVariable("id") Integer id){
        return this.productionService.findVOById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Production production){
        return this.productionService.updateById(production);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") Integer id){
        return this.productionService.removeById(id);
    }

}

