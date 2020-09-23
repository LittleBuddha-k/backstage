package com.littlebuddha.backstage;

import com.littlebuddha.backstage.common.utils.MD5Encryption;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestMethods {

    @Test
    public void TestD5(){
        String encryptionPassword = MD5Encryption.getEncryptionPassword("admin", "asedgawerargasdfvasd");
        System.out.println(encryptionPassword);
    }
}
