var TimeLimitedCache = function() {
    this.map = {};
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */ 
TimeLimitedCache.prototype.set = function(key, value, duration) {
    let exists = false;

    if(this.map[key] === null || this.map[key] === undefined){
        exists = true;
    } else{
        clearTimeout(this.map[key][0]);
        this.map[key] = null;
    }

    const fun = setTimeout(() => { 
        clearTimeout(this.map[key][0]);
        this.map[key] = null;
    }, duration)


    this.map[key] = [fun, value];

    return !exists;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if(this.map[key] === null || this.map[key] === undefined){
        return -1;
    }
    return this.map[key][1];
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let count = 0;
    for(const key in this.map) {
        if(this.map[key] !== null && this.map[key] !== undefined){
            count++;
        }
    }

    return count;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */
