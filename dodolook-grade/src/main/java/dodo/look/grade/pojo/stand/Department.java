package dodo.look.grade.pojo.stand;

/**
 * 
* @ClassName: DepartMent 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午3:24:39 
*
 */
public class Department {

	private int departId;
	
	private String departName;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@Override
	public String toString() {
		return "Department [departId=" + departId + ", departName=" + departName + "]";
	}

}
