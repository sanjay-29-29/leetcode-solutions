class Solution(object):
    def maximumLengthSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0

        for i in range(0, len(s)):
            for j in range(0, len(s) + 1):
                sub_str = s[i:j]
                m = {}

                for k in sub_str:
                    m[k] = m.get(k, 0) + 1
                
                flag = False

                for k, v in m.items():
                    if v >= 3:
                        flag = True
                
                if not flag:
                    res = max(res, len(sub_str))

        return res
