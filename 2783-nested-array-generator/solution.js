/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    const stack = [];
    const res = [];

    stack.push(arr);

    while(stack.length !== 0) {
        // console.log(stack);
        const arr = stack.pop();
        if(Array.isArray(arr) === true) {
            for(const val of arr) {
                stack.push(val);
            }
        } else {
            res.unshift(arr);
            // yield arr;
        }
    }

    for(const val of res) {
        yield val;
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
