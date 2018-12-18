package com.b.test;

import com.b.test.common.CorsConfig;
import com.b.test.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author zhr
 * @description ${description}
 * @date 2018-12-10 13:52
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetPasswordTest {
    @Test
    public void getPassword() {
        Logger logger = LoggerFactory.getLogger(GetPasswordTest.class);
        String password = MD5.md5Password("112233" + CorsConfig.MD5_KEY);
        logger.debug(password);
    }
}
