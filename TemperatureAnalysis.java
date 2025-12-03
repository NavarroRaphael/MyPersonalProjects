public class TemperatureAnalysis {
    public static void main(String[] args) {
        // 2D array to store daily temperature readings for 3 cities over 7 days
        int[][] temperatures = {
            {24, 23, 22, 17, 16, 21, 23},  // Baguio city
            {24, 28, 23, 33, 31, 30, 29},  // Dagupan 
            {31, 30, 21, 22, 32, 23, 17}   // Nueva Ecija
        };

        // Calculate the average temperature for each city
        for (int city = 0; city < temperatures.length; city++) {
            int total = 0;
            int highest = temperatures[city][0];  // Initialize highest with the first day's temperature
            for (int day = 0; day < temperatures[city].length; day++) {
                total += temperatures[city][day];
                if (temperatures[city][day] > highest) {
                    highest = temperatures[city][day];  // Update highest temperature
                }
            }
            double average = (double) total / temperatures[city].length;  // Calculate average
            System.out.println("City " + (city + 1) + ":");
            System.out.println("  Average Temperature: " + average + "°C");
            System.out.println("  Highest Temperature: " + highest + "°C");
        }
    }
}

