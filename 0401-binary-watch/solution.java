class Solution {
    List<String> pos = new ArrayList<>();
    
    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn >= 9) {
            return new ArrayList<>();
        }

        Set<String> res = new HashSet<>();
        recurse("", turnedOn); 

        for(String s : pos) {
            int h = Integer.parseInt(s.substring(0, 4), 2);
            int min = Integer.parseInt(s.substring(4, 10), 2);

            if(h > 11 || min > 59) {
                continue;
            }

            StringBuilder time = new StringBuilder();

            // if(h < 10) {
            //     time.append("0" + h + ":");
            // } else {
                time.append(h + ":");
            // }

            if(min < 10) {
                time.append("0" + min);
            } else {
                time.append(min);
            }

            res.add(time.toString());
        }

        return new ArrayList<>(res); 
    }

    private void recurse(String res, int digits) {
        if(res.length() > 10) {
            return;
        }
        if(digits == 0 && res.length() == 10) {
            pos.add(res);
            return;
        } 
        recurse("0" + res,  digits);
        recurse("1" + res,  digits - 1);
    }
}
