package string_and_array;

// inputStr을 아웃풋에 맞게 바꿔라
// output -> 대문자 및 뒤에서부터 4자리씩 -
// sb로 뒤에서부터 4개
// String += 이나 concat은 new씀
// StringBuffer = 싱크 so 멀티스레드
// StringBuilder = 어싱크 so 단일스레드
// StringBuilder가 단일에서는 더 빠름

public class LicenseKeyFormatter {
	public static void main(String[] args) {
		String str = "8F3Z-2e-9-";
		int k = 4;
		LicenseKeyFormatter lkf = new LicenseKeyFormatter();
		System.out.println(lkf.solve(str, k));
	}
	private String solve(String str, int k) {
		str = str.replace("-", "");
		int len = str.length();
		
		StringBuffer sb = new StringBuffer(str);
		
		for(int i = k; i < sb.length(); i=i+k) sb.insert(len-i, "-");
		return sb.toString();
	}
}
