package cn.weishop.demo;

public class Page {
	   private int currNo=1;//当前页面
	   private int currSize=4;//页面条数
	   private int countCurrNo;//总页码
	   private int countCurrSize;//总数据
	public int getCurrNo() {
		return currNo;
	}
	public void setCurrNo(int currNo) {
		this.currNo = currNo<=0?this.currNo:currNo
				>this.countCurrNo?this.countCurrNo:currNo
				;
	}
	public int getCurrSize() {
		return currSize<=0?this.currSize:currSize;
	}
	public void setCurrSize(int currSize) {
		this.currSize = currSize;
	}
	public int getCountCurrNo() {
		return countCurrNo;
	}
	public void setCountCurrNo(int countCurrNo) {
		this.countCurrNo = countCurrNo;
	}
	public int getCountCurrSize() {
		return countCurrSize;
	}
	public void setCountCurrSize(int countCurrSize) {
		this.countCurrSize = countCurrSize;
		this.countCurrNo = this.countCurrSize==0?
				1:this.countCurrSize%this.currSize==0?
						this.countCurrSize/this.currSize:
							this.countCurrSize/this.currSize+1;
	}
}
