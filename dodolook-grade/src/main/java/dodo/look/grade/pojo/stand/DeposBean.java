package dodo.look.grade.pojo.stand;

import java.util.Date;

/**
 * 
* @ClassName: DeposBean 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午4:30:18 
*
 */
public class DeposBean {

	private Integer colId;
	
	private String colName;

	private Date createTime;
	
	public Integer getColId() {
		return colId;
	}

	public void setColId(Integer colId) {
		this.colId = colId;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DeposBean [colId=" + colId + ", colName=" + colName + ", createTime=" + createTime + "]";
	}

}
