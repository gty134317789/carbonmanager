package com.gty.controller;

import com.gty.service.CompanyService;
import com.gty.entity.Company;
import com.gty.vo.CompanyPageVO;
import com.gty.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list/{page}/{size}")
    public CompanyPageVO list(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
        return this.companyService.voList(page,size);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Company company){
        return  this.companyService.save(company);
    }

    @GetMapping("/findById/{id}")
    public CompanyVO findById(@PathVariable("id") Integer id){
        return this.companyService.findVOById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Company company){
        return this.companyService.updateById(company);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") Integer id){
        return this.companyService.removeById(id);
    }


}

