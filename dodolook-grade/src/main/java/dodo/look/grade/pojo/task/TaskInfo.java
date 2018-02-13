package dodo.look.grade.pojo.task;

import java.util.Date;

/**
 * 
* @ClassName: TaskInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:10:49 
*
 */
public class TaskInfo {
	
	//主键
	private Integer taskId;
	//创建者
	private String taskCreator;
	//创建者ID
	private Integer ownerId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//任务标题
	private String taskTitle;
	//任务内容
	private String taskContent;
	//开始时间
	private Date taskStart;
	//任务周期
	private Integer taskCycle;
	//任务状态
	private String taskStatus;
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskCreator() {
		return taskCreator;
	}
	public void setTaskCreator(String taskCreator) {
		this.taskCreator = taskCreator;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public Date getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(Date taskStart) {
		this.taskStart = taskStart;
	}
	public Integer getTaskCycle() {
		return taskCycle;
	}
	public void setTaskCycle(Integer taskCycle) {
		this.taskCycle = taskCycle;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@Override
	public String toString() {
		return "TaskInfo [taskId=" + taskId + ", taskCreator=" + taskCreator + ", ownerId=" + ownerId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", taskTitle=" + taskTitle + ", taskContent="
				+ taskContent + ", taskStart=" + taskStart + ", taskCycle=" + taskCycle + ", taskStatus=" + taskStatus
				+ "]";
	}
	
}
