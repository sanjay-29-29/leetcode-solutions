/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const obj = {};
    for(let i = 0; i < this.length; i++) { 
        const val = this[i];
        const res = fn(val);

        if(obj[res] === undefined) {
            obj[res] = [this[i]];
        }else{
            obj[res].push(this[i]);
        }
    }

    return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
