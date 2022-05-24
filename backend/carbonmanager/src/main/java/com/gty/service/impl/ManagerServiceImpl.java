package com.gty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.entity.Manager;
import com.gty.mapper.ManagerMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.service.ManagerService;
import com.gty.vo.ManagerPageVO;
import com.gty.vo.ManagerVO;
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
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    private Object manager;

    @Override
    public ManagerPageVO voList(Integer page, Integer size){
        Page<Manager>  managerPage=new Page<>(page,size);
        Page< Manager> resultPage=this.managerMapper.selectPage( managerPage,null);
        List< Manager>  managerList=resultPage.getRecords();
        ManagerVO managerVO=null;
        List< ManagerVO> result=new ArrayList<>();
        for( Manager  manager: managerList){
            managerVO=new  ManagerVO();
            BeanUtils.copyProperties( manager, managerVO);
            result.add( managerVO);
        }
        ManagerPageVO managerpageVO=new  ManagerPageVO();
        managerpageVO.setData(result);
        managerpageVO.setTotal(resultPage.getTotal());
        return managerpageVO;
    }


    @Override
    public  ManagerVO findVOById(Integer id) {
        Manager manager=this. managerMapper.selectById(id);
        ManagerVO managerVO=new ManagerVO();
        BeanUtils.copyProperties( manager, managerVO);
        return  managerVO;
    }



}
