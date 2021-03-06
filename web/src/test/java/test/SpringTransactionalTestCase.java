/**
 * Copyright (c) 2005-2012 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package test;

import com.buobao.utils.mapper.JsonMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Spring的支持数据库访问, 事务控制和依赖注入的JUnit4 集成测试基类.
 * 相比Spring原基类名字更短并保存了dataSource变量.
 * <p/>
 * 子类需要定义applicationContext文件的位置, 如:
 *
 * @author calvin
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 */

@ActiveProfiles("development")
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {

    protected static JsonMapper binder = JsonMapper.nonEmptyMapper();
    /*protected DataSource dataSource;


    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
        this.dataSource = dataSource;
    }*/
}
