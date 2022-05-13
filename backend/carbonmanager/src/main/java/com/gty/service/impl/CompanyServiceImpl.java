package com.gty.service.impl;

import com.gty.entity.Company;
import com.gty.mapper.CompanyMapper;
import com.gty.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}
