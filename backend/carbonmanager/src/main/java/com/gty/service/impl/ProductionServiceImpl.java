package com.gty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.entity.Production;
import com.gty.mapper.ProductionMapper;
import com.gty.service.ProductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.vo.PageVO;
import com.gty.vo.ProductionVO;
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
 * @author GTY
 * @since 2022-05-12
 */

@Service
@Transactional
public class ProductionServiceImpl extends ServiceImpl<ProductionMapper, Production> implements ProductionService {

    @Autowired
    private ProductionMapper productionMapper;
    private Object production;

    @Override
    public PageVO voList(Integer page, Integer size){
        Page<Production> productionPage=new Page<>(page,size);
        Page<Production> resultPage=this.productionMapper.selectPage(productionPage,null);
        List<Production> productionList=resultPage.getRecords();
        ProductionVO productionVO=null;
        List<ProductionVO> result=new ArrayList<>();
        for(Production production:productionList){
            productionVO=new ProductionVO();
            BeanUtils.copyProperties(production,productionVO);
            result.add(productionVO);
        }
        PageVO pageVO=new PageVO();
        pageVO.setData(result);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }


    @Override
    public ProductionVO findVOById(Integer id) {
        Production production=this.productionMapper.selectById(id);
        ProductionVO productionVO=new ProductionVO();
        BeanUtils.copyProperties(production,productionVO);
        return productionVO;
    }




}
