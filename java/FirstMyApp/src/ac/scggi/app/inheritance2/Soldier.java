package ac.scggi.app.inheritance2;

public class Soldier extends Person {
	@Override
	public int makeMoney(int spendingTime) {
		int amount = super.makeMoney(spendingTime);
		return amount + (int)(amount*0.2);
	}
}
