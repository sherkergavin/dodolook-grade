package dodo.look.grade.pojo.json;

/**
 * 
* @ClassName: AjaxData
* @Description: ajaxData
* @author GWJ
* @date 2017年11月2日 下午4:06:19 
*
 */
public class AjaxData<T> {

	private Boolean success;
	
	private T data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AjaxDataVo [success=" + success + ", data=" + data + "]";
	} 
	
}
