package com.mengding.a;

import org.springframework.stereotype.Service;

@Service
public class AService {
    
    public void sysHello(){
        System.out.println("hello "+this.getClass().getName());
    }
}
