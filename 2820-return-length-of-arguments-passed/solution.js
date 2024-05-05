/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    var count = 0;
    for(i in args){
        count++;
    }
    return count;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */
