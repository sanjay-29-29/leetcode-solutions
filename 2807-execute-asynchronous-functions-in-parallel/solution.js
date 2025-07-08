/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
    let size = 0;
    const allPromise = new Promise((res, rej) => {
        const resArr = new Array(functions.length);
        for (let j = 0; j < functions.length; j++) {
            functions[j]().then((val) => {
                size++;
                resArr[j] = (val);
                if (size === functions.length) {
                    res(resArr);
                }
            }).catch(
                (err) => { rej(err) });
        }
    })
    return allPromise;
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
