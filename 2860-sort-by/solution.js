/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    return arr.sort(function(a1, b2){
        const a = fn(a1);
        const b = fn(b2);

        if(a > b){
            return 1;
        }
        if(a === b){
            return -1
        }
        if(a < b){
            return -1;
        }
    });
};
