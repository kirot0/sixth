package ac.scggi.app;

public class PrimitiveType {
	byte b;
	short s;
	int i;
	long l;
	
	float f;
	double d;
	
	char c;
	boolean isPrimitive;
	public PrimitiveType(byte b, short s, int i, long l, float f, double d, char c, boolean isPrimitive) {
		super();
		this.b = b;
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
		this.c = c;
		this.isPrimitive = isPrimitive;
	}
	public static void main(String[] args) {
		PrimitiveType pt = new PrimitiveType((byte)1000, (short)100, 1000, 10000L, 10f, 10.0, 'A', true);
		System.out.println(pt.b);
		System.out.println(pt.s);
	}
}
