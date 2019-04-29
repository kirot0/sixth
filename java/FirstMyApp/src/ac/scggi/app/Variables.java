package ac.scggi.app;

public class Variables {
	// �ν��Ͻ� ����
	int varType;
	// Ŭ���� ����
	static int version = 10;
	// �ν��Ͻ� �Լ� 
	void printInfo() {
		System.out.println(varType);
	}
	// entry point(������, ��������)
	public static void main(String[] args) {
		Variables intVar = new Variables();
		Variables floatVar = new Variables();
		
		intVar.varType = 1;
		floatVar.varType = 2;
		
		intVar.printInfo();
		floatVar.printInfo();
		
		intVar.version = 11;
		System.out.println(floatVar.version);
		
		Variables.version = 12;
		
		System.out.println(intVar.version);	// 12	
		System.out.println(floatVar.version); // 12
	}
}
