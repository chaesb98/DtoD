package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReviewVO;
import org.zerock.mapper.ReviewMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service  // 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용함.
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewMapper remapper;
	
	@Override
	public ReviewVO get(Long bno) {
		log.info("get... 특정 글 내용을 조회 합니다!" + bno);
		return remapper.read(bno);
	}
	
	// 게시글 등록
	@Override
	public void register(ReviewVO review) {
		log.info("register 게시글등록 서비스 실행!" + review);
		remapper.insertSelectKey(review);
	}

	// 게시글 수정
	@Override
	public boolean modify(ReviewVO review) {
		log.info("modify... 게시글을 수정 처리합니다!" + review);
		return remapper.update(review) == 1;
	}

	// 게시글 삭제
	@Override
	public boolean remove(Long bno) {
		log.info("remove... 게시글을 삭제 처리 합니다!" + bno);
		// 정상적으로 삭제가 이루어지면 1이라는 값이 반환되기 때문에
		// '==' 연산자를 이용해서 true/false를 처리할 수 있습니다.
		return remapper.delete(bno) == 1;
	}

	@Override
	public List<ReviewVO> getList() {
		log.info("getList.......");
		return remapper.getList();
	}

	
	
	@Override
	public List<ReviewVO> getList(Criteria cri) {
		log.info("get List with criteria: "+cri);
		return remapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return remapper.getTotalCount(cri);
	}

//	@Override
//	public int getTotal(Criteria cri) {
//		log.info("get total count");
//		return remapper.getTotalCount(cri);
//	}


		
}


