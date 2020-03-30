package net.gondr.domain;

public class Criteria {
	private Integer page; // 현재 보고자 하는 페이지 번호
	private Integer perPageNum; // 페이지당 글의 갯수
	private Integer perChapterNum; // 챕터당 페이지의 수
	private String keyword;

	private boolean prev;
	private boolean next;
	private Integer start;
	private Integer end;
	private Integer totalPage;

	// 댓글 전용
	private Integer boardId; 
	private String type;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// 생성자
	public Criteria() {
		page = 1;
		perPageNum = 12;
		perChapterNum = 5;
		keyword = null;
		prev = true;
		next = true;
	}

	public void calculate(Integer total) {
		// 전체 글의 갯수인 total을 받아서 페이징을 위한 값들을 만들어줍니다.
		totalPage = (int) Math.ceil((double) total / perPageNum);
		System.out.println("CAL :"+totalPage);
		if (totalPage == 0)
			totalPage = 0;

		// 끝번호
		end = (int) Math.ceil((double) page / perChapterNum) * perChapterNum;
		start = end - perChapterNum + 1; // 시작번호

		if (end >= totalPage) {
			end = totalPage;
			next = false;
		}

		if (start == 1) {
			prev = false;
		}
	}

	public String getQuery(Integer page) {
		System.out.println(page);
		String q = "?page=" + page;
		if (this.keyword != null) {
			
			q += "&keyword=" + this.keyword;
		}
		System.out.println(q);
		return q;
	}
	
	public Integer getPageStart() {
		return (page - 1) * perPageNum;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(Integer perPageNum) {
		this.perPageNum = perPageNum;
	}

	public Integer getPerChapterNum() {
		return perChapterNum;
	}

	public void setPerChapterNum(Integer perChapterNum) {
		this.perChapterNum = perChapterNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getBoardId() {
		return boardId;
	}
	
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
}
