package com.littlebuddha.backstage;

import com.littlebuddha.backstage.common.utils.AutoId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AutoIdTest {

    @Test
    public void testAutoId(){
        for (int i=0;i<13;i++){
            String autoId = AutoId.getAutoId();
            System.out.println(autoId);
        }
    }
}
