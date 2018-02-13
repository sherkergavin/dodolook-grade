package dodo.look.grade.pojo.json;
/**
 * 
* @ClassName: AjaxVo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月6日 下午2:34:22 
*
 */
public class AjaxVo {

    private Boolean success;

    private String message;

    public AjaxVo() {}

    public AjaxVo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AjaxVo [success=" + success + ", message=" + message + "]";
    }

}