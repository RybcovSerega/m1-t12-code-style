import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }

    double calculateComplexPercent (double amount, double yearRate, int period) {
        double monthlyInterest = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round (monthlyInterest, 2);
    }

    double calculateSimplePercent (double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round (double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void calculateProfit() {
        int period;
        int action;
        double out = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
}
