/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 *
 * @author PC
 */
@Configuration
public class TilesConfigs {
    
    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver basedViewResolver = new UrlBasedViewResolver();
        basedViewResolver.setViewClass(TilesView.class);
        basedViewResolver.setOrder(-2);
        return basedViewResolver;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer configure = new TilesConfigurer();
        configure.setDefinitions("WEB-INF/tiles.xml");
        configure.setCheckRefresh(true);
        return configure;
    }
}
