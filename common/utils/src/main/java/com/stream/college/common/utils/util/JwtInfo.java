package com.stream.college.common.utils.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author stream
 * @since 2022/4/3 19:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtInfo {

    private String id;

    private String nickname;

    private String avatar;

    //权限、角色等
    //不要存敏感信息
}
