package com.gty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.entity.Company;
import com.gty.mapper.CompanyMapper;
import com.gty.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.vo.CompanyVO;
import com.gty.vo.CompanyPageVO;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    private Object company;

    @Override
    public CompanyPageVO voList(Integer page, Integer size){
        Page<Company> companyPage=new Page<>(page,size);
        Page<Company> resultPage=this.companyMapper.selectPage(companyPage,null);
        List<Company> companyList=resultPage.getRecords();
        CompanyVO companyVO=null;
        List<CompanyVO> result=new ArrayList<>();
        for(Company company:companyList){
            companyVO=new CompanyVO();
            BeanUtils.copyProperties(company,companyVO);
            result.add(companyVO);
        }
        CompanyPageVO companypageVO=new CompanyPageVO();
        companypageVO.setData(result);
        companypageVO.setTotal(resultPage.getTotal());
        return companypageVO;
    }


    @Override
    public CompanyVO findVOById(Integer id) {
        Company company=this.companyMapper.selectById(id);
        CompanyVO companyVO=new CompanyVO();
        BeanUtils.copyProperties(company,companyVO);
        return companyVO;
    }



}
