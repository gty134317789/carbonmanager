package com.peeka.controller;


import com.peeka.entity.Classficationanalysis;
import com.peeka.entity.Regressionanalysis;
import com.peeka.service.ClassficationanalysisService;
import com.peeka.service.RegressionanalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PEEKA
 * @since 2022-06-24
 */
@Controller
@RestController
@CrossOrigin
@RequestMapping("/regressionanalysis")
public class RegressionanalysisController {
    @Autowired
    public RegressionanalysisService regressionanalysisService;

    @GetMapping("/list")
    public List<Regressionanalysis> list() {
        return this.regressionanalysisService.list();
    }

}

