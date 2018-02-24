package com.livgo.cloud.api.demo.service;

import com.livgo.cloud.api.demo.mapper.DemoMapper;
import com.livgo.cloud.api.demo.model.entity.Demo;
import com.livgo.cloud.common.Const;
import com.livgo.cloud.service.demo.api.consumer.Demo1Consumer;
import com.livgo.cloud.service.demo.api.consumer.Demo2Consumer;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Service
public class DemoService {

    @Autowired
    private Demo1Consumer demo1Consumer;
    @Autowired
    private Demo2Consumer demo2Consumer;

    @Autowired
    private DemoMapper demoMapper;

    public String hi1(String name) {
        return demo1Consumer.hi1(name).toString();
    }

    public String hi2(String name) {
        return demo1Consumer.hi2(name).toString();
    }

    public String hello1(String name) {
        return demo2Consumer.hello1(name).toString();
    }

    public String hello2(String name) {
        return demo2Consumer.hello2(name).toString();
    }

    public static int getPageStartIndex(int pageNum) {
        return pageNum > 0 ? (pageNum - 1) * Const.PAGE_SIZE : 0;
    }


    /**
     * 分页查询, PageHelper分页插件
     *
     * @param pageNum
     * @return
     */
    public List<Demo> listDemoPage(int pageNum) {
        PageHelper.startPage(getPageStartIndex(pageNum), Const.PAGE_SIZE);
        return demoMapper.selectByPage(null);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @return
     */
    public List<Demo> listDemoLimit(int pageNum) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", getPageStartIndex(pageNum) + "," + Const.PAGE_SIZE);
        return demoMapper.selectByLimit(map);
    }

    /**
     * 分页查询
     *
     * @return
     */
    public int countDemo() {
        return demoMapper.selectCount(null);
    }

}
