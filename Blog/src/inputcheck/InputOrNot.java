package inputcheck;
/*
 * �ж��û������������Ƿ�Ϊ��
 */
public class InputOrNot {
public static boolean isEmpty(String stf) {
	if("".equals(stf)||stf==null) {
		return true;
	}
	return false;
	
}
@SuppressWarnings("unused")
public static boolean isNotEmpty(String stf) {
	if(("".equals(stf.trim()))==false||stf!=null) {
		return true;
	}
	return false;
	
}
}
