class Solution {
    public char toHexChar(int i) {
        if (i >= 0 && i <= 9) {
            return (char) (i + '0');
        }
        i = i - 10;
        return (char) (i + 'A');
    }

    private char toHexTriChar(int i) {
        if (i >= 0 && i <= 9) {
            return (char) (i + '0');
        }
        i = i - 10;
        return (char) (i + 'A');
    }

    public String concatHex36(int n) {
        int n1 = n * n, n2 = n * n * n;
        StringBuilder hex = new StringBuilder(), hexTri = new StringBuilder();

        while (n1 > 0) {
            hex.append(toHexChar(n1 % 16));
            n1 /= 16;
        }

        while (n2 > 0) {
            hexTri.append(toHexTriChar(n2 % 36));
            n2 /= 36;
        }

        hex.reverse();
        hexTri.reverse();
        hex.append(hexTri);
        return hex.toString();
    }
}
