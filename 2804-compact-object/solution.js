/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    if (Array.isArray(obj)) {
        const newArr = [];
        for (let val = 0; val < obj.length; val++) {
            if (Array.isArray(obj[val])) {
                newArr.push(compactObject(obj[val]));
            } else if (Boolean(obj[val]) === false) {
                continue;
            }
            else {
                newArr.push(compactObject(obj[val]));
            }
        }
        return newArr;
    }

    for (let val in obj) {
        // console.log(Boolean(obj[val]));
        if (Array.isArray(obj[val])) {
            obj[val] = compactObject(obj[val]);
        } else if (Boolean(obj[val]) === false) {
            // console.log(obj[val]);
            delete obj[val];
            // console.log(obj);
        }
        else if (typeof obj[val] === 'object') {
            compactObject(obj[val]);
        }
    }
    return obj;
};
