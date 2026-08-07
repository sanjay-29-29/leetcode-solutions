class EventEmitter {
    events = {

    } 

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        const e = this.events[eventName] ?? new Set()
        e.add(callback)
        this.events[eventName] = e

        return {
            unsubscribe: () => {
                e.delete(callback)
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        const e = this.events[eventName] ?? new Set()
        const res = []

        for(const func of e) {
            res.push(func(...args))
        }

        return res
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
