package com.peeka.service;

import com.peeka.entity.Clusteranalysis;
import com.baomidou.mybatisplus.extension.service.IService;
import com.peeka.vo.clusterpagevo;
import com.peeka.vo.clustervo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PEEKA
 * @since 2022-06-24
 */
public interface ClusteranalysisService extends IService<Clusteranalysis> {
    public clusterpagevo voList(Integer page, Integer size);
    public clustervo findVOById(Integer id);
}
