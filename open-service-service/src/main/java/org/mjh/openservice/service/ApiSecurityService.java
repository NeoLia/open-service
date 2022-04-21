package org.mjh.openservice.service;

import org.mjh.openservice.common.constant.CharacterConstant;
import org.mjh.openservice.common.vo.ResultVO;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author: Neo Lia Marx
 * @date: 2022/4/21 21:08
 */
@Service
public class ApiSecurityService {
    public ResultVO<String> generateApiKey(int keyLen, boolean mixedLetter) {
        char[] e;
        if (mixedLetter) {
            e = CharacterConstant.MIXED_ELEMENTS;
        }
        else {
            e= CharacterConstant.PLAIN_ELEMENTS;
        }

        int eLen = e.length;
        StringBuilder key = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < keyLen; i++) {
            key.append(e[random.nextInt(eLen)]);
        }
        return ResultVO.ok("ok", key.toString());
    }

    public ResultVO<String> md5Hex(String data, boolean upperCase) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digestBytes = messageDigest.digest(data.getBytes("UTF-8"));
        StringBuilder md5HexData = new StringBuilder();
        for (byte b : digestBytes) {
            int v = b & 0xff;
            if (v < 16) {
                md5HexData.append("0" + Integer.toHexString(v));
            }
            else {
                md5HexData.append(Integer.toHexString(v));
            }
        }
        return ResultVO.ok("ok",upperCase ? md5HexData.toString().toUpperCase() : md5HexData.toString());
    }
}
