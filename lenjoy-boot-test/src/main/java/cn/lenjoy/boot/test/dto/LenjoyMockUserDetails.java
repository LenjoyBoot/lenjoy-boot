package cn.lenjoy.boot.test.dto;

import cn.lenjoy.boot.framework.security.core.userdetails.LenjoyUserDetails;
import cn.lenjoy.boot.framework.security.core.util.LenjoyAuthorityUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */

public class LenjoyMockUserDetails {
    public static void main(String[] args) {
        Set<GrantedAuthority> authoritySet = LenjoyAuthorityUtils.createAuthoritySet("1", "2");
        LenjoyUserDetails lenjoyUserDetails = new LenjoyUserDetails("","", authoritySet);
        LenjoyUserDetails userDetails = LenjoyUserDetails.withUserDetails(lenjoyUserDetails).build();


    }
}
