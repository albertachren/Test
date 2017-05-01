package testG;


import java.util.*;
import java.util.concurrent.TimeUnit;

import testG.TestETsts;

//TEST

//Card system
class Cards {
	static Scanner scan = new Scanner(System.in);

	static Integer[] deck = { 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9,
			9, 9, 10, 10, 10, 10, 11, 11, 11, 11 };

	static volatile Integer aceInt = 1;
	static public volatile Ace ace = new Ace();
	List<Integer> cards = new LinkedList<Integer>(Arrays.asList(deck));
	
	
	static synchronized void threadWait() {
		try {
			Cards.class.wait();
		} catch (InterruptedException e) {
		}
	}

	// Constructor
	public Cards() {
		Collections.shuffle(cards);
	}

	// Diagnostic
	void print() {
		System.out.println(cards);
	}

	void deal(List<Integer> hand, int amount, boolean auto) {
		int count = 1;
		do {
			int temp = cards.remove(0);
			if (temp == 11) {

				if (auto == true && (hand.stream().mapToInt(Integer::intValue).sum() + 11) > 21) {
					temp = 1;
				} else if (auto == true) {
					break;
				} else if (auto == false) {
					System.out.println("You got an Ace, 1 or 11?");
					ace.setVisible(true);
				}
				boolean tempW = true;
				while (tempW == true) {
					threadWait();
					switch (aceInt) {
					case 1:
						temp = 1;
						tempW = false;
					case 11:
						tempW = false;
					default:
						break;
					}
				}
			}
			hand.add(temp);
			TestG.notifTestG();
			count++;
		} while (count <= amount);
	}
}

// Hand object
class Hand {

	
	
	
	List<Integer> hand = new ArrayList<Integer>();

	public Hand() {

	}

	public String getHand() {
		String cont = "";
		for (int i = 0; i < hand.size(); i++) {
			int temp = 0;
			String templ = "|";

			if (i == hand.size() - 1) {
				templ = "";
			}

			temp = (int) hand.get(i);
			cont += temp + templ;
		}
		return cont;
	}

	public Boolean compare(Hand target) {
		Boolean win = false;

		Integer handDiff = 21 - hand.stream().mapToInt(Integer::intValue).sum();
		Integer targetDiff = 21 - target.hand.stream().mapToInt(Integer::intValue).sum();

		if (targetDiff < 0) {
			win = true;
		} else if (handDiff < 0) {
			win = false;
		} else if (handDiff < targetDiff) {
			win = true;
		}
		return win;
	}
}

public class TestG {
	
	static Scanner scan = new Scanner(System.in);
	static String input = "";
	static String reset = "";
	static Cards pack;
	static Hand player;
	static Hand dealer;
	static Boolean restart;
	static Boolean playing = true;
	static Boolean win = null;
	

	static synchronized void threadTest() {
	
		try {
			TestG.class.wait();
		} catch (InterruptedException e) {
		}
	}

	static synchronized void notifTestG() {
		TestG.class.notify();

	}

	public static void main(String[] args) {
		// GUI
		TestETsts.main(args);

		do {
			restart = false;
			player = new Hand();
			dealer = new Hand();

			// Generating card pack
			pack = new Cards();

			// Dealing cards
			pack.deal(player.hand, 2, false);
			pack.deal(dealer.hand, 1, true);

			do {

				TestETsts.textPane.setText(player.getHand());
				TestETsts.textPane_1.setText(dealer.getHand());

				System.out.println("Your hand:" + " " + player.getHand() + " " + "=" + " " + player.hand.stream().mapToInt(Integer::intValue).sum());
				System.out.println("Dealers hand:" + " " + dealer.getHand());

				System.out.println("Hit/Stand?");
				
				TestETsts.btnHit.setEnabled(true);
				TestETsts.btnStand.setEnabled(true);
				
				threadTest();

				if (input.equals("Hit")) {
					pack.deal(player.hand, 1, false);
					if (player.hand.stream().mapToInt(Integer::intValue).sum() > 21) {
						TestETsts.btnHit.setEnabled(false);
						TestETsts.btnStand.setEnabled(false);
						win = false;
						playing = false;
						continue;
					}

				} else if (input.equals("Stand")) {
					TestETsts.btnHit.setEnabled(false);
					TestETsts.btnStand.setEnabled(false);

					/*playing = false;
					pack.deal(dealer.hand, 1, false);
					System.out.println("Dealers hand:" + " " + dealer.getHand() + " " + "=" + " "
							+ dealer.hand.stream().mapToInt(Integer::intValue).sum());

					TestETsts.textPane_1.setText(dealer.getHand());
					 */
					while (dealer.hand.stream().mapToInt(Integer::intValue).sum() < 17) {
						playing = false;
						pack.deal(dealer.hand, 1, true);
						System.out.println("Dealers hand:" + " " + dealer.getHand() + " " + "=" + " "
								+ dealer.hand.stream().mapToInt(Integer::intValue).sum());

						TestETsts.textPane_1.setText(dealer.getHand());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					win = player.compare(dealer);
				} else {
					System.out.println("invalid answer");

				}
			} while (playing == true);

			if (win == true) {
				System.out.println("You win!");
				TestETsts.textPane.setText("Win!");
				TestETsts.textPane_1.setText(dealer.getHand());

			} else {
				System.out.println("You lose!");
				TestETsts.textPane_1.setText("Win!");
				TestETsts.textPane.setText(player.getHand());

			}
			System.out.println("Your hand:" + " " + player.getHand() + " " + "=" + " " + player.hand.stream().mapToInt(Integer::intValue).sum());
			System.out.println("Dealers hand:" + " " + dealer.getHand() + " " + "=" + " " + dealer.hand.stream().mapToInt(Integer::intValue).sum());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Try again? Y/N");
			TestETsts.mntmRestart.setEnabled(true);
			threadTest();

			if (reset.equals("Y")) {
				restart = true;
				win = false;
				playing = true;
				TestETsts.textPane.setText("");
				TestETsts.textPane_1.setText("");
				TestETsts.mntmRestart.setEnabled(false);
			}
		} while (restart);
	}

}
