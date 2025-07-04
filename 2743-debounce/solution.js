/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {
    let timeOut = null;
    return function (...args) {
        if (!timeOut) {
            timeOut = setTimeout(() => {
                fn(...args);
                timeOut = null;
            }, t);
        } else {
            clearTimeout(timeOut);
            timeOut = setTimeout(() => {
                fn(...args);
                timeOut = null;
            }, t);
        }
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
