package com.peeka.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peeka.entity.Clusteranalysis;
import com.peeka.mapper.ClusteranalysisMapper;
import com.peeka.service.ClusteranalysisService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peeka.vo.clusterpagevo;
import com.peeka.vo.clustervo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PEEKA
 * @since 2022-06-24
 */
@Service
@Transactional
public class ClusteranalysisServiceImpl extends ServiceImpl<ClusteranalysisMapper, Clusteranalysis> implements ClusteranalysisService {

    @Autowired
    private ClusteranalysisMapper clusteranalysisMapper;
    private Object cluster;

    @Override
    public clusterpagevo voList(Integer page, Integer size){
        Page<Clusteranalysis> clusterPage=new Page<>(page,size);
        Page<Clusteranalysis> resultPage=this.clusteranalysisMapper.selectPage(clusterPage,null);
        List<Clusteranalysis> companyList=resultPage.getRecords();
        clustervo companyVO=null;
        List< clustervo> result=new ArrayList<>();
        for(Clusteranalysis company:companyList){
            companyVO=new  clustervo();
            BeanUtils.copyProperties(company,companyVO);
            result.add(companyVO);
        }
        clusterpagevo companypageVO=new clusterpagevo();
        companypageVO.setData(result);
        companypageVO.setTotal(resultPage.getTotal());
        return companypageVO;
    }


    @Override
    public  clustervo findVOById(Integer id) {
        Clusteranalysis cluster=this.clusteranalysisMapper.selectById(id);
        clustervo clusterVO=new  clustervo();
        BeanUtils.copyProperties(cluster,clusterVO);
        return clusterVO;
    }

}
