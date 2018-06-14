package org.zerock.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Critaria;
import org.zerock.mapper.BoardMapper;
import lombok.Setter;



@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_={@Autowired})	
	private BoardMapper mapper;

	@Override
	public void create(BoardVO vo) {
		
		mapper.insert(vo);
	}

	@Override
	public void remove(Integer bno) {
		
		
		mapper.delete(bno);

	}

	@Override
	public void modify(BoardVO vo) {
		
		mapper.update(vo);
	}

	@Override
	public BoardVO getView(Integer bno) {
		
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList(Critaria cri) {
		
		return mapper.list(cri);
	}

	@Override
	public List<BoardVO> getSearchList(Critaria cri) {
		
		return mapper.searchList(cri);
	}

	@Override
	public int getTotal() {
		
		return mapper.total();
	}

	@Override
	public int getSearchTotal(Critaria cri) {
		
		return mapper.searchTotal(cri);
	}

	@Override
	public void viewHit(Integer bno) {
		
		mapper.viewHit(bno);
		
	}
	
	
	
	

}
