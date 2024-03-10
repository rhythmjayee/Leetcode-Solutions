type StoreVal = [number, any];
class TimeLimitedCache {
    // let store: {[key : number]: StoreVal};
    store: StoreVal;
    constructor() {
        this.store = {} as StoreVal;
    }
    
    set(key: number, value: number, duration: number): boolean {
        const timeHandler: any = setTimeout(() => (delete this.store[key]), duration);
        if(!this.store[key]) {
            this.store[key] = [value, timeHandler];
            return false;
        }
        const storedValue: StoreVal = this.store[key];
        clearTimeout(storedValue[1]);
        this.store[key] = [value, timeHandler];
        return true;
    } 
    
    get(key: number): number {
        if(this.store[key]) {
            return this.store[key][0];
        }
        return -1;
    }
    
    count(): number {
        return Object.keys(this.store).length;
    }
}

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */