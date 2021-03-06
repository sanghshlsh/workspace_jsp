package kr.co.domain;

import java.util.List;

public class PageTO {
	// 종속변수들의변화를 반영하는 메서드 만들어야한다. changeVarVal() method
	// 이 메서드는 종속변수들이 변경 될 상황이 나을 떄 호출해줘야한다.
	private int curPage = 1;
	private int perPage = 5;// 한페이지 몇글 보여주는지
	private int pageLine = 10;// 한페이지에보여줄 수 있는 페이지 숫자 1~10 11~20 21~30 페이지 넘버링
	private int amount;// 게시글 총 갯수
	private int totalPage;// amount+perPage에 종속되는 종속변수
	private int startNum;// rowNum값을 의미 //curPage+perPage종속변수
	private int endNum;// rowNum값을 의미
	private int beginPageNum;// 1~10 11~20 의미 curPage에 종속되는 종속변수
	private int stopPageNum;// 1~10 11~20 의미 curPage에 종속되는 종속변수

	private List<BoardDTO> list;

	public PageTO() {
		changeVarVal();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();

	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}

	private void changeVarVal() {
//		totalPage = amount / perPage;
//		if (amount % perPage != 0) {
//			totalPage++;
//		}
		//아래를 더 자주 사용
		totalPage = (amount-1)/perPage +1;

		startNum = perPage * (curPage - 1) + 1;
		endNum = perPage * curPage;
		if (endNum > amount) {
			endNum = amount;
		}

		beginPageNum = ((curPage - 1) / pageLine) * pageLine + 1;
		stopPageNum = beginPageNum + (pageLine - 1);
		if (stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}

	}

}
