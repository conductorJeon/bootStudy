package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.dto.MemberDTO;
import com.sist.web.entity.MemberEntity;
import com.sist.web.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public MemberDTO memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		int count = memberRepository.memberIdCount(id);
		
		if (count == 0) {
			dto.setMsg("NOID");
		} else {
			MemberEntity memberEntity = memberRepository.memberGetPassword(id);
			
			if (pwd.equals(memberEntity.getPwd())) {
				dto.setId(id);
				dto.setName(memberEntity.getName());
				dto.setMsg("OK");
			} else {
				dto.setMsg("NOPWD");
			}
		}
		return dto;
	}
}
