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

import com.entity.JiankangfenleiEntity;
import com.entity.view.JiankangfenleiView;

import com.service.JiankangfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@RestController
@RequestMapping("/jiankangfenlei")
public class JiankangfenleiController {
    @Autowired
    private JiankangfenleiService jiankangfenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangfenleiEntity jiankangfenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangfenleiEntity> ew = new EntityWrapper<JiankangfenleiEntity>();


        //查询结果
		PageUtils page = jiankangfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangfenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangfenleiEntity jiankangfenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangfenleiEntity> ew = new EntityWrapper<JiankangfenleiEntity>();

        //查询结果
		PageUtils page = jiankangfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangfenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangfenleiEntity jiankangfenlei){
       	EntityWrapper<JiankangfenleiEntity> ew = new EntityWrapper<JiankangfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangfenlei, "jiankangfenlei")); 
        return R.ok().put("data", jiankangfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangfenleiEntity jiankangfenlei){
        EntityWrapper< JiankangfenleiEntity> ew = new EntityWrapper< JiankangfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangfenlei, "jiankangfenlei")); 
		JiankangfenleiView jiankangfenleiView =  jiankangfenleiService.selectView(ew);
		return R.ok("查询健康分类成功").put("data", jiankangfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangfenleiEntity jiankangfenlei = jiankangfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangfenlei,deSens);
        return R.ok().put("data", jiankangfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangfenleiEntity jiankangfenlei = jiankangfenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangfenlei,deSens);
        return R.ok().put("data", jiankangfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangfenleiEntity jiankangfenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jiankangfenleiService.selectCount(new EntityWrapper<JiankangfenleiEntity>().eq("jiankangfenlei", jiankangfenlei.getJiankangfenlei()))>0) {
            return R.error("健康分类已存在");
        }
        //ValidatorUtils.validateEntity(jiankangfenlei);
        jiankangfenleiService.insert(jiankangfenlei);
        return R.ok().put("data",jiankangfenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangfenleiEntity jiankangfenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jiankangfenleiService.selectCount(new EntityWrapper<JiankangfenleiEntity>().eq("jiankangfenlei", jiankangfenlei.getJiankangfenlei()))>0) {
            return R.error("健康分类已存在");
        }
        //ValidatorUtils.validateEntity(jiankangfenlei);
        jiankangfenleiService.insert(jiankangfenlei);
        return R.ok().put("data",jiankangfenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangfenleiEntity jiankangfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangfenlei);
        //验证字段唯一性，否则返回错误信息
        if(jiankangfenleiService.selectCount(new EntityWrapper<JiankangfenleiEntity>().ne("id", jiankangfenlei.getId()).eq("jiankangfenlei", jiankangfenlei.getJiankangfenlei()))>0) {
            return R.error("健康分类已存在");
        }
        //全部更新
        jiankangfenleiService.updateById(jiankangfenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
