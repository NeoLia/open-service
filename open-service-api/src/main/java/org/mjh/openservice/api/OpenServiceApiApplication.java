package org.mjh.openservice.api;

import org.mjh.openservice.api.controller.ApiSecurityController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author: Neo Lia Marx
 * @date: 2022/04/20
 */
public class OpenServiceApiApplication {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ApiSecurityController apiSecurityController = new ApiSecurityController();
        String key = apiSecurityController.generateApiKey(32, true).getData();
        System.out.println("key: " + key);
        String md5Hex = apiSecurityController.md5Hex(key, false).getData();
        System.out.println("md5 hex key: " + md5Hex);
    }
}
