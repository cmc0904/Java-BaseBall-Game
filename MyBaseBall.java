package baseball;

import java.io.*;
import java.util.*;

public class MyBaseBall {
	private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private final Random rd = new Random();
	private List<Integer> user = new ArrayList<>();
	
	private boolean isValidateInput(int input) {
		if(input == 0) {
			System.out.println("0은 입력 할수 업습니다.");
		} 
		if(input > 9) {
			System.out.println("9보다 큰 수를 입력 할수 없습니다.");
		} 
		if (user.contains(input)) {
			System.out.println("똑같은 수를 입력 할수 없습니다.");
		}
		
		return (input != 0 && input <= 9 && !user.contains(input));
	}

	
	public int playGame() throws IOException {
		List<Integer> colist = new ArrayList<>();
		while (colist.size() != 3) {
			int rdNum = Math.abs(rd.nextInt() % 9) + 1;
			if (!colist.contains(rdNum)) {
				colist.add(rdNum);
			}
		}
		System.out.println(colist.toString());
		return playGame(colist);
	}
	
	public int playGame(List<Integer> com) throws IOException {
		List<Integer> computer = com;

		int strike, ball, count;
		strike = ball = count = 0;
		int input;
		while(strike < 3 && count < 11) {
			count ++;
			
			while(user.size() != 3) {
				System.out.print(String.format("%d 번째 숫자를 입력 해주세요 :", user.size() + 1));
				try {					
					input = Integer.valueOf(in.readLine());
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력 할수 있습니다.");
					continue;
				}
				if(isValidateInput(input)) {
					user.add(input);
				}
			}
			
			strike = ball = 0;
			for (int i = 0; i < user.size(); i++) {
			    if (user.get(i) == com.get(i)) {
			        strike++;
			    } else if (com.contains(user.get(i))) {
			        ball++;
			    }
			}
			
			System.out.println("Strike: " + strike + " Ball: " + ball);
			user.clear();
		
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		MyBaseBall mb = new MyBaseBall();
		List<Integer> list = new ArrayList<>();
		int result; // 게임 결과값을 위한 변수 생성
		if (args.length == 3) {
			list.add(Integer.valueOf(1));
			list.add(Integer.valueOf(2));
			list.add(Integer.valueOf(3));
			result = mb.playGame(list);
		} else 
			result = mb.playGame();
		if (result < 2) {
			System.out.println("참 잘했어요");
		} else if (result < 5) {
			System.out.println("잘했어요");
		} else if(result < 9) {
			System.out.println("잘했어요");
		} else {
			System.out.println("잘했어요");
		}
	}
}
