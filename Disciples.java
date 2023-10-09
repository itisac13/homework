public class Disciples {
    public static double Log(long number, long base)
    {
        return  (Math.log(number) / Math.log(base));
    }

    // this assumes that each disciple regularly trains disciples every 3 years (i.e. each one does not stop training
    // after training first two disciples)
    /*
    0th iteration: There are 13 disciples, 0 years have passed
    1st iteration: Each disciple trains 2 disciples, so there are now 13 + 13*2 = 13*3 = 39 disciples now, 3 years have passed
    2nd iteration: Each disciple trains 2 disciples, so there are now 39 + 39*2 = 39*3 = 13*9 = 117 disciples now, 6 years have passed
    nth iteration: Each disciple trains 2 disciples, so there are 13 * 3^n disciples now. 3n years have passed

    This function is basically just the solution to the equation population = 13 * (3**(years / 3)) when solving for years
    And where '13' is replaced by a variable (initialDisciples)
     */
    public static double yearsToConvertPopulation(long initialDisciples, long population)
    {
        return 3*Log(population / initialDisciples, 3);
    }

    public static long initialDisciplesRequired(long years, long population)
    {
        return (long) (population * Math.pow(3, (double) -years / 3));
    }



    public static void main(String[] args) {
        long initialDisciples = 13;
        long totalPopulation = 7700000000L;

        double numberOfYears = yearsToConvertPopulation(initialDisciples, totalPopulation);

        System.out.println("It will take " + numberOfYears + " years for the entire world to be turned into disciples, given 13 initial disciples.");


        long targetNumberOfYears = 50;

        long initialDisciplesRequired = initialDisciplesRequired(targetNumberOfYears, totalPopulation);
        System.out.println("If we want the evangelizing to take 50 years, we would need approximately" + initialDisciplesRequired + " initial disciples");


    }
}
