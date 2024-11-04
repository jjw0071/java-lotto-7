package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static int money;
    private static List<Lotto> lottos;
    private static final int lottoNumbersCount = 6;
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                money = getMoneyInput();
                buyLotto();
                break;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void buyLotto() {
        int lottoCount = money/1000;
        for(int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,lottoNumbersCount);
            lottos.add(new Lotto(numbers));
        }
    }

    public static int getMoneyInput() throws Exception{
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    public static void validateMoney(String input) throws Exception{
        isInteger(input);
        isMultipleOf1000(Integer.parseInt(input));
    }

    public static void isMultipleOf1000(int inputInt) throws Exception{
        if(inputInt%1000 != 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void isInteger(String input) throws Exception{
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new NumberFormatException("정수여야 합니다.");
        }
    }

    public static void splitWithComma(String input) throws Exception{
        String[] splitted = input.split(",");
        if(splitted.length != lottoNumbersCount){
            throw new IllegalArgumentException("숫자들은 ,(콤마)로 구분되어야 합니다.");
        }
    }
}
