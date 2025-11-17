package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiankangfenleiDao;
import com.entity.JiankangfenleiEntity;
import com.service.JiankangfenleiService;
import com.entity.vo.JiankangfenleiVO;
import com.entity.view.JiankangfenleiView;

@Service("jiankangfenleiService")
public class JiankangfenleiServiceImpl extends ServiceImpl<JiankangfenleiDao, JiankangfenleiEntity> implements JiankangfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangfenleiEntity> page = this.selectPage(
                new Query<JiankangfenleiEntity>(params).getPage(),
                new EntityWrapper<JiankangfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangfenleiEntity> wrapper) {
		  Page<JiankangfenleiView> page =new Query<JiankangfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangfenleiVO> selectListVO(Wrapper<JiankangfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangfenleiVO selectVO(Wrapper<JiankangfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangfenleiView> selectListView(Wrapper<JiankangfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangfenleiView selectView(Wrapper<JiankangfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
