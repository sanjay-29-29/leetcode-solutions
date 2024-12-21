/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {
    var isExecuting = false;
    var timeout = null;
    return function (...args) {
        if (isExecuting) {
            clearTimeout(timeout);
        } 
        isExecuting = true;
        timeout = setTimeout(() => {
            fn(...args);
            isExecuting = false;
        }, t);
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
