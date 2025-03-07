package kks.lend36back.util;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class BytesConverter {

        public static byte[] stringToBytesArray(String value){
            return value.getBytes(StandardCharsets.UTF_8);
        }

        public static String bytesArrayToString(byte[] bytes){
            return new String(bytes, StandardCharsets.UTF_8);
        }

}
