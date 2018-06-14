package org.zerock.service;

import java.util.List;


import org.zerock.domain.BoardVO;
import org.zerock.domain.Critaria;

public interface BoardService {
	
	public void create(BoardVO vo);
	public void remove(Integer bno);
	public void modify(BoardVO vo);
	public BoardVO getView(Integer bno);
	public List<BoardVO> getList(Critaria cri);
	public List<BoardVO> getSearchList(Critaria cri);
	public int getTotal();
	public int getSearchTotal(Critaria cri);
	public void viewHit(Integer bno);

}
