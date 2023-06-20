# JavaBaseBallGame
자바 숫자 야구 게임 입니다.


해당 코드는 중복이 없는 난수값 3개를 발생 시키는 함수 입니다.
```java
public int playGame() throws IOException {
		List<Integer> colist = new ArrayList<>();
		while (colist.size() != 3) {
			int rdNum = Math.abs(rd.nextInt() % 9) + 1;
			if (!colist.contains(rdNum)) {
				colist.add(rdNum);
			}
		}
		return playGame(colist);
	}
```
리스트의 길이가 3이 될때까지 반복하며, 발생된 난수값이 리스트 안에 없다면 즉, 중복된 값이 없다면 리스트에 추가합니니다.

리스트와 배열의 차이점
  * 리스트
    * 객체를 생성할때 크기를 지정하지 않습니다. 프로그래머가 리스트에 데이터를 추가할시 동적으로 리스트의 크기는 변경 됩니다. 또, 객체 생성 당시 리스트의 길이는 0 입니다.
  * 배열
    * 객체를 생성할때 크기를 지정하여 지정된 크기 이상의 데이터를 저장할수 없습니다. 또, 프로그래머가 직접 데이터를 입력하지 않았더라도, 객체를 생성할 당시 프로그래머가 지정한 크기로 배열의 길이가 지정됩니다.
   
<br>
실질적인 숫자 야구 게임을 진행하는 함수 입니다. 위, 난수값 3개를 발생 시키는 함수를 오버로딩한 함수 입니다.
<br>

```java
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
```
스트라이크, 볼을 확인하여 실질적인 야구 게임의 로직입니다. 위, 중복이 없는 난수값 3개를 발생시켜 매개변수를 통하여 전달 받습니다. 
<br>
해당 난수값을 저장한 리스트의 값을 통하여 사용자의 입력을 받아 볼, 스트라이크를 판독하게 됩니다.
<br>
우선 사용자의 입력을 받아 숫자 3개를 입력 받아 isValidateInput 이라는 함수를 통하여 게임 규칙의 부합한 입력인지 확인합니다. 만약 게임 규칙에 부합하지 않다면 리스트에 사용자가 입력한 값을 추가하지 않으며, 사용자는 해당 값을 다시 입력 해야합니다.
<br>
마지막으로 처음에 발생 시킨 난수 (정답) 과 사용자가 입력한 값들을 하나씩 비교하며 스트라이크와 볼을 확인하게 됩니다.
<br>

사용자가 입력한 숫자가 규칙에 부합한 숫자 인지 확인 하는 함수 입니다.
```java
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
```

![image](https://github.com/cmc0904/JavaBaseBallGame/assets/63144310/2ffa9c78-7fd4-4900-826e-daedfca4852f)
