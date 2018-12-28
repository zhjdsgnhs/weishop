package cn.weishop.common;


import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class AutoGeneratorHelper {
	 public static void main(String[] args) {
	        // 代码生成器
	        AutoGenerator mpg = new AutoGenerator();

	        // 全局配置
	        GlobalConfig gc = new GlobalConfig();
	        final String projectPath = System.getProperty("user.dir");
	        gc.setOutputDir(projectPath + "/src/main/java");
	        gc.setAuthor("jeddden");
	        gc.setOpen(false);
	        mpg.setGlobalConfig(gc);

	        // 数据源配置
	        DataSourceConfig dsc = new DataSourceConfig();
	        dsc.setUrl("jdbc:mysql://localhost:3306/weishopdb?useUnicode=true&useSSL=false&characterEncoding=utf8");
	        // dsc.setSchemaName("public");
	        dsc.setDriverName("com.mysql.jdbc.Driver");
	        dsc.setUsername("root");
	        dsc.setPassword("123");
	        mpg.setDataSource(dsc);

	        // 包配置
	        PackageConfig pc = new PackageConfig();
	        
	        // 注意不同的模块生成时要修改对应模块包名
	        pc.setParent(null);
	        pc.setEntity("cn.weishop.demo");
	        pc.setMapper("cn.weishop.mapper");
	        pc.setXml("cn.weishop.mapper.mapping");
	        pc.setService("cn.weishop.service");        
	        pc.setServiceImpl("cn.weishop.service.impl");    
	        pc.setController("cn.weishop.controller");     
	        mpg.setPackageInfo(pc);

	        // 自定义配置
	        InjectionConfig cfg = new InjectionConfig() {
	            @Override
	            public void initMap() {
	                // to do nothing
	            }
	        };
	        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
	        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
	            @Override
	            public String outputFile(TableInfo tableInfo) {
	                // 自定义输入文件名称
	                return projectPath + "/src/main/resources/mapper/" 
	                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
	            }
	        });
	        cfg.setFileOutConfigList(focList);
	        mpg.setCfg(cfg);
	        mpg.setTemplate(new TemplateConfig().setXml(null));

	        // 策略配置
	        StrategyConfig strategy = new StrategyConfig();
	        strategy.setNaming(NamingStrategy.underline_to_camel);
	        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
	        strategy.setEntityLombokModel(true);
	        // 生成 RestController 风格
	        strategy.setRestControllerStyle(true);
	        strategy.setInclude(new String[]{"tb_address","tb_areas","tb_brand","tb_cities","tb_content",
	        		"tb_content_category","tb_good_theme","tb_goods","tb_goods_desc","tb_goods_promotion","tb_goods_status","tb_item",
	        		"tb_item_cat","tb_order","tb_order_item",
	        		"tb_pay_log","tb_permission","tb_provinces","tb_role","tb_role_permission","tb_seckill_goods","tb_seckill_order",
	        		"tb_seller","tb_seller_type","tb_specification","tb_specification_option","tb_theme","tb_user","tb_user_role"});
	        //strategy.setSuperEntityColumns("id");
	        strategy.setControllerMappingHyphenStyle(true);
	        //strategy.setTablePrefix(pc.getModuleName() + "_");
	       
	        
	         //策略配置
	         //strategy.setTablePrefix(new String[]{"pf_"});// 此处可以修改为您的表前缀
	        // 排除生成的表
	        /*strategy.setExclude(new String[]{"qrtz_blob_triggers","qrtz_calendars","qrtz_cron_triggers",
	        		                         "qrtz_fired_triggers","qrtz_job_details","qrtz_locks",
	        		                         "qrtz_paused_trigger_grps","qrtz_scheduler_state","qrtz_simple_triggers",
	        		                         "qrtz_simprop_triggers","qrtz_triggers"}); */
	        // 自定义实体父�?
	     	// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
	     	// 自定义实体，公共字段
	     	// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
	     	// 自定�? mapper 父类
	     	// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
	     	// 自定�? service 父类
	     	// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
	     	// 自定�? service 实现类父�?
	     	// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
	     	// 自定�? controller 父类
	     	// strategy.setSuperControllerClass("BaseController");
	     	mpg.setStrategy(strategy);
		        
	        
	        
	        
	        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
	        mpg.execute();
	    }	
}