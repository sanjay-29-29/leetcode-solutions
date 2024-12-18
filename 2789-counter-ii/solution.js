/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function (init) {
    let val = init;
    var curr = init;

    return {
        increment: function () {
            return ++curr;
        },

        decrement: function () {
            return --curr;
        },

        reset: function () {
            curr = val;
            return curr;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
