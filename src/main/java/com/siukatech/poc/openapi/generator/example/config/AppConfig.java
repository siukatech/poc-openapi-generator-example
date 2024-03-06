package com.siukatech.poc.openapi.generator.example.config;

import com.siukatech.poc.react.backend.parent.EnableReactBackend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
//@Import({
//        GlobalConfigImport.class,
//        WebConfigImport.class
//        , SecurityConfigImport.class
//})
//@ComponentScan({
//        "com.siukatech.poc.react.backend.parent.web.controller"
//})
@EnableReactBackend
public class AppConfig {

}
