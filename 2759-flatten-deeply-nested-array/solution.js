/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */

var flat = function (arr, n) {
    let newArr = [];

    if (n == 0) {
        return arr;
    }

    for (let i = 0; i < arr.length; i++) {
        if (Array.isArray(arr[i])) {
            newArr.push(...flat(arr[i], n - 1));
        } else {
            newArr.push(arr[i]);
        }
    }

    return newArr;
};
