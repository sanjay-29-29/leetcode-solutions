/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const res = [];
    var temp = [];

    for(let i in arr){
        if(temp.length === size){
            res.push(temp);
            temp = new Array();
            temp.push(arr[i]);
        }else{
            temp.push(arr[i]);
        }
    }

    if(temp.length !== 0){
        res.push(temp);
    }

    return res;
};

