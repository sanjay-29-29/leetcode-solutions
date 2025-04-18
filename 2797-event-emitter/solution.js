class EventEmitter {
    
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {this.object}
     */
    obj = {

    }

    subscribe(eventName, callback) {
        if(this.obj[eventName] !== undefined) {
            this.obj[eventName].add(callback);
        }else{
            this.obj[eventName] = new Set();
            this.obj[eventName].add(callback);
        }

        return {
            unsubscribe: () => {
                this.obj[eventName].delete(callback);
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        const res = []
        const set = this.obj[eventName]
        if(set !== undefined) {
            for(var fun of set) {
                res.push(fun(...args));
            }
        }

        return res;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */
