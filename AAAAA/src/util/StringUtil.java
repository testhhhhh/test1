package util;
/*
 * �ж��û������������Ƿ�Ϊ��
 */
public class StringUtil {
@SuppressWarnings("unused")
public static boolean isEmpty(String stf) {
	if("".equals(stf)||stf==null) {
		return true;
	}
	return false;
	
}
public static boolean isNotEmpty(String stf) {
	if(("".equals(stf.trim()))==false||stf!=null) {
		return true;
	}
	return false;
	
}
}
