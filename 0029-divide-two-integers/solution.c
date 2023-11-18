int divide(int dividend, int divisor) {
    if (dividend == INT_MIN && divisor == -1)
        return INT_MAX; // Handling edge case to prevent overflow

    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    long long lldividend = labs(dividend);
    long long lldivisor = labs(divisor);

    long long quotient = 0;
    while (lldividend >= lldivisor) {
        long long temp = lldivisor, multiple = 1;
        while (lldividend >= (temp << 1)) {
            temp <<= 1;
            multiple <<= 1;
        }
        lldividend -= temp;
        quotient += multiple;
    }

    if (sign == -1)
        quotient = -quotient;

    if (quotient > INT_MAX)
        return INT_MAX;
    else if (quotient < INT_MIN)
        return INT_MIN;
    else
        return (int)quotient;
}

