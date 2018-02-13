package dodo.look.grade.controller.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import dodo.look.grade.mapper.owner.OwnerInfoMapper;
import dodo.look.grade.mapper.security.LoginMapper;
import dodo.look.grade.pojo.owner.OwnerInfo;
import dodo.look.grade.tool.GeneralTool;

/**
 * 
* @ClassName: AbstractWeightService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月8日 上午11:50:04 
*
 */
public abstract class AbstractWeightService {

	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	protected  OwnerInfoMapper ownerInfoMapper;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	private void initGeneralPwd(List<OwnerInfo> list) {
		
		for(OwnerInfo info:list) {			
			info.setSalt(GeneralTool.GenerateKey.SaltKey());
			info.setLoginPwd("1234");
			info.setEncodePwd(md5PasswordEncoder.encodePassword(info.getLoginPwd(), info.getSalt()));
			
		}
	}
	
	@Transactional
	protected Boolean processOwnInfo(List<OwnerInfo> list) {
		
		int result1 = ownerInfoMapper.add(list);
		
		initGeneralPwd(list);
		
		int result2 = loginMapper.add(list);
		
		if(result1 > 0 && result2 > 0) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
	
	@Transactional
	protected Boolean delOwnInfo(String[] ownIds) {
		
		int result1 = ownerInfoMapper.del(ownIds);
		
		int result2 = loginMapper.del(ownIds);
		
		if(result1 > 0 && result2 > 0) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	
	@Transactional
	protected Boolean updOwnInfo(OwnerInfo ownerInfo) {
		
		int result1 = ownerInfoMapper.upd(ownerInfo);
		
		int result2 = loginMapper.updLoginName(ownerInfo);
		
		if(result1 > 0 && result2 > 0) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	
	
}
