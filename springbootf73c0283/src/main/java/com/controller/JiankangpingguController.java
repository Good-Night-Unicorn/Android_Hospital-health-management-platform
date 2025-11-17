package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiankangpingguEntity;
import com.entity.view.JiankangpingguView;

import com.service.JiankangpingguService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康评估
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@RestController
@RequestMapping("/jiankangpinggu")
public class JiankangpingguController {
    @Autowired
    private JiankangpingguService jiankangpingguService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangpingguEntity jiankangpinggu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huanzhe")) {
			jiankangpinggu.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiankangpingguEntity> ew = new EntityWrapper<JiankangpingguEntity>();


        //查询结果
		PageUtils page = jiankangpingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangpinggu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangpingguEntity jiankangpinggu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangpingguEntity> ew = new EntityWrapper<JiankangpingguEntity>();

        //查询结果
		PageUtils page = jiankangpingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangpinggu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangpingguEntity jiankangpinggu){
       	EntityWrapper<JiankangpingguEntity> ew = new EntityWrapper<JiankangpingguEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangpinggu, "jiankangpinggu")); 
        return R.ok().put("data", jiankangpingguService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangpingguEntity jiankangpinggu){
        EntityWrapper< JiankangpingguEntity> ew = new EntityWrapper< JiankangpingguEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangpinggu, "jiankangpinggu")); 
		JiankangpingguView jiankangpingguView =  jiankangpingguService.selectView(ew);
		return R.ok("查询健康评估成功").put("data", jiankangpingguView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangpingguEntity jiankangpinggu = jiankangpingguService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangpinggu,deSens);
        return R.ok().put("data", jiankangpinggu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangpingguEntity jiankangpinggu = jiankangpingguService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangpinggu,deSens);
        return R.ok().put("data", jiankangpinggu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangpingguEntity jiankangpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangpinggu);
        jiankangpingguService.insert(jiankangpinggu);
        return R.ok().put("data",jiankangpinggu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangpingguEntity jiankangpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangpinggu);
        jiankangpingguService.insert(jiankangpinggu);
        return R.ok().put("data",jiankangpinggu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangpingguEntity jiankangpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangpinggu);
        //全部更新
        jiankangpingguService.updateById(jiankangpinggu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangpingguService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
