package org.mjh.openservice.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Neo Lia Marx
 * @date: 2022/4/21 21:02
 */
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Md5HexRequest {
    private String data;
    private Boolean upperCase;
}
