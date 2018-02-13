package dodo.look.grade.pojo.menu;

import java.util.List;

/**
 * 
* @ClassName: Menu 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月5日 上午10:49:16 
*
 */
public class Menu {
	private int id;

	private int level;
	
	private String text;
	
	private Boolean leaf;
	
	private int parentId;
	
	private Boolean expanded;

	private String hrefTarget;
	
	private List<Menu> children;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	
	public String getHrefTarget() {
		return hrefTarget;
	}

	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", level=" + level + ", text=" + text + ", leaf=" + leaf + ", parentId=" + parentId
				+ ", expanded=" + expanded + ", hrefTarget=" + hrefTarget + ", children=" + children + "]";
	}
	
}
