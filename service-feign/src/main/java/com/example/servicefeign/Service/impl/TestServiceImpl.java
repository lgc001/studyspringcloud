package com.example.servicefeign.Service.impl;

import com.example.servicefeign.Service.SchedualServiceRibbon;
import com.example.servicefeign.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    SchedualServiceRibbon schedualServiceRibbon;

    @Override
    public String getRibbonIndex()
    {
        Map<String,String> map=new HashMap<>();
        map.put("aaaa","bbbb");

        return schedualServiceRibbon.sayIndexFromClientOne(map);
    }
}
