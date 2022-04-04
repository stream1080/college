package com.stream.college.service.trade.feign.fallback;

import com.stream.college.common.utils.dto.MemberDto;
import com.stream.college.service.trade.feign.UcenterMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author stream
 * @since 2022-04-04
 */
@Service
@Slf4j
public class UcenterMemberServiceFallback implements UcenterMemberService {
    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {
        log.info("熔断保护");
        return null;
    }
}
