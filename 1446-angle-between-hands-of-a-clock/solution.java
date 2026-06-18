class Solution {
    public double angleClock(int h, int m) {
        double hour = (double)h;
        double minutes = (double)m;
    
        double hourAngle = (hour * 30) + (30 / (60 / minutes));

        if(hourAngle > 360) {
            hourAngle -= 360;
        }

        double minutesAngle = minutes * 6;

        // System.out.println(hourAngle + " " + minutesAngle);

        return Math.min(
            360 - Math.abs(hourAngle - minutesAngle),
            Math.abs(hourAngle - minutesAngle)
        );

        // System.out.println(hourAngle + " " + minutesAngle);

        // return Math.abs(hourAngle - minutesAngle);
    }
}
