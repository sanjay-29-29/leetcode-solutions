/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const res = []

    function recursiveFlat(arr, curr, n, res) {
        if(n < curr) {
            res.push(arr);
            return;
        }
        for(const i of arr) {
            if(Array.isArray(i)) {
                recursiveFlat(i, curr + 1, n, res);
            }
            else {
                res.push(i);
            }
        }

        // return res;
    }

    recursiveFlat(arr, 0, n, res);
    return res;
};
