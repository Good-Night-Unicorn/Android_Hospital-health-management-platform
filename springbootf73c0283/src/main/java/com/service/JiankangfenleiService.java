package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangfenleiView;


/**
 * 健康分类
 *
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public interface JiankangfenleiService extends IService<JiankangfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangfenleiVO> selectListVO(Wrapper<JiankangfenleiEntity> wrapper);
   	
   	JiankangfenleiVO selectVO(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);
   	
   	List<JiankangfenleiView> selectListView(Wrapper<JiankangfenleiEntity> wrapper);
   	
   	JiankangfenleiView selectView(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangfenleiEntity> wrapper);

   	

}

