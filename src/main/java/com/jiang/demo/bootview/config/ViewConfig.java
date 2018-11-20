package com.jiang.demo.bootview.config;

import com.jiang.demo.bootview.utils.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.nio.charset.StandardCharsets;

/**
 * @author Jiang
 * @date 2018/11/20
 * @time 11:44
 */
@Configuration
public class ViewConfig {

    @Value("${css.prefix}")
    private String cssPrefix ="classpath:css/";
    @Value("${css.suffix}")
    private String cssSuffix=".css";
    @Value("${javascript.prefix}")
    private String javascriptPrefix ="classpath:js/";
    @Value("${javascript.suffix}")
    private String javascriptSuffix=".js";
    @Autowired
    private ApplicationContext applicationContext;


    /**
     * css 视图解析器
     * @param cssTemplateResolver css视图配置项
     * @return
     */
    @Bean
    public ViewResolver cssViewResolver(ITemplateResolver cssTemplateResolver) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(cssTemplateResolver));
        resolver.setContentType("text/css");
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resolver.setViewNames(ArrayUtil.array("*.css"));
        return resolver;
    }

    /**
     * javascript视图解析器
     * @param javascriptTemplateResolver javascript视图配置
     * @return
     */
    @Bean
    public ViewResolver javascriptViewResolver(ITemplateResolver javascriptTemplateResolver) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(javascriptTemplateResolver));
        resolver.setContentType("application/javascript");
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resolver.setViewNames(ArrayUtil.array("*.js"));
        return resolver;
    }

    /**
     * HTML视图配置
     * @return
     */
    @Bean
    public ITemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
        return resolver;
    }

    /**
     * css视图配置
     * @return
     */
    @Bean
    public ITemplateResolver cssTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix(cssPrefix);
        resolver.setSuffix(cssSuffix);
        resolver.setTemplateMode(TemplateMode.CSS);
        resolver.setCacheable(false);
        return resolver;
    }

    /**
     * javascript 视图配置
     * @return
     */
    @Bean
    public ITemplateResolver javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix(javascriptPrefix);
        resolver.setSuffix(javascriptSuffix);
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        resolver.setCacheable(false);
        return resolver;
    }
    private SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }
}
