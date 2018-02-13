package dodo.look.grade.pojo.stand;

/**
 * 
* @ClassName: Position 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午3:27:12 
*
 */
public class Position {

	private int postId;
	
	private String postName;
	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	@Override
	public String toString() {
		return "Position [postId=" + postId + ", postName=" + postName + "]";
	}

}
