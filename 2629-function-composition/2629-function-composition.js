/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    if(functions.length === 0) return (x) => x;
    for(let i = functions.length - 2; i>=0; i--) {
        let f_1 = functions[i + 1]
        let f = functions[i]
        let nf = (x) => {
            x = f_1(x)
            return f(x)
        }
        functions[i] = nf
    }
    return functions[0];
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */