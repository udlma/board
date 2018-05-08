package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;
import org.zerock.domain.Critaria;

public interface BoardMapper {
	
	public int insert(BoardVO vo);
	public int delete(Integer bno);
	public int update(BoardVO vo);
	public BoardVO read(Integer bno);
	public List<BoardVO> list(Critaria cri);
	public List<BoardVO> searchList(Critaria cri);
	public int total();
	public int searchTotal(Critaria cri);

}
