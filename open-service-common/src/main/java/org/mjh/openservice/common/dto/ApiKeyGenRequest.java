package org.mjh.openservice.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Neo Lia Marx
 * @date: 2022/4/21 20:52
 */
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiKeyGenRequest {
    private Integer keyLen;
    private Boolean mixedLetter;
}
