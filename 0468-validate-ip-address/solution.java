class Solution {
    public String validIPAddress(String queryIP) {
        if (validIPv4(queryIP)) {
            return "IPv4";
        }
        if (validIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validIPv6(String ip) {
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == ':') {
                count++;
            }
        }
        if (count != 7) {
            return false;
        }

        String[] arr = ip.split("\\:");
        if (arr.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            String b = arr[i];
            if(b.length() == 0){
                return false;
            }
            if(b.length() > 4){
                return false;
            }
            for (int j = 0; j < b.length(); j++) {
                boolean a1 = (b.charAt(j) >= '0' && b.charAt(j) <= '9');
                boolean b1 = (b.charAt(j) >= 'A' && b.charAt(j) <= 'F');
                boolean c1 = (b.charAt(j) >= 'a' && b.charAt(j) <= 'f');
                if (!(a1 || b1 || c1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validIPv4(String ip) {
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                count++;
            }
        }
        if (count != 3) {
            return false;
        }

        String[] arr = ip.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            String a = arr[i];
            if(a.length() == 0){
                return false;
            }
            if (a.charAt(0) == '0' && a.length() > 1) {
                return false;
            }
            try {
                int b = Integer.valueOf(a);
                if (!(0 <= b && b <= 255)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
