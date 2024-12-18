/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    var count = 0;
    for(val in obj){
        count++;
        break;
    }
    if(count == 0) return true;
    return false;
};
