public final class StatisticsPrinter {
    /**
     * Выводит статистику в консоль
     * @param stats Объект статистики
     * @param fullStats Флаг для вывода полной или краткой статистики
     */
    public void printStatistics(Statistics stats, boolean fullStats) {
       /* if(stats == null) {
            System.out.println("Статистика не доступна");
            return;
        }

        if(fullStats) {
            if (stats.getShortestLength() > 0) {// для строк
                System.out.printf("Длина самой короткой строки: ", stats.getShortestLength());
                System.out.printf("Длина самой длинной строки: ", stats.getLongestLength());
            } else { //для чисел
                System.out.printf("Среднее значение: %.2f%n", stats.getAverage());
                System.out.printf("Количество элементов: %d%n", stats.getCount());
                System.out.printf("Минимальное значение: %.2f%n", stats.getMin());
                System.out.printf("Максимальное значение: %.2f%n", stats.getMax());
                System.out.printf("Сумма значений: %.2f%n",stats.getSum());

            }
        }

        */

        if(fullStats) {
            //вывод полной статистики для чисел
            System.out.println("Количество: " + stats.getCount());
            if (stats.getMin() != 0) {
                System.out.printf("Минимальное значение: %.2f%n", stats.getMin());
            }
            if (stats.getMax() != 0) {
                System.out.printf("Максимальное значение: %.2f%n", stats.getMax());
            }
            if (stats.getSum() != 0) {
                System.out.printf("Сумма: %.2f%n", stats.getSum());
            }
            if (stats.getAverage() != 0) {
                System.out.printf("Среднее значение: %.2f%n", stats.getAverage());

            }

            //вывод статистики для строк
            if (stats.getShortestLength() != 0) {
                System.out.println("Длинна самой короткой строки: " + stats.getShortestLength());
            }
            if (stats.getLongestLength() != 0) {
                System.out.println("Длина самой длинной строки: " + stats.getLongestLength());
            }
        }
    }

}
