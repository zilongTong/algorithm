/**
 * @author Smile.Wu
 * @version 2015-5-14
 */
public class TestTimeCost {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            switch (2) {
            case 1:
                System.out.printf("1");
            case 2:
                System.out.printf("2");
                continue;
            case 3:
                System.out.printf("3");
            default:
                System.out.printf("de");

            }
        }
        int total = 4000;
        long count = 0;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                count++;
            }
        }

        System.out.println(count);
    }
}
