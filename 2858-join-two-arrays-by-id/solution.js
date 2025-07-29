/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function (arr1, arr2) {
    const map = {};
    for (let i = 0; i < arr1.length; i++) {
        const obj = arr1[i];
        if (map[obj["id"]] === undefined) {
            map[obj["id"]] = obj;
        } else {
            map[obj["id"]] = { ...map[obj["id"]], ...obj };
        }
    }
    for (let i = 0; i < arr2.length; i++) {
        const obj = arr2[i];
        if (map[obj["id"]] === undefined) {
            map[obj["id"]] = obj;
        } else {
            map[obj["id"]] = { ...map[obj["id"]], ...obj };
        }
    }
    const res = [];
    for (let i in map) {
        res.push(map[i]);
    }
    return res;
};
