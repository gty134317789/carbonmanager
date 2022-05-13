package com.gty.controller;


import com.gty.entity.Company;
import com.gty.service.CompanyService;
import com.gty.service.ProductionService;
import com.gty.entity.Production;
import com.gty.vo.PageVO;
import com.gty.vo.ProductionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}

