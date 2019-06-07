package com.yunus.controller;

import com.yunus.entity.GoodInfoEntity;
import com.yunus.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/good")
public class GoodController {
    /**
     * 商品业务逻辑实现
     */
    @Autowired
    private GoodInfoService goodInfoService;

    /**
     * 添加商品
     *
     * @return
     */
    @RequestMapping(value = "/save")
    public Long save(GoodInfoEntity good) throws Exception {
        return goodInfoService.saveGood(good);
    }
}
