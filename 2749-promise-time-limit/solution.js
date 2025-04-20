/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
    return async function (...args) {
        const promises = [
            new Promise((resolve, reject) => {
                fn(...args).then((val) => resolve(val)).catch((val) => reject(val))
            }),
            new Promise((resolve, reject) => { setTimeout(() => reject("Time Limit Exceeded"), t) })
        ]
        return Promise.race(promises);
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
