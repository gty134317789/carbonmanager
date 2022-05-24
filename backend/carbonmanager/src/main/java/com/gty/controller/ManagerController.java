package com.gty.controller;

import com.gty.entity.Manager;
import com.gty.service.ManagerService;
import com.gty.vo.ManagerPageVO;
import com.gty.vo.ManagerVO;
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
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/list/{page}/{size}")
    public ManagerPageVO list(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
        return this.managerService.voList(page,size);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Manager manager){
        return  this.managerService.save(manager);
    }

    @GetMapping("/findById/{id}")
    public ManagerVO findById(@PathVariable("id") Integer id){
        return this.managerService.findVOById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Manager manager){
        return this.managerService.updateById(manager);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") Integer id){
        return this.managerService.removeById(id);
    }


}

