package com.gty.service;

import com.gty.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.vo.CompanyPageVO;
import com.gty.vo.CompanyVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
public interface CompanyService extends IService<Company> {
    public CompanyPageVO voList(Integer page, Integer size);
    public CompanyVO findVOById(Integer id);

}
