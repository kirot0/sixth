package ac.scggi.app.reference;

public class Student {
	public String name;
	public String address;
	public int kor;
	public int eng;
	public int math;
	
	public Student(String name, String address, int kor, int eng, int math) {
		this.name = name;
		this.address = address;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void showInfo() {
		System.out.println("이름 "+name);
		System.out.println("주소 "+address);
		System.out.println("국어점수 "+kor);
		System.out.println("영어점수 "+eng);
		System.out.println("수학점수 "+math);
		System.out.println("총점 "+(kor+eng+math));
	}
}
