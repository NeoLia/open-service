package org.mjh.openservice.controller;

import org.mjh.openservice.common.dto.ApiKeyGenRequest;
import org.mjh.openservice.common.dto.Md5HexRequest;
import org.mjh.openservice.common.vo.ResultVO;
import org.mjh.openservice.service.ApiSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author: Neo Lia Marx
 * @date: 2022/04/20
 */
@RestController
@RequestMapping("/api-security")
public class ApiSecurityController {
    private ApiSecurityService apiSecurityService;

    @Autowired
    public ApiSecurityController(ApiSecurityService apiSecurityService) {
        this.apiSecurityService = apiSecurityService;
    }

    @PostMapping("/api-key")
    public ResultVO<String> generateApiKey(@RequestBody ApiKeyGenRequest apiKeyGenRequest) {
        int keyLen = apiKeyGenRequest.getKeyLen();
        boolean mixedLetter = apiKeyGenRequest.getMixedLetter();
        return apiSecurityService.generateApiKey(keyLen, mixedLetter);
    }

    @PostMapping("/md5/hex")
    public ResultVO<String> md5Hex(@RequestBody Md5HexRequest md5HexRequest) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String data = md5HexRequest.getData();
        boolean upperCase = md5HexRequest.getUpperCase();
        return apiSecurityService.md5Hex(data, upperCase);
    }
}
