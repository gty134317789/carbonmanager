package com.peeka.controller;


import com.peeka.entity.Classficationanalysis;
import com.peeka.entity.Clusteranalysis;
import com.peeka.service.ClassficationanalysisService;
import com.peeka.service.ClusteranalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
@RequestMapping("/classficationanalysis")
public class ClassficationanalysisController {
    @Autowired
    public ClassficationanalysisService classficationanalysisService;

    private String pythonInterpreterPath = "E:\\Python3.7.9\\python.exe";
    private String pythonFilePath = "E:\\PycharmProjects\\Exp_1_Apriori\\tree.py";
    @PostMapping("/tree")
    public String python(@Validated @RequestParam Integer month) {
        try {
            // 验证签名规则
            Process pr = Runtime.getRuntime().exec(pythonInterpreterPath+" "+pythonFilePath+" "+month);
            //获取python文件运行后的输出
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                return line;
            }
            in.close();
            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return "执行python脚本失败";
        }
        return "执行完毕";
    }
    @GetMapping("/list")
    public List<Classficationanalysis> list() {
        return this.classficationanalysisService.list();
    }
}

