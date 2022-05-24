package com.gty.service;

import com.gty.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.vo.ManagerPageVO;
import com.gty.vo.ManagerVO;
import com.gty.vo.PageVO;
import com.gty.vo.ProductionVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
public interface ManagerService extends IService<Manager> {
    public ManagerPageVO voList(Integer page, Integer size);
    public ManagerVO findVOById(Integer id);

}
