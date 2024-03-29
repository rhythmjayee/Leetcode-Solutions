/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums
    this.sum = nums.reduce((acc, v) => acc += v, 0)
};

ArrayWrapper.prototype.valueOf = function() {
    return this.sum
}

ArrayWrapper.prototype.toString = function() {
    return "["+String(this.nums)+"]"
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */