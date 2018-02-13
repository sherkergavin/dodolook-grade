package dodo.look.grade.tool;

import java.lang.reflect.Field;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * 
* @ClassName: GeneralTool 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月8日 下午12:02:30 
*
 */
public class GeneralTool {

	private static  Logger logger = LoggerFactory.getLogger(GeneralTool.class);
	
	
	public static class GenerateKey{
		/**
		 * 
		* @Title: PrimaryKey 
		* @Description: 生成主键
		* @param @return    设定文件 
		* @return Long    返回类型 
		* @throws
		 */
		public static final Long PrimaryKey(){
			
			StringBuffer sb = new StringBuffer(); 
			Calendar cal = Calendar.getInstance();
			sb.append(cal.get(Calendar.YEAR));
			sb.append(cal.get(Calendar.MONTH)+1);
			sb.append(cal.get(Calendar.DAY_OF_MONTH));
			sb.append(cal.get(Calendar.HOUR_OF_DAY));
			sb.append(cal.get(Calendar.MINUTE));
			sb.append(cal.get(Calendar.MILLISECOND));
			sb.append((int)(Math.random()*9000)+1000);
			
			logger.info("主键 生成ID:===>"+Long.valueOf(sb.toString()));
			return Long.valueOf(sb.toString());
		} 
		/**
		 * 
		* @Title: SaltKey 
		* @Description: 生成加密权重 
		* @param @return    设定文件 
		* @return Integer    返回类型 
		* @throws
		 */
		public static final Integer SaltKey(){
			Integer saltKey = (int)(Math.random()*900)+100;
			logger.info("saltKey 生成:===>"+saltKey);
			return saltKey;
		}

	}
	
	public static final class cloneObject{
		
		/**
		 * 
		* @Title: clone 
		* @Description: 各层对象之间的克隆
		* @param @param sourceObj
		* @param @param target
		* @param @return    设定文件 
		* @return T    返回类型 
		* @throws
		 */
		public static final <T>T clone(Object sourceObj,T target){	
			Class<?> sourceClazz = sourceObj.getClass();
			Class<? extends Object> targetClazz = target.getClass();
			
			Field[] sourceFieldArr = sourceClazz.getDeclaredFields();
	
			for(Field field:sourceFieldArr){
				try {
					field.setAccessible(true);
					Field targetField = targetClazz.getDeclaredField(field.getName());
					targetField.setAccessible(true);
					targetField.set(target,field.get(sourceObj));
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					logger.info("对象 克隆 属性不匹配:===>"+ e.getMessage());
					e.printStackTrace();
				}
			}
			return target;
		}
	}
	
	public static final class Pinyin {
			
			public static String getPinYinHeadChar(String str) {

				char[] charArr = str.toCharArray();
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<charArr.length;i++){
					if(isChinese(charArr[i])){
						sb.append(charArr[i]);
					}
				}
				
				String chineseStr = sb.toString();
				String convert = "";
				for (int j = 0; j < chineseStr.length(); j++) {
					char word = chineseStr.charAt(j);
					String[] pinyinArray;
					try {
						pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word,new HanyuPinyinOutputFormat());
						if (pinyinArray != null) {
							convert += pinyinArray[0].charAt(0);
						} else {
							convert += word;
						}
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				logger.info("汉子转拼音首字母:  "+str+" ==> "+convert);
				return convert;
			}
		}

	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		 if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				 || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				 || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				 || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			 return true;
		 }
		return false;
	}
	
	
	public static class Animal{
		
		public void move(){
			System.out.println("动物可以移动");
			
		}
	}
	
	public static class dog extends Animal{
		
		public void move(){
			System.out.println("狗可以跑 和走");
			
		}
		
		public void bark(){
			System.out.println("狗可以叫");
			
		}
	}
	
	
	public static void main(String[] args){
		
		 String cnStr = "你麻痹-你麻痹";
		 
		 System.out.println(GeneralTool.Pinyin.getPinYinHeadChar(cnStr));
		 
		 System.out.println(GeneralTool.GenerateKey.PrimaryKey());	
				

		 
		 
	}

}
