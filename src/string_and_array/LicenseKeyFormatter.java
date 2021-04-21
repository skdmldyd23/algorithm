package string_and_array;

// inputStr�� �ƿ�ǲ�� �°� �ٲ��
// output -> �빮�� �� �ڿ������� 4�ڸ��� -
// sb�� �ڿ������� 4��
// String += �̳� concat�� new��
// StringBuffer = ��ũ so ��Ƽ������
// StringBuilder = ���ũ so ���Ͻ�����
// StringBuilder�� ���Ͽ����� �� ����

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
