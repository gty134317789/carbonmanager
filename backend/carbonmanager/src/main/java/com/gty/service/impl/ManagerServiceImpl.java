package com.gty.service.impl;

import com.gty.entity.Manager;
import com.gty.mapper.ManagerMapper;
import com.gty.service.ManagerService;
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
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

}
