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


import com.dao.JiankangshujuDao;
import com.entity.JiankangshujuEntity;
import com.service.JiankangshujuService;
import com.entity.vo.JiankangshujuVO;
import com.entity.view.JiankangshujuView;

@Service("jiankangshujuService")
public class JiankangshujuServiceImpl extends ServiceImpl<JiankangshujuDao, JiankangshujuEntity> implements JiankangshujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangshujuEntity> page = this.selectPage(
                new Query<JiankangshujuEntity>(params).getPage(),
                new EntityWrapper<JiankangshujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
		  Page<JiankangshujuView> page =new Query<JiankangshujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangshujuVO> selectListVO(Wrapper<JiankangshujuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangshujuVO selectVO(Wrapper<JiankangshujuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangshujuView> selectListView(Wrapper<JiankangshujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangshujuView selectView(Wrapper<JiankangshujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> xuetangSectionStat(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
        return baseMapper.xuetangSectionStat(params, wrapper);
    }
    @Override
    public List<Map<String, Object>> shousuoyaSectionStat(Map<String, Object> params, Wrapper<JiankangshujuEntity> wrapper) {
        return baseMapper.shousuoyaSectionStat(params, wrapper);
    }



}
