public class Shopping {
	private int[] shopping = new int[5];

	public Shopping() {

	}

	public void addItem(int x, int y) {
		this.shopping[x] = y;
	}

	public int[] getShopping() {
		return shopping;
	}

}
