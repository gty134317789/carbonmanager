package com.gty.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.entity.Production;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.vo.PageVO;
import com.gty.vo.ProductionVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
public interface ProductionService extends IService<Production> {
    public PageVO voList(Integer page, Integer size);
    public ProductionVO findVOById(Integer id);


}
