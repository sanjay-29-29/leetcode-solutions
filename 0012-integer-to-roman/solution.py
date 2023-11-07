class Solution(object):
    
    VALUES = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
    ROMAN_LETTERS =["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"]
    
    def intToRoman(self, num):
        if type(num) != int:
            raise TypeError('argument must be of type int')
        if (num < 1 or num > 3999):
            raise ValueError('argument must be in range [1-3999]')
        roman = []
        for value, roman_letter in zip(self.VALUES, self.ROMAN_LETTERS):
            while(num >= value):
                num = num - value
                roman.append(roman_letter)
        return ''.join(roman)
